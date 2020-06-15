package Tierlexikon.Model;

public class AnimalClass {
	private int id;
	private String name;
	private String beschreibung;
	private boolean legtEier, kannFliegen, hatWirbel, hatKiemen, istWechselwarm;
	private int anzahlBeine;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public boolean isLegtEier() {
		return legtEier;
	}
	public void setLegtEier(boolean legtEier) {
		this.legtEier = legtEier;
	}
	public boolean isKannFliegen() {
		return kannFliegen;
	}
	public void setKannFliegen(boolean kannFliegen) {
		this.kannFliegen = kannFliegen;
	}
	public boolean isHatWirbel() {
		return hatWirbel;
	}
	public void setHatWirbel(boolean hatWirbel) {
		this.hatWirbel = hatWirbel;
	}
	public boolean isHatKiemen() {
		return hatKiemen;
	}
	public void setHatKiemen(boolean hatKiemen) {
		this.hatKiemen = hatKiemen;
	}
	public boolean isIstWechselwarm() {
		return istWechselwarm;
	}
	public void setIstWechselwarm(boolean istWechselwarm) {
		this.istWechselwarm = istWechselwarm;
	}
	public int getAnzahlBeine() {
		return anzahlBeine;
	}
	public void setAnzahlBeine(int anzahlBeine) {
		this.anzahlBeine = anzahlBeine;
	}
	@Override
	public String toString() {
		return "Klassen-ID: " + this.id + "\n" +
				"Klasse: " + this.name + "\n" + 
				"Hat Wirbel: " + this.hatWirbel + "\n" + 
				"Hat Kiemen: " + this.hatKiemen + "\n" + 
				"Kann fliegen: " + this.kannFliegen + "\n" + 
				"Legt Eier: " + this.legtEier + "\n" + 
				"Ist wechselwarm: " + this.istWechselwarm + "\n" + 
				"Anzahl Beine: " + this.anzahlBeine + "\n" + 
				"Beschreibung: " + this.beschreibung;
	}
}
