package system.hardware;

import java.util.ArrayList;

public class Antenna extends Equipment {
	
    private  double range;
    private String mountType;
    private boolean omni;
    private  boolean directional;
    private Radio radio;
    private ArrayList <Antenna> connections;
    
    
    public Antenna() {
    	range = 0.0;
    	mountType="unknown";
    	omni =false;
    	directional=false;
    	radio=null;
    	connections = new ArrayList<Antenna>();
    }
    
   
     public double getRange() {
		return range;
	}


	public void setRange(double range) {
		this.range = range;
	}


	public String getMountType() {
		return mountType;
	}


	public void setMountType(String mountType) {
		this.mountType = mountType;
	}


	public boolean isOmni() {
		return omni;
	}


	public void setOmni(boolean omni) {
		this.omni = omni;
	}


	public boolean isDirectional() {
		return directional;
	}


	public void setDirectional(boolean directional) {
		this.directional = directional;
	}


	public Radio getRadio() {
		return radio;
	}


	public void setRadio(Radio radio) {
		this.radio = radio;
	}


	public ArrayList<Antenna> getConnections() {
		return connections;
	}


	public void setConnections(ArrayList<Antenna> connections) {
		this.connections = connections;
	}


	public void addConn(Antenna a){
		for(Antenna l: connections)
			if(a.getIdNum()==l.getIdNum())
				return;
		connections.add(a);
		a.addConn(this);
		return;
	}
    public void rmvConn(Antenna a){
    	int i = 0;
    	for(Antenna l: connections) {
    		if(a.getIdNum()==l.getIdNum()) {
    			connections.remove(i);
    			a.rmvConn(this);
    		}
    		i++;
    	}
    }


}
