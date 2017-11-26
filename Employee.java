package system.people;

public class Employee extends Person{

	private double hoursWorked;
	private double payrate;
	
	
	public Employee() {
		hoursWorked = 0.0;
		payrate = 0.0;
	}
	
	
	//setter and getter for hoursWorked
	
	public double getHours() {
		return hoursWorked;
	}
	public void setHours(double h) {
		hoursWorked = h;
	}
	
	//setter and getter for payrate
	public double getRate() {
		return payrate;
	}
	public void setRate(double r) {
		payrate = r;
	}
	
	public void giveRaise(double p) {
		payrate = payrate + p; 
	}
}
