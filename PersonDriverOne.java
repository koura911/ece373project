package people;

import people.*;

public class PersonDriverOne {

	public static void main(String[] arg) {
		Person p1 = new Person();
		p1.setName("Sam");
		p1.setUserID(1234);
		p1.setPswd("Password");
		
		
		//Checking Person Methods
		System.out.println("Person Class");
		System.out.println("Name should be Sam it is "+p1.getName());
		System.out.println("userID should be 1234 it is "+p1.getUserID();
		System.out.println("Password should be Password it is "+p1.getPswd());
		if(p1.checkPswd("Password") == true) {
			System.out.println("method works");
		}else {
			System.out.println("method doesn't work");
		}
		
		
		
		Employee emp1 = new Employee();
		emp1.setName("Sarah");
		emp1.setPswd("Pig");
		emp1.setUserID(0000);
		emp1.setHours(44.4);
		emp1.setRate(20.0);
		
		
		System.out.println("Employee");
		System.out.println("Name should be Sarah it is "+emp1.getName());
		System.out.println("UserID should be 0000 it is "+emp1.getUserID());
		System.out.println("Password should be Pig it is "+emp1.getPswd());
		System.out.println("Hours should be 44.4 it is "+emp1.getHours());
		System.out.println("Pay rate should 20  it is "+emp1.getRate());
		emp1.giveRaise(10.0);
		System.out.println("Payrate after raise of 10 should be 30 it is  "+emp1.getRate());
	
	
		
		Tech tech1 = new Tech();
		tech1.setName("J");
		tech1.setUserID(1111);
		tech1.setPswd("stingray");
		tech1.setHours(33);
		tech1.setRate(55.5);
		
		//tech1.addCust(p);
	
	
	
	
	
	}	
}
