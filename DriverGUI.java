package system.software;

import java.util.ArrayList;

import system.company.*;
import system.hardware.Equipment;
import system.information.Date;
import system.information.Location;
import system.people.*;

//import org.hrs.system.HRGUI;

public class DriverGUI {

	public static void main(String[] args)
	{
		Company c = new Company();
		
		Customer cust = new Customer();
		Admin adi = new Admin();
		 
		
		cust.setName("Sam");
		cust.setPswd("password");
		cust.setUserID(2);
		System.out.println(cust.getUserID());
		
		adi.setName("Josue");
		adi.setPswd("password");
		adi.setUserID(1);
		System.out.println(adi.getUserID());
		
		c.addPeople(cust);
		c.addPeople(adi);
		
		Equipment e1 = new Equipment();
		Equipment e2 = new Equipment();
		c.equipmentList.add(e1);
		c.equipmentList.add(e2);
		
		e1.setSerialNumber("E33642RT456");
		e1.setName("Bananas");
		e2.setName("Josh");
		e2.setSerialNumber("R3375FT965");
		e1.setBrand("Garlic");
		e1.setModel("Highlighter");
		cust.getEquip().add(e1);
		cust.getEquip().add(e2);
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
		ArrayList<Equipment> test = new ArrayList<Equipment>();
		test.add(e1);
		test.add(e2);
		cust.setEquip(test);
		//Admin admin = new Admin();
		LoginGUI loginGui = new LoginGUI("Login GUI",c);    
		
	}
}