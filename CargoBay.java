

public class CargoBay extends PrivateCompartment {
	private EquipmentCompartment insideEquiComp;
	private boolean secFlag = false;
	private boolean mainFlag = false;
	private boolean cleanFlag = false;
	
	public CargoBay() {
		insideEquiComp = new EquipmentCompartment();		
	}
	
	public CargoBay(CargoBay src) {
		super(src);
		this.insideEquiComp = new EquipmentCompartment(src.insideEquiComp);
		this.secFlag = src.secFlag;
		this.mainFlag = src.mainFlag;
		this.cleanFlag = src.cleanFlag;
	}

	public String toString() {
		String temp = "#"+getId()+" CargoBay -> (PrivateCompartment) -> (PlaneComponent)";
		temp += "\n#"+insideEquiComp.getId()+" Inside EquipmentCompartment -> (PrivateCompartment) -> (PlaneComponent)";
		
		return temp;
	}
	
	public EquipmentCompartment getInsideEquiComp() {
		return insideEquiComp;
	}
	
	public boolean getSecFlag() {
		return secFlag;
	}
	
	public boolean getMainFlag() {
		return mainFlag;
	}
	
	public boolean getCleanFlag() {
		return cleanFlag;
	}
	
	public void process(Employee e) {
		e.workOn(this.insideEquiComp);
		e.workOn(this);
	}
	
	public boolean readyCheck() {
		System.out.println(this.toString());
		
		if(secFlag && mainFlag && cleanFlag && insideEquiComp.readyCheck()) {
			System.out.println("Cargo Bay OK!");
			return true;
		}
		System.out.println("Cargo Bay is not OK!");
		return false;
	}
	
	public void chckSecFlag() {
		secFlag = true;
	}
	
	public void chckMainFlag() {
		mainFlag = true;
	}
	
	public void chckCleanFlag() {
		cleanFlag = true;
	}
	
	public boolean equals(Object o) {
		if(o == this) {
			System.out.println("They are identical!");
			return true;
		}
		
		if(!(o instanceof CargoBay))
			return false;
		
		CargoBay seOb = (CargoBay) o;		//Typecast so that we can compare data members
		if(seOb.getId() != this.getId())
			return false;
		
		if(!(seOb.insideEquiComp.equals(this.insideEquiComp)))		//Check inside space
			return false;
		return true;
	}
}
