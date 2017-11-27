package system.software;

import system.hardware.*;
import system.information.*;

public class Driver {
	
	public static void main(String[] args) {
	
	Radio r1 = new Radio();
	Radio r2 = new Radio();
	Antenna a1 = new Antenna();
	Antenna a2 = new Antenna();
	NetworkDevice n1 = new NetworkDevice();
	NetworkDevice n2 = new NetworkDevice();
	Server s1 = new Server();
	
	Location lr1 = new Location(), lr2 = new Location(), la1 = new Location(), la2 = new Location(),ln1 = new Location(),ln2 = new Location(),ls1 = new Location();
	
	r1.setModel("ePMP1000");
	r1.setBrand("Cambium");
	r1.setAP(true);
	//r1.setDateInstalled(111417);
	Date d1 = new Date(11, 14, 2017);
	r1.setDateInstalled(d1);
	
	r1.setFreqMax(1000);
	r1.setFreqMin(500);
	r1.setIdNum(1);
	r1.setMaxDataRate(300);
	r1.setName("TestAP");
	r1.setSerialNumber("AR5223");
	r1.setSetDataRate(10);
	r1.setSub(false);
	
	r2.setModel("ePMP1000");
	r2.setBrand("Cambium");
	r2.setAP(false);
	//r2.setDateInstalled(111417);
	r2.setDateInstalled(d1);
	r2.setFreqMax(1000);
	r2.setFreqMin(500);
	r2.setIdNum(2);
	r2.setMaxDataRate(300);
	r2.setName("TestSub");
	r2.setSerialNumber("AR1561");
	r2.setSetDataRate(10);
	r2.setSub(true);
	
	a1.setBrand("Ubiquiti");
	a1.setModel("AirMax");
	//a1.setDateInstalled(111417);
	a1.setDateInstalled(d1);
	a1.setIdNum(3);
	a1.setDirectional(false);
	a1.setMountType("Tower");
	a1.setName("TestAPAnt");
	a1.setOmni(true);
	a1.setRadio(r1);
	a1.setRange(500000);
	a1.setSerialNumber("AA1416");
	
	a2.setBrand("Ubiquiti");
	a2.setModel("PowerBeam");
	a2.setDateInstalled(d1);
	a2.setIdNum(4);
	a2.setDirectional(true);
	a2.setMountType("NonPen");
	a2.setName("TestSubAnt");
	a2.setOmni(false);
	a2.setRadio(r2);
	a2.setRange(500000);
	a2.setSerialNumber("AA4942");
	
	n1.setBrand("Mikrotik");
	n1.setModel("CCR1036");
	n1.setDateInstalled(d1);
	n1.setIdNum(5);
	n1.setNetSwitch(false);
	n1.setRouter(true);
	n1.setSerialNumber("RN1611");
	
	n2.setBrand("Netgear");
	n2.setModel("g752tp");
	n2.setDateInstalled(d1);
	n2.setIdNum(6);
	n2.setNetSwitch(true);
	n2.setRouter(false);
	n2.setSerialNumber("SN2154");
	
	s1.setBrand("supermicro");
	s1.setModel("2U");
	s1.setDateInstalled(d1);
	s1.setIdNum(7);
	s1.setDateLastBackUp(d1);
	s1.setOs("Linux");
	s1.setPurpose("Database");
	s1.setSerialNumber("PC2114");
	
	lr1.setGpsLat(0);
	lr1.setGpsLon(0);
	lr1.setAddress("Central Tower");
	
	lr2.setGpsLat(10);
	lr2.setGpsLon(10);
	lr2.setAddress("Cust Home");
	
	la1.setGpsLat(0);
	la1.setGpsLon(0);
	la1.setAddress("Central Tower");
	
	la2.setGpsLat(10);
	la2.setGpsLon(10);
	la2.setAddress("Cust Home");
	
	ln1.setGpsLat(0);
	ln1.setGpsLon(0);
	ln1.setAddress("Central Tower");
	
	ln2.setGpsLat(0);
	ln2.setGpsLon(0);
	ln2.setAddress("Central Tower");
	
	ls1.setGpsLat(0);
	ls1.setGpsLon(0);
	ls1.setAddress("Central Tower");
	
	r1.setLocation(lr1);
	r2.setLocation(lr2);
	a1.setLocation(la1);
	a2.setLocation(la2);
	n1.setLocation(ln1);
	n2.setLocation(ln2);
	s1.setLocation(ls1);
	
	
	
	
	
	}
}
