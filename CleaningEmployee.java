

public class CleaningEmployee extends Employee {

	public CleaningEmployee(String empName) {
		super(empName);
	}
	
	public CleaningEmployee(CleaningEmployee src) {		//Copy Constructor
		super(src);
	}
	
	public String toString() {
		return "#"+getId()+" CleaningEmployee ("+getName()+")";
	}
	
	public void report() {
		System.out.println("CleaningEmployee reports that everything is OK!");
	}
	
	public void workOn(PassengerCompartment pc) {
		pc.chckCleanFlag();
		System.out.println("Passenger Compartment processed!");
	}
	
	public void workOn(CargoBay cb) {
		cb.chckCleanFlag();
		System.out.println("Cargo Bay processed!");
	}
	
	public boolean equals(Object o) {
		if(o == this) {
			System.out.println("They are identical!");
			return true;
		}
		
		if(!(o instanceof CleaningEmployee))
			return false;
		
		CleaningEmployee seOb = (CleaningEmployee) o;		//Typecast so that we can compare data members
		if(seOb.getId() != this.getId() || seOb.getName() != this.getName())
			return false;
		
		return true;
	}
}
