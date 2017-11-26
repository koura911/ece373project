package system.hardware;

import java.util.ArrayList;

public class Radio extends Equipment {
    private  int freqMax;
    private int freqMin;
    private int freqOp;
    private int maxDataRate;
    private int setDataRate;
	private boolean AP;
    private boolean Sub;
    private ArrayList<Radio> connections;
    private Antenna antenna;
    
    public Radio () {
    	freqMax = 0;
    	freqMin = 0;
    	freqOp = 0;
    	maxDataRate = 0;
    	AP = false;
    	Sub = false;
    	connections = new ArrayList<Radio>();
    	antenna = null;
    	
    }
    
    public int getFreqMax() {
		return freqMax;
	}

	public void setFreqMax(int freqMax) {
		this.freqMax = freqMax;
	}

	public int getFreqMin() {
		return freqMin;
	}

	public void setFreqMin(int freqMin) {
		this.freqMin = freqMin;
	}

	public int getFreqOp() {
		return freqOp;
	}

	public void setFreqOp(int freqOp) {
		this.freqOp = freqOp;
	}

	public int getMaxDataRate() {
		return maxDataRate;
	}

	public void setMaxDataRate(int maxDataRate) {
		this.maxDataRate = maxDataRate;
	}

	 public int getSetDataRate() {
			return setDataRate;
		}

	public void setSetDataRate(int setDataRate) {
			this.setDataRate = setDataRate;
		}
	
	public boolean isAP() {
		return AP;
	}

	public void setAP(boolean aP) {
		AP = aP;
	}

	public boolean isSub() {
		return Sub;
	}

	public void setSub(boolean sub) {
		Sub = sub;
	}

	public ArrayList<Radio> getConnections() {
		return connections;
	}

	public void setConnections(ArrayList<Radio> connections) {
		this.connections = connections;
	}

	public Antenna getAntenna() {
		return antenna;
	}

	public void setAntenna(Antenna antenna) {
		this.antenna = antenna;
	}

	public void addConn(Radio r){
		if (Sub==true) {
			connections.add(r);
			r.addConn(this);
		}
		else if(AP==true)
			connections.add(r);
		
	}
    public void rmvConn(Radio r){
    	
    	if(AP==true) {
    		int i = 0;
    		for(Radio s: connections) {
    			if(r.getIdNum()==s.getIdNum()) {
    				connections.remove(i);
    				r.rmvConn(this);
    			}
    			i++;
    		}
    				
    	}
    	else if(Sub==true) {
    		int i = 0;
    		for(Radio s: connections) {
    			if(r.getIdNum()==s.getIdNum()) 
    				connections.remove(i);
    		}
    		i++;
    	}	
    		
    }
    public int calcAvailData(){
    	int avail = maxDataRate;
    	
    	for(Radio r:connections)
    		avail = avail -r.getSetDataRate();
    	return avail;
    }


}
