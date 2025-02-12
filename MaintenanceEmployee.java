

public class MaintenanceEmployee extends Employee {

	public MaintenanceEmployee(String empName) {
		super(empName);
	}
	
	public MaintenanceEmployee(MaintenanceEmployee src) {		//Copy Constructor
		super(src);
	}
	
	public String toString() {
		return "#"+getId()+" MaintenanceEmployee ("+getName()+")";
	}
	
	public void report() {
		System.out.println("Maintenance Employee reports that everything is OK!");
	}
	
	public void workOn(EquipmentCompartment ec) {
		ec.chckMainFlag();
		System.out.println("Equipment Compartment processed!");
	}
	
	public void workOn(CargoBay cb) {
		cb.chckMainFlag();
		System.out.println("Cargo Bay processed!");
	}
	
	public boolean equals(Object o) {
		if(o == this) {
			System.out.println("They are identical!");
			return true;
		}
		
		if(!(o instanceof MaintenanceEmployee))
			return false;
		
		MaintenanceEmployee seOb = (MaintenanceEmployee) o;		//Typecast so that we can compare data members
		if(seOb.getId() != this.getId() || seOb.getName() != this.getName())
			return false;
		
		return true;
	}
}
