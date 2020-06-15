package Tierlexikon.Model;

public class AnimalOrder {
	private int id, klassenId;
	private String name, beschreibung;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getClassId() {
		return klassenId;
	}
	public void setClassId(int klassenId) {
		this.klassenId = klassenId;
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
		return "Ordnungs-ID: " + this.id + "\n" +
				"Ordnung: " + this.name + "\n" + 
				"Klassen-ID: " + this.klassenId + "\n" +  
				"Beschreibung: " + this.beschreibung;
	}
}
