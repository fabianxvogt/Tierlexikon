package Tierlexikon.Model;

import java.time.LocalDate;
public class Animal {
	private int id;
	private int artId;
	private String name;
	private String beschreibung;
	private LocalDate geburtsdatum;
	private char geschlecht;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getArtId() {
		return artId;
	}
	public void setArtId(int artId) {
		this.artId = artId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBeschreibung() {
		return beschreibung;
	}
	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}
	public LocalDate getGeburtsdatum() {
		return geburtsdatum;
	}
	public void setGeburtsdatum(LocalDate geburtsdatum) {
		this.geburtsdatum = geburtsdatum;
	}
	public char getGeschlecht() {
		return geschlecht;
	}
	public void setGeschlecht(char geschlecht) {
		this.geschlecht = geschlecht;
	}
	@Override
	public String toString() {
		return 	"ID: " + this.id + "\n" +
				"Name: " + this.name + "\n" +
				"Geschlecht: " + this.geschlecht + "\n" +
				"Geburtstag: " + this.geburtsdatum + "\n" +
				"Art: " + this.artId + "\n";
	}
}
