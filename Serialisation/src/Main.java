
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		PersonList plist;
		SerialStorage ser = new SerialStorage();
		//read our serial object from file and cast the object to be a person
		plist = (PersonList)ser.readObject("people.ser") ;
		
		//no file stored, create person and save them to file
		if(plist==null) {
			plist = new PersonList();
			Person p1 = new Person(35,"Steve");
			Person p2 = new Person(32,"Alan");
			Person p3 = new Person(21,"Dave");
			Person p4 = new Person(30,"Brian");
			plist.addPerson(p1);
			plist.addPerson(p2);
			plist.addPerson(p3);
			plist.addPerson(p4);
			ser.storeObject("people.ser", plist);
			System.out.println("\nPersonList file is empty, storing new person objects to "+plist.getClass());
		}
		else {//reading from file
			System.out.println("PersonList loaded from file, details are....");
			plist.getPeopleDetails();
		}
		
		
	}

}
