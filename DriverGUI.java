package system.software;
import system.company.*;
import system.people.*;

//import org.hrs.system.HRGUI;

public class DriverGUI {

	public static void main(String[] args)
	{
		Company c = new Company();
		
		Customer cust = new Customer();
		 
		c.addPeople(cust);
		cust.setName("Sam");
		cust.setPswd("password");
		System.out.print(cust.getUserID());
		
		//Admin admin = new Admin();
		LoginGUI loginGui = new LoginGUI("Login GUI",c);    
	}
}
