package system.people;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/*
 * shouldn't person have: billing address, phone, email address?
 */
 public class Person implements Serializable {

	private String name;
	private int userID;
	private String pswd;
	
	
	public Person() {
		name = null;
		userID = 0000000; // what is the format for the ID?
		pswd = null;
	}
	
	//getter setter for name
	public String getName() {
		return name;
	}
	
	public void setName(String aName) {
		name = aName;
	}
	
	//getter and setter for userID
	
	public int getUserID() {
		return userID;
	}
	
	public void setUserID(int aUserID) {
		userID = aUserID;
	}
	
	
	//check if userID number is already taken?
	public boolean detectUserIDConflict(int aUserID) {
		boolean result = false;
		
		
		return result;
	}
	
	//getter and setter for password
	
	public String getPswd() {
		return pswd;
	}
	
	public void setPswd(String password) {
		pswd = password; 	// are we making formattng conditions for the passoword
	}
	
	//check password
	public boolean checkPswd(String p) {
		boolean result = false;
		
		if(p.equals(pswd)) {
			result = true;
		}
		
		return result; 
	}
	
	public static void saveData(Person p) {
		FileOutputStream fileOut = null;
		ObjectOutputStream objOut = null;
		
		try {
			fileOut = new FileOutputStream("company.ser");
			objOut = new ObjectOutputStream(fileOut);
			objOut.writeObject(p);
			objOut.close();
			fileOut.close();
		}
		
		catch(IOException i) {
			i.printStackTrace();
		}
	}
	
	public static Person loadData() {
		FileInputStream fileIn = null;
		ObjectInputStream objIn = null;
		Person p1 = null;
		
		try {
			fileIn = new FileInputStream("company.ser");
			objIn = new ObjectInputStream(fileIn);
			p1 = (Person) objIn.readObject();
			objIn.close();
			fileIn.close();
		}
		
		catch (IOException i) {
			i.printStackTrace();
		}
		
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return p1;
	}
}
