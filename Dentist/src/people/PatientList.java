package people;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import maintenence.Procedure;
import monetary.Invoice;

import java.util.Scanner;

public class PatientList implements Serializable {
	Scanner keyboard = new Scanner(System.in);
	private ArrayList<Patient> invoiceList;
	private Patient patient;
	
	public PatientList() {									
		invoiceList = new ArrayList<Patient>();
	}
	
	public ArrayList<Patient> getList() {					//gets invoice List
		if(invoiceList == null) {
			return null;
		}
		return this.invoiceList;
	}
	
	public void addPatient(Patient patient) {								//adds a room to the roomlist
		this.invoiceList.add(patient);
	}
	
	public void removePatient(Patient patient) {								//adds a room to the roomlist
		this.invoiceList.remove(patient);
	}
	
	public Patient findPatient(PatientList pList) {											//Finds patient by Name and ID Number
		String fName;
		int ID;
		System.out.println("What is the first name of the patient you wish to remove?");
		fName = keyboard.next();
		System.out.println("=============================\n\tPATIENTS CALLED "+fName.toUpperCase()+" LIST\n");
		for(Patient p: pList.getList()) { 
		if(fName.toUpperCase().equals(p.getfName().toUpperCase())) 
			System.out.println("\n\tPatient No: "+p.getID()
							+"\n\tName: "+p.getFName()+" "+p.getLName()+"\n");
		}
		System.out.println("Please enter the Patient ID number of the patient you wish to remove");
		ID = keyboard.nextInt();
		for(Patient p: pList.getList())
			if(p.getID()==ID) {
			return p;
			}
		
		return null;
	}
	
	public void addInvoiceForPatient(Patient p) {
		Date date = new Date();
		Invoice inv = new Invoice(date);
		
	}
	
	public void displayPatients() {					//gets invoice List
		System.out.println("=============================\n\tPATIENTS LIST\n");
		for(Patient p: getList())
			System.out.println("\n\tPatient No: "+p.getID()
								+"\n\tName: "+p.getFName()+" "+p.getLName()
								+"\n\tAddress: "+p.getAddress()
								+"\n\tPhone No: "+p.getPhoneNum());
		
	}
	
	
}
