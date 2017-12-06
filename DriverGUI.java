package system.software;

import java.util.ArrayList;

import system.company.*;
import system.hardware.Antenna;
import system.hardware.Equipment;
import system.hardware.NetworkDevice;
import system.hardware.Radio;
import system.hardware.Server;
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
		Tech t = new Tech();
		OfficeWorker  of = new OfficeWorker();
		
		of.setName("Happy");
		of.setPswd("password1");
		of.setUserID(4);
		
		t.setName("Peter");
		t.setPswd("password");
		t.setUserID(3);
		
		cust.setName("Sam");
		cust.setPswd("password");
		cust.setUserID(2);
		cust.setAddress("1234 ABC Lane DEF, GH 12345");
		cust.setPrice(19.95);
		cust.setAmtDue(19.95);
		cust.setDown(280);
		cust.setUp(280);
		cust.setDueDate(12, 30, 2017);
		
		System.out.println(cust.getUserID());
		
		adi.setName("Josue");
		adi.setPswd("password");
		adi.setUserID(1);
		System.out.println(adi.getUserID());
		
		c.addPeople(cust);
		c.addPeople(adi);
		c.addPeople(t);
		c.addPeople(of);
		
		Radio r = new Radio();
		Radio r2 = new Radio();
		Antenna a = new Antenna();
		NetworkDevice nd = new NetworkDevice();
		Server s = new Server();
		
		Location l = new Location();
		Location l1 = new Location();
		Location l2 = new Location();
		Location l3 = new Location();
		Location l4 = new Location();
		
		
		r.setModel("ePMP1000");
		r.setBrand("Cambium");
		r.setAP(true);
		Date d1 = new Date(11, 14, 2017);
		r.setDateInstalled(d1);
		r.setFreqMax(1000);
		r.setFreqMin(500);
		r.setIdNum(1);
		r.setMaxDataRate(300);
		r.setName("TestAP");
		r.setSerialNumber("AR5223");
		r.setSetDataRate(280);
		r.setSub(false);
		r2.setModel("ePMP1000");
		r2.setBrand("Cambium");
		r2.setAP(false);
		r2.setDateInstalled(d1);
		r2.setFreqMax(1000);
		r2.setFreqMin(500);
		r2.setIdNum(2);
		r2.setMaxDataRate(300);
		r2.setName("TestSub");
		r2.setSerialNumber("AR1561");
		r2.setSetDataRate(280);
		r2.setSub(true);
		a.setBrand("Ubiquiti");
		a.setModel("AirMax");
		a.setDateInstalled(d1);
		a.setIdNum(3);
		a.setDirectional(false);
		a.setMountType("Tower");
		a.setName("TestAPAnt");
		a.setOmni(true);
		a.setRadio(r);
		a.setRange(500000);
		a.setSerialNumber("AA1416");

		nd.setBrand("Mikrotik");
		nd.setModel("CCR1036");
		nd.setDateInstalled(d1);
		nd.setIdNum(5);
		nd.setNetSwitch(false);
		nd.setRouter(true);
		nd.setSerialNumber("RN1611");
		
		s.setBrand("supermicro");
		s.setModel("2U");
		s.setDateInstalled(d1);
		s.setIdNum(7);
		s.setDateLastBackUp(d1);
		s.setOs("Linux");
		s.setPurpose("Database");
		s.setSerialNumber("PC2114");
		
		l.setGpsLat(0);
		l.setGpsLon(0);
		l.setAddress("1234 ABC Lane DEF, GH 12345");
		
		l1.setGpsLat(10);
		l1.setGpsLon(10);
		l1.setAddress("Central Tower");
		
		l2.setGpsLat(0);
		l2.setGpsLon(0);
		l2.setAddress("Central Tower");
		
		l3.setGpsLat(10);
		l3.setGpsLon(10);
		l3.setAddress("Central Tower");
		
		l4.setGpsLat(0);
		l4.setGpsLon(0);
		l4.setAddress("Central Tower");
		
		cust.setLoc(l);
		ArrayList<Equipment> custE = new ArrayList<Equipment>();
		custE.add(r);
		r.addConn(r2);
		cust.setEquip(custE);
		
		c.equipmentList.add(a);
		c.equipmentList.add(s);
		c.equipmentList.add(nd);
		c.equipmentList.add(r);
		
		LoginGUI loginGui = new LoginGUI("Login GUI",c);    
		
	}
}