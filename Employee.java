

abstract public class Employee {
	protected int id;
	private static int count=0;
	protected String name;
	
	public Employee(String empName) {
		name = empName;
		id = ++count;
	}
	
	public Employee(Employee src) {		//Copy Constructor
		this.id = src.id;
		this.name = src.name;
	}
	
	public int getId() {
		return id;
	}
	
	public static int getCount() {
		return count;
	}
	
	public String getName() {
		return name;
	}
	
	abstract public void report();
	public void workOn(PassengerCompartment pc) {}
	public void workOn(EquipmentCompartment ec) {}
	abstract public void workOn(CargoBay cb);
	abstract public boolean equals(Object o);
}
