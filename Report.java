package system.forms;

import system.people.Person;
import system.hardware.Equipment;
import java.util.ArrayList;
import javax.swing.*;

public abstract class Report {
	private ArrayList<Person> people;
	private ArrayList<Equipment> equipment;
	private int number;

	public Report() {
		people = new ArrayList<Person>();
		equipment = new ArrayList<Equipment>();
		number = 0;
	}
	
	public ArrayList<Person> getPeople() {
		return this.people;
	}

	public ArrayList<Equipment> getEquipment() {
		return this.equipment;
	}

	public int getNumber() {
		return this.number;
	}

	public void setPeople(ArrayList<Person> people) {
		this.people = people;
	}

	public void setEquipment(ArrayList<Equipment> equipment) {
		this.equipment = equipment;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public void addPerson(Person newPerson) {
		boolean personExists = false;
		
		for (int i = 0; i < people.size(); i++) {
			if (people.get(i).getUserID() == newPerson.getUserID()) {
				personExists = true;
				break;
			}
		}
		
		if (personExists == false) {
			people.add(newPerson);
			//JOptionPane.showMessageDialog(null, newPerson.getName() + ", userID: " + newPerson.getUserID() + " has been added.", "Add person to report", JOptionPane.INFORMATION_MESSAGE);
		}
		else {
			JOptionPane.showMessageDialog(null, newPerson.getName() + ", userID: " + newPerson.getUserID() + ", cannot be added. " + newPerson.getName() + " already exists in the report.", "Error adding person to report", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void addEquipment(Equipment newEquipment) {
		boolean equipmentExists = false;
		
		for (int i = 0; i < equipment.size(); i++) {
			if (equipment.get(i).getSerialNumber() == newEquipment.getSerialNumber()) {
				equipmentExists = true;
				break;
			}
		}
		
		if (equipmentExists == false) {
			equipment.add(newEquipment);
			//JOptionPane.showMessageDialog(null, newEquipment.getSerialNumber() + " added to report.", "Add equipment to report", JOptionPane.INFORMATION_MESSAGE);
		}
		else {
			JOptionPane.showMessageDialog(null, newEquipment.getSerialNumber() + " cannot be added. " + newEquipment.getSerialNumber() + " already exists in the report.", "Error adding equipment to report", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void removePerson(Person oldPerson) {
		boolean personExists = false;
		int oldPersonIndex = 0;
		for (int i = 0; i < people.size(); i++) {
			if (people.get(i).getUserID() == oldPerson.getUserID()) {
				personExists = true;
				oldPersonIndex = i;
				break;
			}
		}
		
		if (personExists) {
			people.remove(oldPersonIndex);
			//JOptionPane.showMessageDialog(null, oldPerson.getName() + " removed from report.", " Remove person from report", JOptionPane.INFORMATION_MESSAGE);
			
		}
		else {
			JOptionPane.showMessageDialog(null, "Cannot remove " + oldPerson.getName() + ". " + oldPerson.getName() + " does not exist in report.", "Error removing equipment from report", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void removeEquipment(Equipment oldEquipment) {
		boolean equipmentExists = false;
		int oldEquipmentIndex = 0;
		
		for (int i = 0; i < equipment.size(); i++) {
			if (equipment.get(i).getSerialNumber() == oldEquipment.getSerialNumber()) {
				equipmentExists = true;
				oldEquipmentIndex = i;
				break;
			}
		}
		
		if (equipmentExists) {
			equipment.remove(oldEquipmentIndex);
			//JOptionPane.showMessageDialog(null, oldEquipment.getSerialNumber() + " removed from report.", "Remove equipment from report", JOptionPane.INFORMATION_MESSAGE);
		}
		else {
			JOptionPane.showMessageDialog(null, "Cannot remove equipment " + oldEquipment.getSerialNumber() + ". Equipment " + oldEquipment.getSerialNumber() + " does not exist in report.", "Error removing equipment from report", JOptionPane.ERROR_MESSAGE);
		}
	}
}
