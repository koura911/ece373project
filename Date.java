package system.information;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Date implements Serializable {
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
	
	public static void saveData(Date d) {
		FileOutputStream fileOut = null;
		ObjectOutputStream objOut = null;
		
		try {
			fileOut = new FileOutputStream("company.ser");
			objOut = new ObjectOutputStream(fileOut);
			objOut.writeObject(d);
			objOut.close();
			fileOut.close();
		}
		
		catch(IOException i) {
			i.printStackTrace();
		}
	}
	
	public static Date loadData() {
		FileInputStream fileIn = null;
		ObjectInputStream objIn = null;
		Date d1 = null;
		
		try {
			fileIn = new FileInputStream("comany.ser");
			objIn = new ObjectInputStream(fileIn);
			d1 = (Date) objIn.readObject();
			objIn.close();
			fileIn.close();
		}
		
		catch (IOException i) {
			i.printStackTrace();
		}
		
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return d1;
	}
}
