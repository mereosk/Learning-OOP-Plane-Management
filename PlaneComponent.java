

abstract public class PlaneComponent {
	protected int id;
	private static int count = 0;
	
	public PlaneComponent() {
		id = ++count;
	}
	
	public PlaneComponent(PlaneComponent src) {
		this.id = src.id;
	}
	
	public int getId() {
		return id;
	}
	
	public static int getCount() {
		return count;
	}
	
	abstract public boolean readyCheck();
	abstract public void process(Employee e);
	abstract public boolean equals(Object o);
}
