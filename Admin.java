package people;

import java.util.ArrayList;

import sun.misc.FormattedFloatingDecimal.Form;

public class Admin extends Employee {
	
	private ArrayList<People> users;
	private ArrayList<Report> reports;
	private ArrayList<Form> forms;
	private ArrayList<Equipment> equip;
	private ArrayList<Customer> cust;
	private ArrayList<Employee> empl;
	
	public Admin() {
		users = new ArrayList<People>();
		reports = new ArrayList<Report>();
		forms = new ArrayList<Form>();
		equip = new ArrayList<Equipment>();
		cust = new ArrayList<Customer>();
		empl = new ArrayList<Employee>();
	}
	
	//getting methods
	public ArrayList<Equipment> getEquip(){
		return equip;
	}
	public ArrayList<People> getUsers(){
		return users;
	}
	public ArrayList<Report> getRep(){
		return reports;
	}
	public ArrayList<Form> getForm(){
		return forms;
	}
	public ArrayList<Customer> getCust(){
		return cust;
	}
	public ArrayList<Employee> getEmpl(){
		return empl;
	}
	
	
	//setting methods
	public void setUsers(ArrayList<People> u) {
		users = u;
	}
	public void setRep(ArrayList<Report> r) {
		reports = r;
	}
	public void setForm(ArrayList<Form> f) {
		forms = f;
	}
	public void setCust(ArrayList<Customer> c) {
		cust = c;
	}
	public void setEquip(ArrayList<Equipment> e) {
		equip = e;
	}
	public void setEmpl(ArrayList<Employee> e) {
		empl = e;
	}
	
	//adding methods
	public void addRep(Report p) {
		reports.add(p);
	}
	public void addForm(Form o) {
		forms.add(o);
	}
	public void addCust(Customer c) {
		cust.add(c);
	}
	public addEquip(Equipment o) {
		equip.add(o);
	}
	public addEmpl(Employee e) {
		empl.add(e);
	}
	
	
	//remove mehtods
	public void rmvCust(Customer p) {
		cust.remove(p);
	}
	public void rmvEmpl(Employee p) {
		empl.remove(p);
	}
	public void rmvEquip(Equipment o) {
		equip.remove(o);
	}
	public void rmvRep(Report p) {
		reports.remove(p);
	}
	public void rmvForm(Form o) {
		forms.remove(o);
	}
	
	
//finding methods
	public Report findReport(int n) {
		return reports.get(n);
	}
	public Customer findCust(int n) {
		return cust.get(n);
	}
	
	
}
