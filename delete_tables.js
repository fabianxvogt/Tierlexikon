const {Client} = require("pg");
const auth = require("./auth");
const client = new Client(auth.getCredentials());

module.exports = {
    deleteTables:function () {
        client.connect()
        .then(() => console.log("Successfully connected to database"))
        .then(() => client.query("DROP TABLE IF EXISTS tierbestand"))
        .then(() => client.query("DROP TABLE IF EXISTS art"))
        .then(() => client.query("DROP TABLE IF EXISTS gattung"))
        .then(() => client.query("DROP TABLE IF EXISTS familie"))
        .then(() => client.query("DROP TABLE IF EXISTS ordnung"))
        .then(() => client.query("DROP TABLE IF EXISTS klasse"))

        .then(() => console.log("tables deleted"))
        .catch(e => console.log)
        .finally(() => client.end()).then(() => console.log("Connection ended"));        
    }
}