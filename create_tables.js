const {Client} = require('pg');
const auth = require('./auth');
const client = auth.getClient();

module.exports = {
    createTables:function () {
        client.connect()
        .then(() => console.log("Successfully connected to database"))

        //create tables
        .then(() => client.query(
            `CREATE TABLE Klasse(
                id SERIAL PRIMARY KEY, 
                name VARCHAR(30) NOT NULL, 
                beschreibung VARCHAR(50),
                legt_eier BOOLEAN,
                kann_fliegen BOOLEAN,
                hat_wirbel BOOLEAN,
                hat_kiemen BOOLEAN,
                ist_wechselwarm BOOLEAN,
                anzahl_beine INTEGER
            )`
        ))
        .then(() => client.query(
            `CREATE TABLE Ordnung(
                id SERIAL PRIMARY KEY,
                klassenId SERIAL REFERENCES klasse(id),
                name VARCHAR(30) NOT NULL, 
                beschreibung VARCHAR(50)
            )`
        ))
        .then(() => client.query(
            `CREATE TABLE Familie(
                id SERIAL PRIMARY KEY,
                ordnungsId SERIAL REFERENCES Ordnung(id),
                name VARCHAR(30) NOT NULL, 
                beschreibung VARCHAR(50)
            )`
        ))
        .then(() => client.query(
            `CREATE TABLE Gattung(
                id SERIAL PRIMARY KEY,
                familienId SERIAL REFERENCES Familie(id),
                name VARCHAR(30) NOT NULL, 
                beschreibung VARCHAR(50)
            )`
        ))
        .then(() => client.query(
            `CREATE TABLE Art(
                id SERIAL PRIMARY KEY,
                gattungsId SERIAL REFERENCES Gattung(id),
                name VARCHAR(30) NOT NULL, 
                beschreibung VARCHAR(50)
            )`
        ))
        .then(() => client.query(
            `CREATE TABLE Tierbestand(
                id SERIAL PRIMARY KEY,
                artId SERIAL REFERENCES Art(id),
                name VARCHAR(30) NOT NULL, 
                beschreibung VARCHAR(50)
            )`
        ))
        .then(() => console.log("tables created"))

        .catch(e => console.log)
        .finally(() => client.end()).then(() => console.log("Connection ended"));
    }
}
