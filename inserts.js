const {Client} = require('pg');
const auth = require('./auth');
const client = auth.getClient();

client.connect()
.then(() => client.query(
    `INSERT INTO klasse(
            id, 
            name, 
            beschreibung,
            legt_eier,
            kann_fliegen,
            hat_wirbel,
            hat_kiemen,
            ist_wechselwarm,
            anzahl_beine
        )
        VALUES(
            1, 
            'Säugetier', 
            'Die Säugetiere (Mammalia) sind eine Klasse der Wirbeltiere. Zu ihren kennzeichnenden Merkmalen gehören das Säugen des Nachwuchses mit Milch, die in den Milchdrüsen der Weibchen produziert wird, sowie das Fell aus Haaren, das sie in Kombination mit der gleichwarmen Körpertemperatur relativ unabhängig von der Umgebungstemperatur macht. Bis auf wenige Ausnahmen (Kloakentiere) sind Säugetiere lebendgebärend. Säugetiere sind an Land am artenreichsten verbreitet, doch bevölkern sie auch Luft und Wasser. Das Verhaltensspektrum der Säugetiere ist breit und flexibel, einige Gruppen zeigen komplexe soziale Gefüge.',
            false,
            false,
            true,
            false,
            false,
            4 
        )`
    ));