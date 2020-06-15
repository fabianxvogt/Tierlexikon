package Tierlexikon.Model;

public class AnimalSpecies {
	private int id, gattungsId;
	private String name, beschreibung;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getGattungsId() {
		return gattungsId;
	}
	public void setGattungsId(int gattungsId) {
		this.gattungsId = gattungsId;
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
		return "Art-ID: " + this.id + "\n" +
				"Art: " + this.name + "\n" + 
				"Gattungs-ID: " + this.gattungsId + "\n" +  
				"Beschreibung: " + this.beschreibung;
	}
}
