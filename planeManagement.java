

public class planeManagement {
	public static void main(String args[]){
		
		Plane p = new Plane("Boeing 707",250);
		MaintenanceEmployee ec = new MaintenanceEmployee("Irine");
		SecurityEmployee se = new SecurityEmployee("Markos");
		CleaningEmployee ce = new CleaningEmployee("John");
		
		p.process(ec);
		ec.report();
		p.process(se);
		se.report();
		p.process(ce);
		ce.report();
		
		//Check if the plane is ready to take off
		if(p.readyCheck()) 
			System.out.println(p.getName()+" is ready to take off!");
		else
			System.out.println(p.getName()+" is not ready yet!");
		
/*		Not needed code just some additions I did (equal,copy constructor)	=-)	*/
		
//		Plane p2 = new Plane(p);
//		System.out.println(p);
//		System.out.println(p2);
//		
//		if(p.equals(p2))
//			System.out.println("The planes are equal!");
//		else
//			System.out.println("The planes are not equal!");
	}
}
