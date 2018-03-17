import java.io.Serializable;
import java.util.ArrayList;


public class PersonList implements Serializable {
	private ArrayList<Person> peopleList;
	private Person patient;
	//private PersonList people;
	
	public PersonList() {									
		peopleList = new ArrayList<Person>();
	}
	
	public ArrayList<Person> getList() {					//gets invoice List
		if(peopleList == null) {
			return null;
		}
		return this.peopleList;
	}
	
	
	public void addPerson(Person p) {								//adds a room to the roomlist
		this.peopleList.add(p);
	}
	
	public void getPeopleDetails() {
		for(Person p: getList()) {
			System.out.println(p.toString());
		}
	}
}
