package application;
import people.Dentist;
import people.Patient;
import people.PatientList;

import java.util.Scanner;

import maintenence.Procedure;
import maintenence.ProcedureList;
import monetary.Invoice;
import java.util.ArrayList;
import java.util.Date;


public class Controller {
	Scanner keyboard = new Scanner(System.in);
	PatientList patients = null;
	Patient p = null;
	ProcedureList procedureList = null;
	Procedure procedure = null;
	
	
	
	
	public void login(int attempt) {
		String inputName;
		String inputPass;
		int loginAttempt = attempt;
		Dentist d = new Dentist("Dentist","password");

		
		System.out.println("what is your username?");
		inputName = keyboard.nextLine();
		System.out.println("What is your password?");
		inputPass = keyboard.nextLine();
		Boolean yesNo;
		yesNo = d.validLogin(inputName, inputPass);
		if(yesNo.equals(true)) {														//successful Login
			System.out.println("Welcome");
			createPatientProcedureList();
			
		}
		else {																			//Failed login attempt
			loginAttempt++;
			System.out.println("\tFailed to Login");
			if(loginAttempt<3) {														//Final Chance to Login again
				if(loginAttempt==2) {
					System.out.println("\tThis is your final chance to login\n");
					login(loginAttempt);
				}
				else {
					System.out.println("\tYou have "+(3-loginAttempt)+" attempts left\n");	//try Again
					login(loginAttempt);
				}
			}
			else {																		//complete failure to login, 
				System.out.println("\tPlease re-run program.");
			}
		}
	}
	
	public void createPatientProcedureList() {
		patients = (PatientList)SerialStorage.readObject("patientList.ser");	
		
		if(patients==null) {
			patients = loadDefaultPatients();	
			}
			else {
				System.out.println("Patients loaded from file");
			}
		
		procedureList = (ProcedureList)SerialStorage.readObject("procedures.ser");
		
		if(procedureList==null) {
			procedureList = loadDefaultProcedures();	
			}
			else {
				System.out.println("Procedures loaded from file");
			}
	
		loadMenu();
	}
	
	
	public static PatientList loadDefaultPatients() {							//Generates a set of Rooms for the hotel.
		PatientList patList = new PatientList();																							//RoomList rooms is created
		
		Patient p1 = new Patient("Michael","J. Fox","Cork","087-1599874");
		Patient p2 = new Patient("Al","Pacino","Limerick","086-1245787");
		Patient p3 = new Patient("Saoirse","Ronan","Dublin","085-3265989");
		Patient p4 = new Patient("Michelle","Obama","Offaly","083-1425363");
		Patient p5 = new Patient("Pierce","Brosnan","Louth","086-1245323");
		Patient p6 = new Patient("Michael","Fassbender","Kerry","086-1548737");
		Patient p7 = new Patient("Sonia","O'Sullivan","Cork","087-2585252");
		Patient p8 = new Patient("Barack","Obama","Offaly","086-3696363");
		Patient p9 = new Patient("Michael","Schumacher","Galway","086-1474141");
		Patient p10 = new Patient("Morgan","Freeman","Clare","083-1595951");
		
		patList.addPatient(p1);
		patList.addPatient(p2);
		patList.addPatient(p3);
		patList.addPatient(p4);
		patList.addPatient(p5);
		patList.addPatient(p6);
		patList.addPatient(p7);
		patList.addPatient(p8);
		patList.addPatient(p9);
		patList.addPatient(p10);
		
		SerialStorage.storeObject("patientList.ser", patList);
		return patList;																		//return the RoomList rooms
}

	public static ProcedureList loadDefaultProcedures() {							//Generates a set of Rooms for the hotel.
		ProcedureList proList = new ProcedureList();
		
		Procedure filling = new Procedure("Filling", 49.99);
		Procedure rootCanal = new Procedure("Root Canal", 199.99);
		Procedure cleaning = new Procedure("Cleaning", 28.55);
		Procedure braces = new Procedure("Braces", 5600.00);
		Procedure crown = new Procedure("Crown", 99.99);
		
		proList.addProcedure(filling);
		proList.addProcedure(rootCanal);
		proList.addProcedure(cleaning);
		proList.addProcedure(braces);
		proList.addProcedure(crown);
		
		
		SerialStorage.storeObject("procedures.ser", proList);										//save rooms object to a file.
		return proList;																		//return the RoomList rooms
}
	
	public void addPatient(PatientList pList) {
		String fName;
		String lName;
		String address;
		String phoneNo;
		System.out.println("What is patients first name?");
		fName = keyboard.next();
		System.out.println("What is "+fName+"'s surname?");
		lName = keyboard.next();
		System.out.println("What is "+fName+" "+lName+"'s address?");
		address = keyboard.next();
		System.out.println("What is "+fName+" "+lName+"'s phone number?");
		phoneNo = keyboard.next();
		Patient p = new Patient(fName,lName,address,phoneNo);
		pList.addPatient(p);
	}
	
	public void loadMenu() {
		int userChoice;
		System.out.println("PLEASE CHOOSE AN OPTION");
		System.out.println("1. Display Patients");
		System.out.println("2. Display Procedures");
		System.out.println("3. Add Patient");
		System.out.println("4. Remove Patient");
		System.out.println("5. EXIT");
		userChoice = keyboard.nextInt();								

		switch(userChoice) {
		case 1:	
			patients.displayPatients();							//Display Patient List
			break;

		case 2:													//Display Procedure List
			procedureList.displayProcedures();
			break;
			
		case 3:
			addPatient(patients);								//add Patient to Patient List
			System.out.println("New Patient successfully added");
			break;
		
		case 4:
			Patient match = patients.findPatient(patients);				//Finds Patient from Patient List
			patients.removePatient(match);								//removes the matched patient.
			System.out.println(match.getFName()+" "+match.getLName()+" has been removed");
			break;
		case 5:
			Patient select = patients.findPatient(patients);
			patients.addInvoiceForPatient(select);
		
		}
		
		System.out.println("");
		loadMenu();
	}
	
	
	
}