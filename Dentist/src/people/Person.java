package people;
import java.io.Serializable;

public abstract class Person implements Serializable {
	protected String fName;
	protected String lName;
	protected String address;
	
	public Person(String fName, String lName, String address) {
		super();
		this.fName = fName;
		this.lName = lName;
		this.address = address;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Person [fName=" + fName + ", lName=" + lName + ", address=" + address + "]";
	}
	
	public void Print() {
		System.out.println(toString());
	}
		
}