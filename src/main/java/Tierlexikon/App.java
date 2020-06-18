package Tierlexikon;

import java.util.List;
import java.util.Scanner;

import Tierlexikon.Utils.ConsoleUtils;
import Tierlexikon.Model.*;
import Tierlexikon.Pg.Pg;

public class App {

	private static Scanner s = new Scanner(System.in);
	private static ConsoleUtils c = new ConsoleUtils();
	
	private static Pg pg = new Pg(
			"jdbc:postgresql://127.0.0.1:5432/tierlexikon", 
            "postgres",
            "postgres"
			);
	
	private static String[] MAIN_MENU_CHOICES = {
			"1. Tierbestand anzeigen", 
			"2. Neues Tier erfassen",
			"3. Tier löschen",
			"4. Detailinformationen zu Tieren",
			"5. Tierklassen anzeigen",
			"6. Tierordnungen anzeigen",
			"7. Tierfamilien anzeigen",
			"8. Tiergattungen anzeigen",
			"9. Tierarten anzeigen",
			"10. Neue Klasse erfassen",
			"11. Neue Ordnung erfassen",
			"12. Neue Familie erfassen",
			"13. Neue Gattung erfassen",
			"14. Neue Art erfassen",
			"15. Beenden"
	};
	private static char[] GENDERS = {
			'w',
			'm'
	};
	public static void main(String[] args) {
		welcomeDialog();

		List<Animal> animals;
		List<AnimalClass> animalClasses;
		List<AnimalOrder> animalOrders;
		List<AnimalFamily> animalFamilies;
		List<AnimalGenus> animalGenus;
		List<AnimalSpecies> animalSpecies;
		
		boolean exit = false;
		
		while (exit == false) {
			int option = c.selectChoice(MAIN_MENU_CHOICES);
			switch (option) {
			case 1:
				animals = pg.getAnimals(0);
				for (Animal animal : animals)
					c.print(animal.toString());
				break;
			case 2:
				newAnimal();
				break;
			case 3:
				deleteAnimal();
				break;
			case 4:
				details();
				break;	
			case 5:
				animalClasses = pg.getAnimalClasses(0);
				for (AnimalClass cls : animalClasses) {
					c.print(cls.toString());
					c.print("");
				}
				break;
			case 6:
				animalOrders = pg.getAnimalOrders(0);
				for (AnimalOrder o : animalOrders) {
					c.print(o.toString());
					c.print("");
				}				
				break;
			case 7:
				animalFamilies = pg.getAnimalFamilies(0);
				for (AnimalFamily f : animalFamilies) {
					c.print(f.toString());
					c.print("");
				}
				break;
			case 8:
				animalGenus = pg.getAnimalGenus(0);
				for (AnimalGenus g : animalGenus) {
					c.print(g.toString());
					c.print("");
				}
				break;
			case 9:
				animalSpecies = pg.getAnimalSpecies(0);
				for (AnimalSpecies s : animalSpecies) {
					c.print(s.toString());
					c.print("");
				}
				break;
			case 10:
				newAnimalClass();
				break;
			case 11:
				newAnimalOrder();
				break;
			case 12:
				newAnimalFamily();
				break;
			case 13:
				newAnimalGenus();
				break;
			case 14:
				newAnimalSpecies();
				break;
			case 15:
				// Exit
				return;
			default:
				break;
			}
			backToMainMenu();
		}		
	}

