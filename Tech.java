package people;

import java.util.ArrayList;

public class Tech extends Employee {
	
	private ArrayList<Customer> cust;
	private ArrayList<Equipment> equip;
	
	public Tech() {
		cust = new ArrayList<Customer>();
		equip = new ArrayList<Equipment>();
	}
	
	public ArrayList<Customer> getCust(){
		return cust;
	}
	
	public ArrayList<Equipment> getEquip(){
		return equip;
	}
	
	public void setCust(ArrayList<Customer> c) {
		cust = c;
	}
	
	public void setEquip(ArrayList<Equipment> e) {
		equip = e;
	}
	
	public void addCust(Customer p) { //adds a customer to the arraylist
		cust.add(p);
	}
	
	public void addEquip(Equipment o) { //add a equipment to the arraylist
		equip.add(o);
	}
	
	public void rmvCust(Customer p) { //remove a customer form arraylist
		cust.remove(p);
	}
	
	public void rmvEquip(Equipment o) {
		equip.remove(o);
	}
	
	public Customer findCust(int n) {
		return cust.get(n);
	}
	
	
}
