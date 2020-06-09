const {Client} = require('pg');
const auth = require('./auth');
const client = auth.getClient();

client.connect()
// b) Joins
//      1.) Join über Tierbestand und Tierart
    .then(() => client.query(
        `SELECT t.id, t.name, t.beschreibung, t.artid, a.name, a.beschreibung
           FROM tierbestand as t
           LEFT JOIN art as a`, 
        (err, res) => {
            console.log(err, res);
            pool.end();
        }
    ));