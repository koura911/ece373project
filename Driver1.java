package system.software;

import system.company.Company;
import system.forms.*;
import system.hardware.*;
import system.information.*;
import system.people.*;
import system.software.*;

public class Driver1 {
	public static void main(String[] args) {
		Person p1 = new Person();
		Person p2 = new Person();
		Person p3 = new Person();
		Person p4 = new Person();
		Person p5 = new Person();
		Equipment e1 = new Equipment();
		Equipment e2 = new Equipment();
		Roster ro1 = new Roster();
		Inventory i1 = new Inventory();
		Company co = new Company();
		Customer c1 = new Customer();
		
		c1.setName("Kaitlyn Oura");
		c1.setUserID(8);
		c1.setPswd("hello");
		c1.setUp(6);
		c1.setDown(18);
		c1.setPrice(18.98);
		c1.setAddress("1234 ABC Lane, Phoenix, AZ 85087");
		p1.setName("Kara Danvers");
		p1.setUserID(01);
		p2.setName("Lena Luthor");
		p2.setUserID(02);
		p3.setName("Alex Danvers");
		p3.setUserID(03);
		p4.setName("Maggie Sawyer");
		p4.setUserID(04);
		p5.setName("Winn Schott");
		p5.setUserID(05);
		
		co.people.add(c1);
		
		
		e1.setSerialNumber("E33642RT456");
		e1.setName("Bananas");
		e2.setName("Josh");
		e2.setSerialNumber("R3375FT965");
		e1.setBrand("Garlic");
		e1.setModel("Highlighter");
		c1.getEquip().add(e1);
		c1.getEquip().add(e2);
		Date e1d = new Date();
		e1d.setMonth(6);
		e1d.setDay(12);
		e1d.setYear(2017);
		e1.setDateInstalled(e1d);
		
		e1.setIdNum(5);
		
		e2.setBrand("Root beer");
		Date e2d = new Date();
		e2d.setMonth(11);
		e2d.setDay(24);
		e2d.setYear(2015);
		
		e2.setDateInstalled(e2d);
		
		e2.setIdNum(2);
		e2.setModel("Knife");
		
		Location l1 = new Location();
		l1.setAddress("NW");
		l1.setGpsLat(56.9);
		l1.setGpsLon(56.9);
		Location l2 = new Location();
		l2.setAddress("SW");
		l2.setGpsLat(90.5);
		l2.setGpsLon(56.9);
		e1.setLocation(l1);
		e2.setLocation(l2);
		
		ro1.addPerson(p2);
		ro1.addPerson(p1);
		ro1.addPerson(p5);
		ro1.addPerson(p3);
		ro1.addPerson(p4);
		
		i1.addEquipment(e1);
		i1.addEquipment(e2);
		i1.setTotItems(2);
		i1.sortEquipment();
		i1.addEquipment(e1);
		i1.removeEquipment(e1);
		i1.removeEquipment(e1);
		Invoice in1 = new Invoice();
		in1.setMinDue(50.8);
		in1.setTotalDue(620);
		Date in1d = new Date();
		in1d.setMonth(10);
		in1d.setDay(1);
		in1d.setYear(2017);
		in1.setDueDate(in1d);
		
		in1.setPerson(p1);
	
		in1.generateInvoice();
		i1.addPerson(p1);
		i1.addPerson(p2);
		i1.addPerson(p5);
		i1.addPerson(p2);
		i1.removePerson(p5);
		i1.removePerson(p5);
		
		i1.sortByPeople();
		
		System.out.println("Inventory people");
		for (int i = 0; i < i1.getPeople().size(); i++) {
			System.out.println(i1.getPeople().get(i).getName());
		}


		
		Quote q1 = new Quote();
		
		q1.setPerson(p5);
		q1.setAvailableSpeedDown(34);
		q1.setAvailableSpeedUp(56);
		q1.setPrice(56.79);
		q1.generateQuote();
		
		System.out.println(ro1.getTotalPeople());
		ro1.sortPeople();
		
		ro1.generateRoster();
		i1.generateInventoryReport();
		
		//CompanyGUICustomer newGUI = new CompanyGUICustomer("University of Arizona", co);
		CompanyGUICustomer newGUI = new CompanyGUICustomer("University of Arizona", co, c1);
	}
}
