package Tierlexikon.Model;

public class AnimalFamily {
	private int id, ordnungsId;
	private String name, beschreibung;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getOrdnungsId() {
		return ordnungsId;
	}
	public void setOrdnungsId(int ordnungsId) {
		this.ordnungsId = ordnungsId;
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
		return "Familien-ID: " + this.id + "\n" +
				"Familie: " + this.name + "\n" + 
				"Ordnungs-ID: " + this.ordnungsId + "\n" +  
				"Beschreibung: " + this.beschreibung;
	}
}
