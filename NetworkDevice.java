package system.hardware;

import java.util.ArrayList;
import javax.swing.*;

public class NetworkDevice extends Equipment{
	
    private  boolean router;
    private  boolean netSwitch;
    private  ArrayList <Equipment> connDevs;
    public NetworkDevice() {
    	
    	router=false;
    	netSwitch=false;
    	connDevs = new ArrayList<Equipment>();
    	
    }

    public boolean isRouter() {
		return router;
	}

	public void setRouter(boolean router) {
		this.router = router;
	}

	public boolean isNetSwitch() {
		return netSwitch;
	}

	public void setNetSwitch(boolean netSwitch) {
		this.netSwitch = netSwitch;
	}

	public ArrayList<Equipment> getConnDevs() {
		return connDevs;
	}

	public void setConnDevs(ArrayList<Equipment> connDevs) {
		this.connDevs = connDevs;
	}









	public void addDev(Equipment d ){
		for(Equipment e: connDevs)
			if(d.getIdNum()==e.getIdNum()) {
				//System.out.println(d.getBrand()+" "+d.getModel()+" is already listed as a connected device.");
				JOptionPane.showMessageDialog(null, d.getBrand() + " " + d.getModel() + " is already listed as a connected device.", "Error adding network device", JOptionPane.ERROR_MESSAGE);
				return;
			}
		connDevs.add(d);
	}
	public void rmvDev( Equipment d){
		int i = 0;
		for(Equipment e: connDevs) {
			if(d.getIdNum()==e.getIdNum()) {
				connDevs.remove(i);
				//System.out.println(d.getBrand()+" "+d.getModel()+" has been removed from connected devices.");
				JOptionPane.showMessageDialog(null, d.getBrand() + " " + d.getModel() + "has been removed from connected devices.", "Remove network device", JOptionPane.INFORMATION_MESSAGE);
			}
			i++;
		}
		
	}


}
