package people;

import java.util.ArrayList;

import maintenence.Procedure;
import monetary.Invoice;

public class Patient extends Person {

	private int ID;
	private String phoneNum;
	static int PATIENT_ID = 101;
	ArrayList<Invoice> invoiceList = new ArrayList<Invoice>();


	public Patient(String fName, String lName, String address, String phoneNum) {
		super(fName, lName, address);
		ID = PATIENT_ID;
		PATIENT_ID++;
		this.phoneNum = phoneNum;
		getFName();
		getAddress();
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getFName() {
		return fName;
	}

	public void setFName(String name) {
		this.fName = name;
	}
	
	public String getLName() {
		return lName;
	}

	public void setLName(String name) {
		this.lName = name;
	}


	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getID() {
		return this.ID;
	}

	public void setID(int ID) {
		this.ID = ID;
	}

	public String toString() {
		return "\n\tPatient Number: "+this.ID+"\n\tName: "+fName+" "+lName+"\n\tAddress: "+address+"\n\tPhone: "+phoneNum+"\n";
	}

	public void Print() {
		System.out.println(toString());
	}
	
	
}