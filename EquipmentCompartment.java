

public class EquipmentCompartment extends PrivateCompartment {
	private boolean secFlag = false;
	private boolean mainFlag = false;	
	
	public EquipmentCompartment() {	
	}
	
	public EquipmentCompartment(EquipmentCompartment src) {
		super(src);
		this.secFlag = src.secFlag;
		this.mainFlag = src.mainFlag;
	}
	
	public String toString() {
		return "#"+getId()+" EquipmentCompartment -> (PrivateCompartment) -> (PlaneComponent)";
	}
	
	public boolean getSecFlag() {
		return secFlag;
	}
	
	public boolean getMainFlag() {
		return mainFlag;
	}
	
	public void process(Employee e) {
		e.workOn(this);
	}
	
	public boolean readyCheck() {
		System.out.println(this.toString());
		
		if(secFlag && mainFlag) {
			System.out.println("Equipment Compartment OK!");
			return true;
		}
		System.out.println("Equipment Compartment is not OK!");
		return false;
	}
	
	public void chckSecFlag() {
		secFlag = true;
	}
	
	public void chckMainFlag() {
		mainFlag = true;
	}
	
	public boolean equals(Object o) {
		if(o == this) {
			System.out.println("They are identical!");
			return true;
		}
		
		if(!(o instanceof EquipmentCompartment))
			return false;
		
		EquipmentCompartment seOb = (EquipmentCompartment) o;		//Typecast so that we can compare data members
		if(seOb.getId() != this.getId() )
			return false;
		
		return true;
	}
}
