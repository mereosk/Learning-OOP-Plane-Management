

public class PassengerCompartment extends PlaneComponent {
	private PassengerCompartment insidePasComp;
	private boolean secFlag = false;
	private boolean cleanFlag = false;
	
	public PassengerCompartment(boolean checkIfIn) {
		if(checkIfIn == true)
			makeInsidePasComp();
	}
	
	public PassengerCompartment(PassengerCompartment src) {
		super(src);
		if(src.insidePasComp != null)
			this.insidePasComp = new PassengerCompartment(src.insidePasComp);
		this.secFlag = src.secFlag;
		this.cleanFlag = src.cleanFlag;
	}
	
	public void makeInsidePasComp() {
		insidePasComp = new PassengerCompartment(false);
	}
	
	public String toString() {
		String temp = "#"+getId()+" PassengerCompartment -> (PlaneComponent)";
		if(insidePasComp != null) 
			return temp+"\n#"+insidePasComp.getId()+" Inside PassengerCompartment -> (PlaneComponent)";
		return temp;
	}
	
	public PassengerCompartment getInsidePasComp() {
		return insidePasComp;
	}
	
	public boolean getSecFlag() {
		return secFlag;
	}
	
	public boolean getCleanFlag() {
		return cleanFlag;
	}
	
	public void process(Employee e) {
		if(insidePasComp != null)
			e.workOn(this.insidePasComp);
		e.workOn(this);
	}
	
	public boolean readyCheck() {
		System.out.println(this.toString());
		
		if(secFlag && cleanFlag) {
			
			if(insidePasComp != null) {
				if(!insidePasComp.readyCheck()) {
					return false;
				}
			}
			System.out.println("Passenger Compartment OK!");
			return true;
		}
		System.out.println(getId());
		System.out.println("Passenger Compartment is not OK!");
		return false;
	}
	
	public void chckSecFlag() {
		secFlag = true;
	}
	
	public void chckCleanFlag() {
		cleanFlag = true;
	}
	
	public boolean equals(Object o) {
		if(o == this) {
			System.out.println("They are identical!");
			return true;
		}
		
		if(!(o instanceof PassengerCompartment))
			return false;
		
		PassengerCompartment seOb = (PassengerCompartment) o;		//Typecast so that we can compare data members
		if(seOb.getId() != this.getId())
			return false;
		
		if(this.insidePasComp != null)			//Check the inside Pas Comp If it exists
			if(!(this.insidePasComp.equals(seOb.insidePasComp)))
				return false;
		
		return true;
	}
}