	private static void welcomeDialog() {
		c.print("  Tierlexikon  ");
		c.print("---------------");
		c.print("von Fabian Vogt");
		c.print("Matr.Nr: 0570800");
		c.print("");		
	}
	private static void deleteAnimal() {
		List<Animal> animals = pg.getAnimals(0);
		String[] animalChoices = new String[animals.size()];
		for (int i = 0; i < animals.size(); i++)
			animalChoices[i] = (i+1) + ". " + animals.get(i).getName();
		c.print("Tier zum Löschen auswählen:");
		int choice = c.selectChoice(animalChoices);
		if (!c.confirm())
			return;
		if (pg.deleteAnimal(animals.get(choice-1).getId()))
			c.print("Tier wurde gelöscht!");
	}
	private static void newAnimal() {
		// set name, gender, birthday
		c.print("Neues Tier erfassen");
		Animal animal = new Animal();
		c.print("Namen eingeben");
		animal.setName(c.inputString(1, 30));
		c.print("Geburtsdatum eingeben");
		animal.setGeburtsdatum(c.inputDate());
		c.print("Geschlecht eingeben");
		animal.setGeschlecht(c.inputChar(GENDERS));
		
		// set species
		List<AnimalSpecies> species = pg.getAnimalSpecies(0);
		String[] speciesChoices = new String[species.size()];
		for (int i = 0; i < species.size(); i++)
			speciesChoices[i] = (i+1) + ". " + species.get(i).getName();
		c.print("Art auswählen:");
		int choice = c.selectChoice(speciesChoices);
		animal.setArtId(species.get(choice-1).getId());
		
		// set key
		animal.setId(pg.getHighestKeyAnimals()+1);
		
		// insert
		if (pg.insertAnimal(animal))
			c.print("Neues Tier ("+ animal.getName() +") erfasst");
		else
			c.error("Tier konnte nicht gespeichert werden!");
	}
	private static void newAnimalSpecies() {
		// set name, gender, birthday
		c.print("Neue Art erfassen");
		AnimalSpecies species = new AnimalSpecies();
		c.print("Namen eingeben");
		species.setName(c.inputString(1, 30));
		c.print("Beschreibung eingeben:");
		species.setBeschreibung(c.inputString(1, 1000));
		
		List<AnimalGenus> genus = pg.getAnimalGenus(0);
		String[] genusChoices = new String[genus.size()];
		
		for (int i = 0; i < genus.size(); i++)
			genusChoices[i] = (i+1) + ". " + genus.get(i).getName();
		
		c.print("Gattung auswählen: ");
		int choice = c.selectChoice(genusChoices);
		species.setGattungsId(genus.get(choice-1).getId());
		species.setId(pg.getHighestKeyAnimalSpecies()+1);

		// insert
		if (pg.insertAnimalSpecies(species))
			c.print("Neue Art ("+ species.getName() +") erfasst");
		else
			c.error("Art konnte nicht gespeichert werden!");
	}
	private static void newAnimalGenus() {
		// set name, gender, birthday
		c.print("Neue Gattung erfassen");
		AnimalGenus genus = new AnimalGenus();
		c.print("Namen eingeben");
		genus.setName(c.inputString(1, 30));
		c.print("Beschreibung eingeben:");
		genus.setBeschreibung(c.inputString(1, 1000));
		
		List<AnimalFamily> families = pg.getAnimalFamilies(0);
		String[] familyChoices = new String[families.size()];
		
		for (int i = 0; i < families.size(); i++)
			familyChoices[i] = (i+1) + ". " + families.get(i).getName();
		
		c.print("Familie auswählen: ");
		int choice = c.selectChoice(familyChoices);
		genus.setFamilienId(families.get(choice-1).getId());
		genus.setId(pg.getHighestKeyAnimalGenus()+1);

		// insert
		if (pg.insertAnimalGenus(genus))
			c.print("Neue Gattung ("+ genus.getName() +") erfasst");
		else
			c.error("Gattung konnte nicht gespeichert werden!");
	}
	private static void newAnimalFamily() {
		// set name, gender, birthday
		c.print("Neue Familie erfassen");
		AnimalFamily family = new AnimalFamily();
		c.print("Namen eingeben");
		family.setName(c.inputString(1, 30));
		c.print("Beschreibung eingeben:");
		family.setBeschreibung(c.inputString(1, 1000));
		
		List<AnimalOrder> orders = pg.getAnimalOrders(0);
		String[] orderChoices = new String[orders.size()];
		
		for (int i = 0; i < orders.size(); i++)
			orderChoices[i] = (i+1) + ". " + orders.get(i).getName();
		
		c.print("Ordnung auswählen: ");
		int choice = c.selectChoice(orderChoices);
		family.setOrdnungsId(orders.get(choice-1).getId());
		family.setId(pg.getHighestKeyAnimalFamilies()+1);

		// insert
		if (pg.insertAnimalFamily(family))
			c.print("Neue Familie ("+ family.getName() +") erfasst");
		else
			c.error("Familie konnte nicht gespeichert werden!");
	}
	private static void newAnimalOrder() {
		// set name, gender, birthday
		c.print("Neue Ordnung erfassen");
		AnimalOrder order = new AnimalOrder();
		c.print("Namen eingeben");
		order.setName(c.inputString(1, 30));
		c.print("Beschreibung eingeben:");
		order.setBeschreibung(c.inputString(1, 1000));
		
		List<AnimalClass> classes = pg.getAnimalClasses(0);
		String[] classChoices = new String[classes.size()];
		
		for (int i = 0; i < classes.size(); i++)
			classChoices[i] = (i+1) + ". " + classes.get(i).getName();
		
		c.print("Klasse auswählen: ");
		int choice = c.selectChoice(classChoices);
		order.setClassId(classes.get(choice-1).getId());
		order.setId(pg.getHighestKeyAnimalOrders()+1);

		// insert
		if (pg.insertAnimalOrder(order))
			c.print("Neue Ordnung ("+ order.getName() +") erfasst");
		else
			c.error("Ordnung konnte nicht gespeichert werden!");
	}
	
