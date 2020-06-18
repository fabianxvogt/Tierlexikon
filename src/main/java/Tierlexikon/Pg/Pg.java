package Tierlexikon.Pg;

import Tierlexikon.Model.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Pg {
	private String url, user, pw;
	public Pg (String url, String user, String pw) {
		this.url = url;
		this.user = user;
		this.pw = pw;
		
	}
	public List<Animal> getAnimals(int animalId) {
		String sql = "SELECT * FROM tierbestand";
		if (animalId > 0)
			sql += " WHERE id =" + animalId;
		try (Connection conn = DriverManager.getConnection(
                this.url, this.user, this.pw);
		PreparedStatement preparedStatement = conn.prepareStatement(sql)) {

            ResultSet resultSet = preparedStatement.executeQuery();
            List<Animal> animals = new ArrayList<Animal>();
            while (resultSet.next()) {
            	
            	int id = resultSet.getInt("id");
            	int artId = resultSet.getInt("artid");
            	String name = resultSet.getString("name");
            	String beschreibung = resultSet.getString("beschreibung");
            	LocalDate geburtsdatum = resultSet.getDate("geburtsdatum").toLocalDate();
            	char geschlecht = resultSet.getString("geschlecht").charAt(0);

                Animal obj = new Animal();
                obj.setId(id);
                obj.setArtId(artId);
                obj.setName(name);
                obj.setBeschreibung(beschreibung);
                obj.setGeburtsdatum(geburtsdatum);
                obj.setGeschlecht(geschlecht);

                animals.add(obj);
            }
            return animals;
		} catch (SQLException e) {
			System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
		} catch (Exception e) {
	        e.printStackTrace();
	    }
		return null;
	}
	public List<AnimalSpecies> getAnimalSpecies(int speciesId) {
		String sql = "SELECT * FROM art";
		if (speciesId > 0)
			sql += " WHERE id =" + speciesId;
		try (Connection conn = DriverManager.getConnection(
                this.url, this.user, this.pw);
		PreparedStatement preparedStatement = conn.prepareStatement(sql)) {

            ResultSet resultSet = preparedStatement.executeQuery();
            List<AnimalSpecies> animalSpecies = new ArrayList<AnimalSpecies>();
            while (resultSet.next()) {
            	
            	int id = resultSet.getInt("id");
            	int gattungsId = resultSet.getInt("gattungsid");
            	String name = resultSet.getString("name");
            	String beschreibung = resultSet.getString("beschreibung");

                AnimalSpecies obj = new AnimalSpecies();
                obj.setId(id);
                obj.setGattungsId(gattungsId);
                obj.setName(name);
                obj.setBeschreibung(beschreibung);

                animalSpecies.add(obj);
            }
            return animalSpecies;
		} catch (SQLException e) {
			System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
		} catch (Exception e) {
	        e.printStackTrace();
	    }
		return null;
	}
	public List<AnimalGenus> getAnimalGenus(int genusId) {
		String sql = "SELECT * FROM gattung";
		if (genusId > 0)
			sql += " WHERE id =" + genusId;
		try (Connection conn = DriverManager.getConnection(
                this.url, this.user, this.pw);
		PreparedStatement preparedStatement = conn.prepareStatement(sql)) {

            ResultSet resultSet = preparedStatement.executeQuery();
            List<AnimalGenus> animalGenus = new ArrayList<AnimalGenus>();
            while (resultSet.next()) {
            	
            	int id = resultSet.getInt("id");
            	int familienId = resultSet.getInt("familienid");
            	String name = resultSet.getString("name");
            	String beschreibung = resultSet.getString("beschreibung");

                AnimalGenus obj = new AnimalGenus();
                obj.setId(id);
                obj.setFamilienId(familienId);
                obj.setName(name);
                obj.setBeschreibung(beschreibung);

                animalGenus.add(obj);
            }
            return animalGenus;
		} catch (SQLException e) {
			System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
		} catch (Exception e) {
	        e.printStackTrace();
	    }
		return null;
	}
	public List<AnimalFamily> getAnimalFamilies(int familyId) {
		String sql = "SELECT * FROM familie";
		if (familyId > 0)
			sql += " WHERE id =" + familyId;
		try (Connection conn = DriverManager.getConnection(
                this.url, this.user, this.pw);
		PreparedStatement preparedStatement = conn.prepareStatement(sql)) {

            ResultSet resultSet = preparedStatement.executeQuery();
            List<AnimalFamily> animalFamilies = new ArrayList<AnimalFamily>();
            while (resultSet.next()) {
            	
            	int id = resultSet.getInt("id");
            	int ordnungsId = resultSet.getInt("ordnungsid");
            	String name = resultSet.getString("name");
            	String beschreibung = resultSet.getString("beschreibung");

                AnimalFamily obj = new AnimalFamily();
                obj.setId(id);
                obj.setOrdnungsId(ordnungsId);
                obj.setName(name);
                obj.setBeschreibung(beschreibung);

                animalFamilies.add(obj);
            }
            return animalFamilies;
		} catch (SQLException e) {
			System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
		} catch (Exception e) {
	        e.printStackTrace();
	    }
		return null;
	}
	public List<AnimalOrder> getAnimalOrders(int orderId) {
		String sql = "SELECT * FROM ordnung";
		if (orderId > 0)
			sql += " WHERE id =" + orderId;
		try (Connection conn = DriverManager.getConnection(
                this.url, this.user, this.pw);
		PreparedStatement preparedStatement = conn.prepareStatement(sql)) {

            ResultSet resultSet = preparedStatement.executeQuery();
            List<AnimalOrder> animalOrders = new ArrayList<AnimalOrder>();
            while (resultSet.next()) {
            	
            	int id = resultSet.getInt("id");
            	int klassenId = resultSet.getInt("klassenid");
            	String name = resultSet.getString("name");
            	String beschreibung = resultSet.getString("beschreibung");

            	AnimalOrder obj = new AnimalOrder();
                obj.setId(id);
                obj.setClassId(klassenId);
                obj.setName(name);
                obj.setBeschreibung(beschreibung);

                animalOrders.add(obj);
            }
            return animalOrders;
		} catch (SQLException e) {
			System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
		} catch (Exception e) {
	        e.printStackTrace();
	    }
		return null;
	}
	public List<AnimalClass> getAnimalClasses(int classId) {
		String sql = "SELECT * FROM klasse";
		if (classId > 0)
			sql += " WHERE id =" + classId;
		try (Connection conn = DriverManager.getConnection(
                this.url, this.user, this.pw);
		PreparedStatement preparedStatement = conn.prepareStatement(sql)) {

            ResultSet resultSet = preparedStatement.executeQuery();
            List<AnimalClass> animalClasses = new ArrayList<AnimalClass>();
            while (resultSet.next()) {
            	
            	int id = resultSet.getInt("id");
            	String name = resultSet.getString("name");
            	String beschreibung = resultSet.getString("beschreibung");
            	boolean hatKiemen = resultSet.getBoolean("hat_kiemen");
            	boolean hatWirbel = resultSet.getBoolean("hat_wirbel");
            	boolean istWechselwarm = resultSet.getBoolean("ist_wechselwarm");
            	boolean kannFliegen = resultSet.getBoolean("kann_fliegen");
            	boolean legtEier = resultSet.getBoolean("legt_eier");
            	int anzahlBeine = resultSet.getInt("anzahl_beine");

            	AnimalClass obj = new AnimalClass();
                obj.setId(id);
                obj.setName(name);
                obj.setBeschreibung(beschreibung);
                obj.setHatKiemen(hatKiemen);
                obj.setHatWirbel(hatWirbel);
                obj.setIstWechselwarm(istWechselwarm);
                obj.setKannFliegen(kannFliegen);
                obj.setLegtEier(legtEier);
                obj.setAnzahlBeine(anzahlBeine);

                animalClasses.add(obj);
            }
            return animalClasses;
		} catch (SQLException e) {
			System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
		} catch (Exception e) {
	        e.printStackTrace();
	    }
		return null;
	}
	public boolean insertAnimal(Animal animal) {
		String sql = "INSERT INTO tierbestand(id, artId, name, beschreibung, geburtsdatum, geschlecht)" + 
						   " VALUES(" + animal.getId() + ", " + 
										animal.getArtId() + ", " + 
										"'" + animal.getName() + "', " + 
										animal.getBeschreibung() + ", " + 
										"'" + animal.getGeburtsdatum() + "', " + 
										"'" + animal.getGeschlecht() + "')";
		try (Connection conn = DriverManager.getConnection(
                this.url, this.user, this.pw);
		PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
		}
		return false;
	}
	public boolean deleteAnimal(int id) {
		String sql = "DELETE FROM tierbestand WHERE id =" + id;
		try (Connection conn = DriverManager.getConnection(
                this.url, this.user, this.pw);
		PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
		}
		return false;
	}
	public boolean insertAnimalSpecies(AnimalSpecies animalSpecies) {
		String sql = "INSERT INTO art(id, gattungsid, name, beschreibung)" + 
				   " VALUES(" + animalSpecies.getId() + ", " + 
				   				animalSpecies.getGattungsId() + ", " + 
								"'" + animalSpecies.getName() + "', " + 
								"'" + animalSpecies.getBeschreibung() + "')";
		try (Connection conn = DriverManager.getConnection(
		     this.url, this.user, this.pw);
		PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
		}
		return false;
	}
	public boolean insertAnimalGenus(AnimalGenus animalGenus) {
		String sql = "INSERT INTO gattung(id, familienid, name, beschreibung)" + 
				   " VALUES(" + animalGenus.getId() + ", " + 
				   				animalGenus.getFamilienId() + ", " + 
								"'" + animalGenus.getName() + "', " + 
								"'" + animalGenus.getBeschreibung() + "')";
		try (Connection conn = DriverManager.getConnection(
		     this.url, this.user, this.pw);
		PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
		}
		return false;
	}
	public boolean insertAnimalFamily(AnimalFamily animalFamily) {
		String sql = "INSERT INTO familie(id, ordnungsid, name, beschreibung)" + 
				   " VALUES(" + animalFamily.getId() + ", " + 
				   				animalFamily.getOrdnungsId() + ", " + 
								"'" + animalFamily.getName() + "', " + 
								"'" + animalFamily.getBeschreibung() + "')";
		try (Connection conn = DriverManager.getConnection(
		     this.url, this.user, this.pw);
		PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
		}
		return false;
	}
	public boolean insertAnimalOrder(AnimalOrder animalOrder) {
		String sql = "INSERT INTO ordnung(id, klassenid, name, beschreibung)" + 
				   " VALUES(" + animalOrder.getId() + ", " + 
				   				animalOrder.getClassId() + ", " + 
								"'" + animalOrder.getName() + "', " + 
								"'" + animalOrder.getBeschreibung() + "')";
		try (Connection conn = DriverManager.getConnection(
		     this.url, this.user, this.pw);
		PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
		}
		return false;
	}
	public boolean insertAnimalClass(AnimalClass animalClass) {
		String sql = "INSERT INTO klasse(id, name, beschreibung, legt_eier, kann_fliegen, " + 
					"hat_wirbel, hat_kiemen, ist_wechselwarm, anzahl_beine)" + 
					" VALUES(" + animalClass.getId() + ", " + 
								"'" + animalClass.getName() + "', " + 
								"'" + animalClass.getBeschreibung() + "', " + 
								animalClass.isLegtEier() + ", " + 
								animalClass.isKannFliegen() + ", " +
								animalClass.isHatWirbel()+ ", " + 
								animalClass.isHatKiemen() + ", " + 
								animalClass.isIstWechselwarm() + ", " + 
								animalClass.getAnzahlBeine() + ")";
		try (Connection conn = DriverManager.getConnection(
		     this.url, this.user, this.pw);
		PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
		}
		return false;
	}
	private int getHighestKey(String tableName) {
		String sql = "SELECT MAX(id) FROM " + tableName;
		try (Connection conn = DriverManager.getConnection(
                this.url, this.user, this.pw);
		PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            int id = resultSet.getInt("max");
            return id;
		} catch (SQLException e) {
			System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
		} catch (Exception e) {
	        e.printStackTrace();
	    }
		return -1;   
	}
	public int getHighestKeyAnimals() {
		return this.getHighestKey("tierbestand");           
	}
	public int getHighestKeyAnimalSpecies() {
		return this.getHighestKey("art"); 
		
	}
	public int getHighestKeyAnimalGenus() {
		return this.getHighestKey("gattung"); 
		
	}
	public int getHighestKeyAnimalFamilies() {
		return this.getHighestKey("familie"); 
		
	}
	public int getHighestKeyAnimalOrders() {
		return this.getHighestKey("ordnung"); 
		
	}
	public int getHighestKeyAnimalClasses() {
		return this.getHighestKey("klasse"); 
		
	}
}
