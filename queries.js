const {Pool, Client} = require('pg');
const auth = require('./auth');
const client = new Client(auth.getCredentials());

module.exports = {
    getAnimalsBornAfter:function () {
        client.connect()
        .then(() => console.log("Successfully connected to database"))
        .then(() => console.log("Alle Tiere, die nach 2010 geboren wurden"))
        .then(client.query(
            `SELECT t.id, t.name as Tiername, t.geburtsdatum, t.geschlecht 
                FROM tierbestand as t 
                WHERE t.geburtsdatum > '31.12.2010'`, 
            (err, res) => {
                if (err) throw err
                res.rows.forEach(element => {
                    console.log(element)
                });
                client.end();
            }
        ))
    },
    getFemaleAnimals:function () {
        client.connect()
        .then(() => console.log("Successfully connected to database"))
        .then(() => console.log("Alle weiblichen Tiere..."))
        .then(client.query(
            `SELECT t.id, t.name as Tiername, t.geburtsdatum, t.geschlecht
                FROM tierbestand as t 
                WHERE t.geschlecht = 'w'`, 
            (err, res) => {
                if (err) throw err
                res.rows.forEach(element => {
                    console.log(element)
                });
                client.end();
            }
        ))
    },
    joinSpeciesAnimals:function () {
        client.connect()
        .then(() => console.log("Successfully connected to database"))
        .then(() => console.log("Join Tierbestand und Art..."))
        .then(client.query(
            `SELECT t.id, t.name as Tiername, t.geburtsdatum, t.geschlecht, t.artid, a.name as Art, a.beschreibung 
                FROM tierbestand as t 
                INNER join art as a on t.artid = a.id`, 
            (err, res) => {
                if (err) throw err
                res.rows.forEach(element => {
                    console.log(element)
                });
                client.end();
            }
        ))
    },
    joinClassOrder:function () {
        client.connect()
        .then(() => console.log("Successfully connected to database"))
        .then(() => console.log("Join Klasse und Ordnung..."))
        
        .then(client.query(
            `SELECT o.id, o.name as Ordung, o.beschreibung, k.name as Klasse, k.beschreibung
                FROM ordnung as o
                INNER JOIN klasse as k on o.klassenid = k.id`, 
            (err, res) => {
                if (err) throw err
                res.rows.forEach(element => {
                    console.log(element)
                });
                client.end();
            }
        ))
    },
    getSpeciesOfAnimals:function () {
        client.connect()
        .then(() => console.log("Successfully connected to database"))
        .then(() => console.log("Alle Tierarten im Tierbestand selektieren..."))
        .then(client.query(
            `SELECT a.id, a.name as Art
            FROM art as a 
            WHERE EXISTS (
                SELECT * 
                FROM tierbestand as t
                WHERE a.id = t.artid);`,
            (err, res) => {
                if (err) throw err
                res.rows.forEach(element => {
                    console.log(element)
                });
                client.end();
            }
        ))
    },
    getFamiliesOfClass:function () {
        client.connect()
        .then(() => console.log("Successfully connected to database"))
        .then(() => console.log(
            "Alle Tierfamilien, welche zur Klasse der Säugetiere oder Reptilien gehören..."))
        .then(client.query(
            `SELECT f.id, f.name as Familie
            FROM familie as f
            INNER JOIN ordnung as o ON f.ordnungsid = o.id
            INNER JOIN klasse as k ON o.klassenid = k.id
            WHERE k.id in (1,2);`,
            (err, res) => {
                if (err) throw err
                res.rows.forEach(element => {
                    console.log(element)
                });
                client.end();
            }
        ))
    },
    countAnimalsInClass:function () {
        client.connect()
        .then(() => console.log("Successfully connected to database"))
        .then(() => console.log(
            "Anzahl der Tiere pro Tierklasse..."))
        .then(client.query(
            `SELECT COUNT(t.id), k.name as Klasse
            FROM tierbestand as t
            INNER JOIN art as a on t.artid = a.id
            INNER JOIN gattung as g on a.gattungsid = g.id
            INNER JOIN familie as f ON g.familienid = f.id
            INNER JOIN ordnung as o ON f.ordnungsid = o.id
            INNER JOIN klasse as k ON o.klassenid = k.id
            Group by k.name;`,
            (err, res) => {
                if (err) throw err
                res.rows.forEach(element => {
                    console.log(element)
                });
                client.end();
            }
        ))
    },
    getOldestAnimal:function () {
        client.connect()
        .then(() => console.log("Successfully connected to database"))
        .then(() => console.log(
            "Ältestes Tier im Tierbestand..."))
        .then(client.query(
            `SELECT t.id, t.name, t.geburtsdatum, t.geschlecht
            FROM tierbestand as t
            WHERE geburtsdatum = (
                SELECT MIN(t.geburtsdatum) as Geburtstag
                FROM tierbestand as t
            )`,
            (err, res) => {
                if (err) throw err
                res.rows.forEach(element => {
                    console.log(element)
                });
                client.end();
            }
        ))
    },
    getClassesExistingTwice:function () {
        client.connect()
        .then(() => console.log("Successfully connected to database"))
        .then(() => console.log(
            "Alle Klassen, die mindestens 2 mal vertreten sind..."))
        .then(client.query(
            `SELECT COUNT(k.id), k.name
            FROM tierbestand as t
            INNER JOIN art as a on t.artid = a.id
            INNER JOIN gattung as g on a.gattungsid = g.id
            INNER JOIN familie as f ON g.familienid = f.id
            INNER JOIN ordnung as o ON f.ordnungsid = o.id
            INNER JOIN klasse as k ON o.klassenid = k.id
            GROUP BY k.name
            HAVING COUNT(k.id) > 1`,
            (err, res) => {
                if (err) throw err
                res.rows.forEach(element => {
                    console.log(element)
                });
                client.end();
            }
        ))
    },
    getGenusOfyoungestAnimal:function () {
        client.connect()
        .then(() => console.log("Successfully connected to database"))
        .then(() => console.log(
            "Gattung des jüngsten Tieres..."))
        .then(client.query(
            `SELECT t.id, t.name, t.geburtsdatum, g.name as Gattung
            FROM tierbestand as t
            INNER JOIN art as a on t.artid = a.id
            INNER JOIN gattung as g on a.gattungsid = g.id
            GROUP BY t.id, g.name
            HAVING t.geburtsdatum = (
                SELECT MAX(t.geburtsdatum) 
                FROM tierbestand as t
            )`,
            (err, res) => {
                if (err) throw err
                res.rows.forEach(element => {
                    console.log(element)
                });
                client.end();
            }
        ))
    },
}