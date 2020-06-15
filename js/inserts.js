const {Client} = require("pg");
const auth = require("./auth");
const client = new Client(auth.getCredentials());

module.exports = {
    insertKlasse:function () {
        client.connect()
        .then(() => console.log("Successfully connected to database"))
        .then(() => client.query(
            `INSERT INTO klasse(
                id, name, beschreibung, legt_eier, kann_fliegen, hat_wirbel,
                hat_kiemen, ist_wechselwarm, anzahl_beine
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
                );`
        ))
        .then(() => client.query(
            `INSERT INTO klasse(
                id, name, beschreibung, legt_eier, kann_fliegen, hat_wirbel,
                hat_kiemen, ist_wechselwarm, anzahl_beine
            )
                VALUES(
                    2, 
                    'Reptil', 
                    'Das kennzeichnendste Merkmal der rezenten Reptilien ist ihre trockene, schleimlose, aus Hornschuppen bestehende Körperbedeckung. Von Vögeln und Säugetieren unterscheiden sie sich durch das Fehlen von Federn bzw. Haaren.',
                    true,
                    false,
                    true,
                    false,
                    true,
                    4 
                );`
        ))
        .then(() => client.query(
            `INSERT INTO klasse(
                id, name, beschreibung, legt_eier, kann_fliegen, hat_wirbel,
                hat_kiemen, ist_wechselwarm, anzahl_beine
            )
                VALUES(
                    3, 
                    'Vogel', 
                    'Die Vögel sind eine Klasse der Wirbeltiere, deren Vertreter als gemeinsame Merkmale unter anderem Flügel, eine aus Federn bestehende Körperbedeckung und einen Schnabel aufweisen. Vögel leben auf allen Kontinenten.',
                    true,
                    true,
                    true,
                    false,
                    false,
                    2 
                );`
        ))
        .then(() => client.query(
            `INSERT INTO klasse(
                id, name, beschreibung, legt_eier, kann_fliegen, hat_wirbel,
                hat_kiemen, ist_wechselwarm, anzahl_beine
            )
                VALUES(
                    4, 
                    'Amphibie', 
                    'Unter den Bezeichnungen Amphibien (Amphibia) oder Lurche werden alle Landwirbeltiere zusammengefasst, die sich, im Gegensatz zu den Amnioten („Nabeltieren“), nur in Gewässern fortpflanzen können.',
                    true,
                    false,
                    true,
                    true,
                    true,
                    4
                );`
        ))
        .then(() => client.query(
            `INSERT INTO klasse(
                id, name, beschreibung, legt_eier, kann_fliegen, hat_wirbel,
                hat_kiemen, ist_wechselwarm, anzahl_beine
            )
                VALUES(
                    5, 
                    'Fisch', 
                    'Fische oder Pisces (lateinisch piscis „Fisch“) sind aquatisch lebende Wirbeltiere mit Kiemen.',
                    true,
                    false,
                    true,
                    true,
                    false,
                    0
                );`
        ))
        
        .then(() => console.log("Test records for table 'Klasse' created"))

        .catch(e => console.log)
        .finally(() => client.end()).then(() => console.log("Connection ended"));
    },

    insertOrdnung:function () {
        client.connect()
        .then(() => console.log("Successfully connected to database"))
        .then(() => client.query(
            `INSERT INTO Ordnung(
                id, klassenId, name, beschreibung
            )
                VALUES(
                    1,
                    1,
                    'Nagetier',
                    'Die Nagetiere (Rodentia) sind eine Ordnung der Säugetiere (Mammalia). Mit etwa 2500[1] bis 2600[2] Arten stellen sie rund 40 % aller Säugetierspezies und sind somit die bei weitem artenreichste Ordnung dieser Gruppe.[1] Zugleich sind sie die Gruppe mit den meisten Neubeschreibungen innerhalb der Säugetiere; zwischen 2000 und 2017 wurde mindestens 248 Arten innerhalb der Ordnung neu beschrieben oder neu etabliert.'
                );`
        ))
        .then(() => client.query(
            `INSERT INTO Ordnung(
                id, klassenId, name, beschreibung
            )
                VALUES(
                    2,
                    1,
                    'Paarhufer',
                    'Die Paarhufer, auch Paarzehige Huftiere oder Paarzeher (Artiodactyla, früher auch Paraxonia), sind in der klassischen Systematik eine Ordnung der Säugetiere (Mammalia). Es handelt sich um überwiegend pflanzenfressende Tiere, die im Gegensatz zu den Unpaarhufern meist durch eine gerade Anzahl von Zehen (zwei oder vier) charakterisiert sind. Zu dieser Gruppe zählen einige der wirtschaftlich bedeutendsten Säugetiergruppen wie Rinder, Schweine, Kamele, Ziegen und Schafe, aber auch andere bekannte Tiere wie Giraffen, Flusspferde, Hirsche oder Antilopen.'
                );`
        ))
        .then(() => client.query(
            `INSERT INTO Ordnung(
                id, klassenId, name, beschreibung
            )
                VALUES(
                    3,
                    2,
                    'Schlangen',
                    'Schlangen (Plural von Schlange, von mittelhochdeutsch slange; zu slingen, sich winden, sich krümmen, schlingen, schleichen; altgriechisch ὄφεις ópheis; lateinisch serpentes, verwandt mit altgriechisch ἕρπειν herpein, deutsch ‚kriechen‘) sind eine Unterordnung der Schuppenkriechtiere. Sie stammen von echsenartigen Vorfahren ab. Gegenüber diesen ist der Körper stark verlängert und die Extremitäten wurden fast völlig zurückgebildet. Heute sind über 3600 Arten beschrieben.'
                );`
        ))
        .then(() => client.query(
            `INSERT INTO Ordnung(
                id, klassenId, name, beschreibung
            )
                VALUES(
                    4,
                    3,
                    'Sperlingsvögel',
                    'Sperlingsvögel sind im Vergleich zu den Vertretern anderer Familien eher kleine Vögel. Die Körperlänge reicht von 6,5 (Stummelschwanz-Zwergtyrann) bis zu 120 (Paradiesvögel) Zentimetern. Viele Sperlingsvögel der hohen Breitengrade sind Zugvögel, Standvögel finden sich dagegen vorwiegend bei den Arten der Subtropen und Tropen. Zu letzteren gehören die Arten in den Familien der Leierschwänze oder auch der Lappenvögel, bei denen das Flugvermögen schwach entwickelt ist.'
                );`
        ))

        .then(() => console.log("Test records for table 'Ordnung' created"))

        .catch(e => console.log)
        .finally(() => client.end()).then(() => console.log("Connection ended"));
    },

    insertFamilie:function () {
        client.connect()
        .then(() => console.log("Successfully connected to database"))
        .then(() => client.query(
            `INSERT INTO familie(
                id, ordnungsId, name, beschreibung
            )
                VALUES(
                    1,
                    1,
                    'Hörnchen',
                    'Hörnchen sind, anders als die meisten Nagetiere, zum größten Teil tagaktiv und ernähren sich vor allem von Pflanzenteilen, Früchten und Samen sowie von Insekten. In ihrer Größe variieren die Arten sehr stark, einzelne Arten sind sehr klein mit Kopf-Rumpf-Längen von etwa sieben Zentimetern bei einem Körpergewicht von etwa 15 Gramm und andere Arten erreichen Kopf-Rumpf-Längen von bis zu 65 Zentimetern und einem Gewicht von bis zu 6,5 Kilogramm. Der Körper ist vor allem bei den baumlebenden Arten meistens schlank mit langem und buschigem Schwanz, bodenlebende Arten wie die Murmeltiere sind in der Regel gedrungener und besitzen einen kürzeren Schwanz.'
                );`
        ))
        .then(() => client.query(
            `INSERT INTO familie(
                id, ordnungsId, name, beschreibung
            )
                VALUES(
                    2,
                    2,
                    'Giraffenartige',
                    'Die Giraffenartigen (Giraffidae) sind eine Familie der Paarhufer, die zwei Gattungen umfasst, die Giraffen und das Okapi. Sie stellen Nahverwandte der Hirsche und Hornträger dar. Im äußeren Erscheinungsbild unterscheiden sich die beiden Vertreter recht deutlich, gemeinsame verbindende Merkmale finden sich neben einem speziell ausgeprägten Eckzahn unter anderem in der Ausbildung von Hornzapfen als Stirnwaffen. Die Familie wurde im Jahr 1821 von John Edward Gray eingeführt, enthielt ursprünglich aber nur die Giraffen. Erst im Jahr 1901 mit der Entdeckung des Okapis kam ein weiterer Vertreter hinzu. Die Giraffen bestehen nach genetischen Untersuchungen heute aus vier Arten in sieben eigenständigen Populationen, das Okapi ist dagegen nur mit einer Art vertreten.'
                );`
        ))
        .then(() => client.query(
            `INSERT INTO familie(
                id, ordnungsId, name, beschreibung
            )
                VALUES(
                    3,
                    3,
                    'Giftnattern',
                    'Die Giftnattern (Elapidae) sind eine Familie der Schlangen (Serpentes), die etwa 250 Arten umfasst. Es handelt sich bei ihnen um die zweite große Gruppe von Giftschlangen neben den Vipern (Viperidae). Innerhalb der Giftnattern finden sich sehr viele Arten mit hochwirksamen Nervengiften, zum Beispiel die Taipane, Kobras, Mambas, Tigerottern oder Braunschlangen. Anders als die Nattern (Colubridae) produzieren Giftnattern ein giftiges Sekret, welches durch vorn im Kiefer stehende Giftzähne über den Giftapparat in ein Beutetier oder in einen potentiellen Feind injiziert werden kann.'
                );`
        ))
        .then(() => client.query(
            `INSERT INTO familie(
                id, ordnungsId, name, beschreibung
            )
                VALUES(
                    4,
                    4,
                    'Laubenvögel',
                    'Die Laubenvögel (Ptilonorhynchidae) sind eine Familie in der Ordnung der Sperlingsvögel (Passeriformes), die ausschließlich in Australien und auf Neuguinea vorkommen. Namengebend für die Familie ist der Laubenbau, der Balzplatz der Männchen, mit denen sie versuchen, ein Weibchen anzulocken. Diese Lauben werden von 17 der insgesamt 20 Arten innerhalb der Familie gebaut und mit Objekten geschmückt, die die Männchen häufig nach ihrer Farbe sammeln.'
                );`
        ))
        .then(() => console.log("Test records for table 'Familie' created"))

        .catch(e => console.log)
        .finally(() => client.end()).then(() => console.log("Connection ended"));
    
    },

    insertGattung:function () {
        client.connect()
        .then(() => console.log("Successfully connected to database"))
        .then(() => client.query(
            `INSERT INTO Gattung(
                id, familienId, name, beschreibung
            )
                VALUES(
                    1,
                    1,
                    'Rothörnchen',
                    'Trotz des Namens sind die Rothörnchen nicht rot. Sie sind sehr variabel gefärbt, die Oberseite ist beigebraun, olivbraun oder schwarzbraun; oft wird sie im Winter dunkler als im Sommer. Die Unterseite ist weiß beim Gemeinen Rothörnchen und braun beim Douglas-Hörnchen. Entlang der Flanke verläuft ein schwärzlicher Längsstreifen, der sich aber bei vielen Individuen kaum von der darunterliegenden Fellfarbe abhebt und dann unsichtbar ist. Die Kopfrumpflänge beträgt 20 cm, hinzu kommen etwa 12 cm Schwanz. Das Gewicht beträgt 150 bis 300 Gramm.'
                );`
        ))
        .then(() => client.query(
            `INSERT INTO Gattung(
                id, familienId, name, beschreibung
            )
                VALUES(
                    2,
                    2,
                    'Giraffen',
                    'Der Hals der Giraffen ist außergewöhnlich lang. Wie bei fast allen Säugetieren besteht die Halswirbelsäule gleichwohl aus nur sieben Halswirbeln, die aber stark verlängert sind. Der Hals wird von einer einzigen, sehr starken Sehne in einem Winkel von etwa 55° gehalten. Die Sehne verläuft vom Hinterkopf der Giraffe bis zum Steiß und ist für den „Höcker“ zwischen Hals und Körper verantwortlich. Der Ruhezustand hält Hals und Kopf in der aufrechten Position; um den Kopf nach unten zu bewegen, z. B. zum Trinken, muss die Giraffe Muskelarbeit aufbringen. Die Zunge kann 50 Zentimeter lang werden. Sie ist zum Greifen befähigt und im vorderen Bereich zum Schutz vor Sonnenbrand stark pigmentiert.'
                );`
        ))
        .then(() => client.query(
            `INSERT INTO Gattung(
                id, familienId, name, beschreibung
            )
                VALUES(
                    3,
                    3,
                    'Mambas',
                    'Mambas neigen dazu, nach einem Biss noch mehrmals zuzubeißen. Ihr hochwirksames Gift enthält vor allem verschiedene Neurotoxine und die ihnen eigenen Dendrotoxine. Ein Biss endet beim Menschen ohne Behandlung mit einem Antiserum in der Regel tödlich, bei der Gewöhnlichen Mamba (Dendroaspis angusticeps) wurde bisher jedoch erst ein Biss mit Todesfolge bei einem Kind nachgewiesen. Absolut lebensbedrohlich ist die Giftwirkung, wenn der Biss eine Vene trifft, dann bleiben für eine lebenserhaltende Therapie nur wenige Minuten Zeit.'
                );`
        ))
        .then(() => client.query(
            `INSERT INTO Gattung(
                id, familienId, name, beschreibung
            )
                VALUES(
                    4,
                    4,
                    'Katzenvögel',
                    'Die Katzenvögel (Ailuroedus) sind eine Gattung der Laubenvögel. Es werden drei Arten dieser Gattung zugerechnet. Alle Arten kommen auf Neuguinea und/oder Australien vor. Abgesehen von dem zu den Kragenlaubenvögeln gehörenden Braunbauch-Laubenvogel ist der Schwarzohr-Laubenvogel die einzige Katzenvogel-Art, die sowohl auf dem australischen Kontinent als auch auf Neuguinea vorkommt.'
                );`
        ))
        .then(() => console.log("Test records for table 'Gattung' created"))

        .catch(e => console.log)
        .finally(() => client.end()).then(() => console.log("Connection ended"));
    
    },

    insertArt:function () {
        client.connect()
        .then(() => console.log("Successfully connected to database"))
        .then(() => client.query(
            `INSERT INTO art(
                id, gattungsId, name, beschreibung
            )
                VALUES(
                    1,
                    1,
                    'Südwestliche Rothörnchen',
                    'Das Südwestliche Rothörnchen (Tamiasciurus fremonti; Synonym: Tamiasciurus hudsonicus fremonti) ist eine Art der Rothörnchen (Tamiasciurus) innerhalb der Hörnchen (Sciuridae). Es lebt in den zentralen Vereinigten Staaten östlich der Rocky Mountains. Die Art wurde lange als Unterart des Gemeinen Rothörnchens (Tamiasciurus hudsonicus) betrachtet, gilt allerdings heute als eigenständige Art.'
                );`
        ))
        .then(() => client.query(
            `INSERT INTO art(
                id, gattungsId, name, beschreibung
            )
                VALUES(
                    2,
                    2,
                    'Massai-Giraffe',
                    'Die Massai-Giraffe (Giraffa tippelskirchi) ist, nach neuesten Erkenntnissen, eine eigenständige Art innerhalb der Gattung der Giraffen (Giraffa) der Familie der Giraffenartigen (Giraffidae). Männchen werden bis zu 6 Meter hoch und erreichen eine Schulterhöhe von bis zu 3,5 Meter. Die Weibchen sind in der Regel etwas kleiner und leichter. Das Muster des Haarkleids besteht aus dunklen Flecken, die sich von der helleren Grundfarbe abheben. Die Flecken dienen der Hitzeabgabe. Die Art ist im Südosten Afrikas in den Grassteppen und Buschsavannen im südlichen Kenia und Tansania beheimatet.'
                );`
        ))
        .then(() => client.query(
            `INSERT INTO art(
                id, gattungsId, name, beschreibung
            )
                VALUES(
                    3,
                    3,
                    'Grüne Mamba',
                    'Die Grüne Mamba (Dendroaspis viridis) ist eine Art der Mambas, die in Benin, Gambia, Ghana, Guinea, Kamerun, Liberia, Senegal, Sierra Leone, Togo, Sansibar und der Zentralafrikanischen Republik beheimatet ist. Diese in der Regel bis zu zwei Meter lange Giftschlange ist hellgrün und am Schwanz gelblich gefärbt. Am Schwanz und Kopf sind die Schuppen schwarz umrandet. Die Rückenschuppen dieser Schlange sind ungewöhnlich groß.'
                );`
        ))
        .then(() => client.query(
            `INSERT INTO art(
                id, gattungsId, name, beschreibung
            )
                VALUES(
                    4,
                    4,
                    'Schwarzohr-Laubenvögel',
                    'Der Schwarzohr-Laubenvogel ist mit einer Körperlänge von bis zu 29 Zentimeter einer der mittelgroßen Vertreter in der Familie der Laubenvögel. Er zählt zu den Arten, zu deren Balzverhalten kein Bau einer Laube durch das Männchen gehört.[3] Sie sind monogam und gehen eine mehrjährige Paarbindung ein. Beide Geschlechter verteidigen ganzjährig ein Revier.'
                );`
        ))
        .then(() => console.log("Test records for table 'Art' created"))

        .catch(e => console.log)
        .finally(() => client.end()).then(() => console.log("Connection ended"));
    
    },

    insertTierbestand:function () {
        client.connect()
        .then(() => console.log("Successfully connected to database"))
        .then(() => client.query(
            `INSERT INTO tierbestand(
                id, artId, name, geburtsdatum, geschlecht
            )
                VALUES(
                    1,
                    1,
                    'Robert Rothörnchen',
                    '23.06.2013',
                    'm'
                );`
        ))
        .then(() => client.query(
            `INSERT INTO tierbestand(
                id, artId, name, geburtsdatum, geschlecht
            )
                VALUES(
                    2,
                    2,
                    'Gabi Giraffe',
                    '16.02.2011',
                    'w'
                );`
        ))
        .then(() => client.query(
            `INSERT INTO tierbestand(
                id, artId, name, geburtsdatum, geschlecht
            )
                VALUES(
                    3,
                    3,
                    'Markus Mamba',
                    '01.11.2008',
                    'm'
                );`
        ))
        .then(() => client.query(
            `INSERT INTO tierbestand(
                id, artId, name, geburtsdatum, geschlecht
            )
                VALUES(
                    4,
                    4,
                    'Laura Laubenvogel',
                    '23.06.2003',
                    'w'
                );`
        ))
        .then(() => console.log("Test records for table 'Tierbestand' created"))

        .catch(e => console.log)
        .finally(() => client.end()).then(() => console.log("Connection ended"));
    
    }
}