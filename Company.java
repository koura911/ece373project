package system.company;

import system.people.*;

import java.util.ArrayList;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


import system.hardware.*;

public class Company implements Serializable {
	public ArrayList<Person> people;
	public ArrayList<Equipment> equipmentList;

	
	public Company(){
		people = new ArrayList<Person>();
		equipmentList = new ArrayList<Equipment>();
	}
	
	
	public void addPeople(Person p) {
		people.add(p);
	}
	
	public void addEquipment(Equipment e) {
		equipmentList.add(e);
	}

	public void rmvPeople(Person p) {
		// check if it is in there first
		people.remove(p);
	}

	public void rmvEquipment(Equipment e) {
		//check if it in there first
		equipmentList.remove(e);
	}
	
	public Company getComp() {
		return this;
	}
	public void setPeople(ArrayList<Person> p) {
		this.people = p;
	}
	public void setEquipList(ArrayList<Equipment> e) {
		this.equipmentList = e;
	}
	
	
	public static void saveData(Company c1) {
		FileOutputStream fileOut = null;
		ObjectOutputStream objOut = null;
		
		try {
			fileOut = new FileOutputStream("company.ser");
			objOut = new ObjectOutputStream(fileOut);
			objOut.writeObject(c1);
			objOut.close();
			fileOut.close();
		}
		
		catch(IOException i) {
			i.printStackTrace();
		}
	}
	
	public static Company loadData() {
		FileInputStream fileIn = null;
		ObjectInputStream objIn = null;
		Company c1 = null;
		
		try {
			fileIn = new FileInputStream("company.ser");
			objIn = new ObjectInputStream(fileIn);
			c1 = (Company) objIn.readObject();
			objIn.close();
			fileIn.close();
		}
		
		catch (IOException i) {
			i.printStackTrace();
		}
		
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return c1;
	}



}//end of class

