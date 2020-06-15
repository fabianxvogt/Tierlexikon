package Tierlexikon.Model;

public class AnimalGenus {
	private int id, familienId;
	private String name, beschreibung;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getFamilienId() {
		return familienId;
	}
	public void setFamilienId(int familienId) {
		this.familienId = familienId;
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
	@Override
	public String toString() {
		return "Gattungs-ID: " + this.id + "\n" +
				"Gattung: " + this.name + "\n" + 
				"Familien-ID: " + this.familienId + "\n" +  
				"Beschreibung: " + this.beschreibung;
	}
}
