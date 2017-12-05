package system.software;

import system.company.*;
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
		
		//Admin admin = new Admin();
		LoginGUI loginGui = new LoginGUI("Login GUI",c);    
	}
}