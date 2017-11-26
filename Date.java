package system.information;

public class Date {
	private int month;
	private int day;
	private int year;
	
	public Date() {
		month = 0;
		day = 0;
		year = 0;
	}
	
	public Date(int month, int date, int year) {
		this.month = month;
		day = date;
		this.year = year;
	}
	
	public void setMonth(int month) {
		this.month = month;
	}
	
	public void setDay(int day) {
		this.day = day;
	}
	
	public void setYear(int year) {
		this.year = year;
	}
	
	public int getMonth() {
		return month;
	}
	
	public int getDay() {
		return day;
	}
	
	public int getYear() {
		return year;
	}
	
	public String getDate() {
		String date = new String(month + "/" + day + "/" + year);
		
		return date;
	}
}
