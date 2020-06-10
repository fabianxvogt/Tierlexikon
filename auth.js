const dbName = "tierlexikon"
const credentials = {
    user: "postgres",
    password: "postgres",
    host: "localhost",
    port: "5432",
    database: dbName
}
module.exports = {
    getDbName:function () {
        return dbName;
    },
    getCredentials:function () {
        return credentials;
    }
};