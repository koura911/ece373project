package system.people;

public class Person {
	private String name;
	private int userID;

	public String getName() {
		return this.name;
	}

	public int getUserID() {
		return this.userID;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public boolean checkPswd(String enteredPW) {
		// TODO should be implemented
		boolean correct = true;
		
		return correct;
	}
}
