
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person p1;
		SerialStorage ser = new SerialStorage();
		//read our serial object from file and cast the object to be a person
		p1 = (Person)ser.readFromFile("person.ser") ;
		
		//no file stored, create person and save them to file
		if(p1==null) {
			p1 = new Person(32,"Diarmuid");		
			ser.saveToFile("person.ser", p1);
			System.out.println("\nPerson file is empty, storing new person object of "+p1);
		}
		else {//reading from file
			System.out.println("Person loaded from file, details are -  "+p1);
		}
		
		
	}

}
