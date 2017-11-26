package system.people;

public class Person {

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
	
	
}
