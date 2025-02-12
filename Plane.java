

import java.util.Random;

public class Plane {
	private String name;
	private int capacity;
	private CargoBay cb;
	private EquipmentCompartment ecArray[];
	private PassengerCompartment pcArray[];
	private int  numberOfPasComp;
	
	public Plane(String nameOfPlane, int capacOfPlane) {
		name = nameOfPlane;
		capacity = capacOfPlane;
		
		cb = new CargoBay();
		
		ecArray = new EquipmentCompartment[3];
		for(int i=0 ; i<3 ; i++)
			ecArray[i] = new EquipmentCompartment();
		
		Random random = new Random();
		
		numberOfPasComp = capacity/(50+random.nextInt(101));
		System.out.println(numberOfPasComp);
		
		if(numberOfPasComp == 0)		//Dont let it be zero
			numberOfPasComp = 1;
		
		pcArray = new PassengerCompartment[numberOfPasComp];
		for(int i=0 ; i<numberOfPasComp ; i++)
			pcArray[i] = new PassengerCompartment(random.nextBoolean());
	}
	
	public Plane(Plane src) {
		this.name = src.name;
		this.capacity = src.capacity;
		this.numberOfPasComp = src.numberOfPasComp;
		this.cb = new CargoBay(src.cb);
		
		this.ecArray = new EquipmentCompartment[3];
		for(int i=0 ; i<3 ; i++) 
			this.ecArray[i] = new EquipmentCompartment(src.ecArray[i]);
		
		this.pcArray = new PassengerCompartment[src.numberOfPasComp];
		for(int i=0 ; i<src.numberOfPasComp ; i++) 
			this.pcArray[i] = new PassengerCompartment(src.pcArray[i]);		
	}
	
	public String toString() {
		String temp = "Plane: " + this.name + "\nCapacity: " + capacity + "\n";
		temp += cb.toString() + "\n";
		for(int i=0 ; i<3 ; i++)
			temp += ecArray[i].toString()+"\n";
		for(int i=0 ; i<numberOfPasComp ; i++)
			temp += pcArray[i].toString()+"\n";
		
		return temp;
	}
	
	public String getName() {
		return name;
	}
	
	public int getCapacity() {
		return capacity;
	}
	
	public CargoBay getCarBay() {
		return cb;
	}
	
	public EquipmentCompartment getEquiComp(int pos) {
		return ecArray[pos];
	}
	
	public PassengerCompartment getPasComp(int pos) {
		return pcArray[pos];
	}
	
	public void process(Employee e) {
		cb.process(e);
		
		for(int i=0 ; i<3 ; i++)
			ecArray[i].process(e);
		
		for(int i=0 ; i<numberOfPasComp ; i++)
			pcArray[i].process(e);
	}
	
	public boolean readyCheck() {		
	
		if(!cb.readyCheck())
			return false;
		for(int i=0 ; i<3 ; i++)
			if(!ecArray[i].readyCheck())
				return false;
		for(int i=0 ; i<numberOfPasComp ; i++)
			if(!pcArray[i].readyCheck())
				return false;
		
		System.out.println(this.toString());
		return true;		//It is ready
	}
	
	public boolean equals(Object o) {
		if(o == this) {
			System.out.println("They are identical!");
			return true;
		}
		
		if(!(o instanceof Plane))
			return false;
		
		Plane seOb = (Plane) o;		//Typecast so that we can compare data members
		
		if(this.name != seOb.name)
			return false;
		
		if(this.capacity != seOb.capacity)
			return false;
		
		if(!(this.cb.equals(seOb.cb)))
			return false;
		
		for(int i=0 ; i<3 ; i++)
			if(!(this.ecArray[i].equals(seOb.ecArray[i])))
				return false;
		
		if(this.numberOfPasComp != seOb.numberOfPasComp)
			return false;
		
		for(int i=0 ; i<this.numberOfPasComp ; i++)
			if(!(this.pcArray[i].equals(seOb.pcArray[i])))
				return false;
		
		return true;
	}
}
