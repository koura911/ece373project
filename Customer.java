package system.people;

import java.util.ArrayList;
import system.information.Location;
import system.hardware.Equipment;
import system.hardware.Radio;

public class Customer {

	private Location location;
	private ArrayList<Equipment> equip;
	private int speedUp;
	private int speedDown;
	private double price;
	private double amtDue;
	
	//shouldn't this class have a constructor?
	public Customer() {
		location = null;
		equip = new ArrayList<Equipment>();
		speedUp = 0;
		speedDown = 0;
		price = 0.0;
		amtDue = 0.0;
	}
	
	//getting methods
	public Location getLoc() {
		return location;
	}
	public ArrayList<Equipment> getEquip(){
		return equip;
	}
	public int getUp() {
		return speedUp;
	}
	public int getDown() {
		return speedDown;
	}
	public double getPrice() {
		return price;
	}
	public double getAmyDue() {
		return amtDue;
	}
	
	
	
	//setting methods
	public void setLoc(Location l) {
		location = l;
	}
	public void setEquip(ArrayList<Equipment> e) {
		equip = e;
	}
	public void setUp(int i) {
		speedUp = i;
	}
	public void setDown(int i) {
		speedDown = i;
	}
	public void setPrice(double d) {
		price = d;
	}
	public void setAmtDue(double d) {
		amtDue = d;
	}
	
	
	public Radio findAP() {
		//not sure what does in here. 
		//is it suppose to look throught the customer equipment array
		//or a different array in a different class?
		Radio r1 = new Radio();
		
		return r1;
	}
	
	public int checkSpeedUP() {
		//INCOMPLETE
		
		return 0;
	}
	public int checkSpeedDown() {
		//INCOMPLETE
		
		return 0;
	}
}
