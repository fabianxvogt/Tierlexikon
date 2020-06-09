const {Client} = require('pg');

const dbName = "tierlexikon"
const client = new Client({
    user: "postgres",
    password: "postgres",
    host: "localhost",
    port: "5432",
    database: dbName
})
module.exports = {
    getClient: function () {
      return client;
    }
}