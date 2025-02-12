

public class SecurityEmployee extends Employee {
	
	public SecurityEmployee(String empName) {
		super(empName);
	}
	
	public SecurityEmployee(SecurityEmployee src) {		//Copy Constructor
		super(src);
	}
	
	public String toString() {
		return "#"+getId()+" SecurityEmployee ("+getName()+")";
	}
	
	public void report() {
		System.out.println("Security Employee reports that everything is OK!");
	}
	
	public void workOn(PassengerCompartment pc) {
		pc.chckSecFlag();
		System.out.println("Passenger Compartment processed!");
	}
	
	public void workOn(EquipmentCompartment ec) {
		ec.chckSecFlag();
		System.out.println("Passenger Compartment processed!");
	}
	
	public void workOn(CargoBay cb) {
		cb.chckSecFlag();
		System.out.println("Cargo Bay processed!");
	}
	
	public boolean equals(Object o) {
		if(o == this) {
			System.out.println("They are identical!");
			return true;
		}
		
		if(!(o instanceof SecurityEmployee))
			return false;
		
		SecurityEmployee seOb = (SecurityEmployee) o;		//Typecast so that we can compare data members
		if(seOb.getId() != this.getId() || seOb.getName() != this.getName())
			return false;
		
		return true;
	}
}
