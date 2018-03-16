package guest;

import java.io.Serializable;

public abstract class Guest implements Serializable{

	private String name;
	
	public Guest(String name) {
		this.name = name;
	}
	public Guest() {}	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	public String guestType(Guest g) {
		Student s = new Student("");
		Lecturer l = new Lecturer(""); 
		String guestType = null;
		
		if(g.getClass() == s.getClass()) {
			guestType = "Student";
			return guestType;
		}
		else if(g.getClass() == l.getClass()) {
			guestType = "Lecturer";
			return guestType;
		}
		return guestType;
	}
	
	
	public Guest getGuestType(Guest g) {
		Student s = new Student("");
		Lecturer l = new Lecturer(""); 
		
		if(g.getClass() == s.getClass()) {
			return g;
		}
		else if(g.getClass() == l.getClass()) {
			return g;
		}
		return g;
	}
}
