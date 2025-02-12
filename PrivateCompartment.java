
abstract public class PrivateCompartment extends PlaneComponent {
	public PrivateCompartment() {
		
	}
	
	public PrivateCompartment(PrivateCompartment src) {
		super(src);
	}
	
	abstract public boolean readyCheck();
	abstract public void process(Employee e);
	abstract public boolean equals(Object o);
}
