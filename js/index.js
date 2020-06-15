const createTab = require('./create_tables');
const deleteTab = require('./delete_tables');
const insertTab = require('./inserts');
const queries = require('./queries')

// AUFGABE 4 

// a) Erstellen und Löschen der Tabellen

//deleteTab.deleteTables();
//createTab.createTables();

// b) Datensätze einfügen

//insertTab.insertKlasse();
//insertTab.insertOrdnung();
//insertTab.insertFamilie();
//insertTab.insertGattung();
//insertTab.insertArt();
//insertTab.insertTierbestand();


// AUFGABE 5

// a) Operatorbaum

// Alle Tiere, die nach 2010 geboren wurden
//queries.getAnimalsBornAfter()

// Alle weiblichen Tiere
//queries.getFemaleAnimals()


// b) Joins

// Auswertung des Tierbestands mit Beschreibung der Art
//queries.joinSpeciesAnimals();

// Join Klassen mit Ordnungen
//queries.joinClassOrder();


// c) Mengenoperator

// Alle Tierarten, welche im Tierbestand vertreten sind
//queries.getSpeciesOfAnimals();

// Alle Familien, welche zu bestimmten Klassen gehören
//queries.getFamiliesOfClass()

// d) Gruppierung / Aggregatfunktion

// Anzahl an Tieren in Tierbestand gruppiert nach Klasse
//queries.countAnimalsInClass()

// Ältestes Tier selektieren
//queries.getOldestAnimal()

// e) Having 

// Alle Tiere, dessen Klassen mindestens 2 mal vertreten ist
//queries.getClassesExistingTwice()

// Gattung des jüngsten Tieres
//queries.getGenusOfyoungestAnimal()