	private static void newAnimalClass() {
		// set name, gender, birthday
		c.print("Neue Klasse erfassen");
		AnimalClass cls = new AnimalClass();
		c.print("Namen eingeben");
		cls.setName(c.inputString(1, 30));
		c.print("Beschreibung eingeben:");
		cls.setBeschreibung(c.inputString(1, 1000));
		c.print("Klasse ist wechselwarm?");
		cls.setIstWechselwarm(c.inputBool());
		c.print("Klasse hat Wirbel?");
		cls.setHatWirbel(c.inputBool());
		c.print("Klasse hat Kiemen?");
		cls.setHatKiemen(c.inputBool());
		c.print("Klasse kann fliegen?");
		cls.setKannFliegen(c.inputBool());
		c.print("Klasse legt Eier?");
		cls.setLegtEier(c.inputBool());
		c.print("Wie viele Beine haben Tiere dieser Klasse?");
		cls.setAnzahlBeine(c.inputInt(0, 8));
		
		cls.setId(pg.getHighestKeyAnimalClasses()+1);

		// insert
		if (pg.insertAnimalClass(cls))
			c.print("Neue Klasse ("+ cls.getName() +") erfasst");
		else
			c.error("Klasse konnte nicht gespeichert werden!");
	}
	private static void details() {
		List<Animal> animals = pg.getAnimals(0);
		int currentAnimal = 0;
		while(true) {
			if (currentAnimal < 0) 
				currentAnimal = animals.size()-1;
			if (currentAnimal > animals.size()-1)
				currentAnimal = 0;
			
			AnimalSpecies species = pg.getAnimalSpecies(animals.get(currentAnimal).getArtId()).get(0);
			AnimalGenus genus = pg.getAnimalGenus(species.getGattungsId()).get(0);
			AnimalFamily family = pg.getAnimalFamilies(genus.getFamilienId()).get(0);
			AnimalOrder order = pg.getAnimalOrders(family.getOrdnungsId()).get(0);
			AnimalClass cls = pg.getAnimalClasses(order.getClassId()).get(0);
			
			c.print(animals.get(currentAnimal).toString());
			c.print("");
			c.print("Informationen zur Art:");
			c.print(species.toString());
			c.print("");
			c.print("Informationen zur Gattung:");
			c.print(genus.toString());
			c.print("");
			c.print("Informationen zur Familie:");
			c.print(family.toString());
			c.print("");
			c.print("Informationen zur Ordnung:");
			c.print(order.toString());
			c.print("");
			c.print("Informationen zur Klasse:");
			c.print(cls.toString());
			c.print("");
			c.print("Eingabe ('P' = vorheriges Tier, 'N' = nächstes Tier, 'M' = Zurück zum Menu):");
			char[] allowed = {'p', 'n', 'm'};
			switch (c.inputChar(allowed)) {
			case 'P':
				currentAnimal--;
				break;
			case 'N':
				currentAnimal++;
				break;
			case 'M':
				return;
			default:
				break;
			} 
		}
			
	}
	private static void backToMainMenu() {
		c.print("Dücken Sie Enter um zurück zum Hauptmenu zu kommen.");
		s.nextLine();
	}
}

