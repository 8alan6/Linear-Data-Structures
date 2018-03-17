package main;
import guest.Guest;
import guest.Lecturer;
import guest.Student;
import persistence.FileStorage;
import room.Room;
import room.RoomList;
import room.Double;
import room.Single;
import room.Single;

import java.util.ArrayList;
import java.util.Scanner;

import exception.MyException;

public class Menu {
	private Guest guest;											//Declare Variables				
	private RoomList rooms;
	private Room room;
	private Controller control;


	private static final int DISPLAY_ALL_AVAILABLE_ROOMS =1;		//Menu Options
	private static final int DISPLAY_ALL_CURRENT_GUESTS =2;
	private static final int PROCESS_A_NEW_RESERVATION = 3;
	private static final int DISPLAY_PAYMENTS = 4;
	private static final int EXIT_THE_SYSTEM = 5;

	public Menu(RoomList rooms) {									//Menu needs a RoomList to be created
		this.rooms = rooms;
		this.control = new Controller();
	}

	public void beginProgram()										//beginProgram Method
	{
		Scanner keyboard = new Scanner(System.in);
		int userChoice;

		displayMenu();												//calls the DisplayMenu method from below.
		userChoice = keyboard.nextInt();							//user picks an option from the menu list

		while(userChoice != EXIT_THE_SYSTEM) 						//keep looping while user does not hit EXIT
		{
			switch(userChoice) 										
			{
			case DISPLAY_ALL_AVAILABLE_ROOMS:{						//Display All Current Guests
				allAvailableRooms(1);								//calls the allAvilableRooms method from below.
				break;
			}
			case DISPLAY_ALL_CURRENT_GUESTS:{						//Display All Current Guests
				control.displayAllGuests(rooms);					//calls the displayAllGuests method from the controller
				break;
			}
			case PROCESS_A_NEW_RESERVATION:							//this case brings user to the Reservations Sub-Menu
			{
				int scenario;
				reservationMenu();									//loads the reservations sub-menu
				scenario = control.chooseFromReservationMenu();		//gets user to choose option from the reservation sub-menu
																	//uses the controller to call chooseFromReservationMenu method.
				switch(scenario){	
				case 1:												//NEW_RESERVATION
				{
					guest = control.addGuest();						//guest info is gathered from control.addGuest
					allAvailableRooms(0);							//allAvailableRooms method is called
					room = control.chooseRoom(rooms);				//pick a room using the controller to call the chooseRoom method  

					try {
						room.addGuest(guest);						//add a guest to the room
					}
					catch (MyException e) {
						e.printStackTrace();						//prints any error
					}//END OF CATCH

					control.addExtraGuests(room);					//addExtraGuests asks guest if more checking into this room.
					successfullCheckIn(rooms, room);				//calls successfulCheckIn method from below.						
					break;
				}													//END OF CASE 1: NEW_RESERVATION

				case 2:												//VIEW_RESERVATION
				{
					control.viewReservationList(rooms);				//calls viewReservationList method using the controller
					break;
				}													//END OF CASE 2: VIEW_RESERVATION

				case 3:												//CANCEL_RESERVATION
				{
					control.cancelReservation(rooms);				//calls cancelReservation method using the controller
					break;
				}													//End OF CASE 3: CANCEL_RESERVATION

				case 4:												//RETURN_TO_MAIN_MENU
				{
					displayMenu();									//calls the displayMenu method
					userChoice = keyboard.nextInt();				//waits for user input
					break;
				}													//END OF CASE 4: RETURN_TO_MAIN_MENU

				}//END_OF_SWITCH
				break;
			}//END OF REESERVATION

			case DISPLAY_PAYMENTS:{									//DISPLAY PAYMENTS OPTION
				processingPayments();								//calls proccessingPayments from below.
				userChoice = keyboard.nextInt();
				switch(userChoice) {
				case 1:
					control.payments(rooms, guest, userChoice); 	//calls payments method using controller 
					break;											//userChoice here allows access to different parts of the method.			
				case 2:
					control.payments(rooms, guest, userChoice);		//calls payments method using controller
					break;											//userChoice here allows access to different parts of the method.
				}
				break;
			}																			//END OF DISPLAY PAYMENTS
			}//Switch
			displayMenu();																//calls the displayMenu method from below
			userChoice = keyboard.nextInt();						
		}//while
		//HERE THE USER HAS CHOOSEN TO EXIT THE PROGRAM
		keyboard.nextLine();
		System.out.println("Do you wish to save to file (YES/NO)?");			//ask to save to file
		String choice;
		choice = keyboard.nextLine();

		if(choice.toUpperCase().contentEquals("YES") || choice.toUpperCase().contentEquals("Y")){ //if YES or Y then save to file															//save to file
			FileStorage.storeObject(rooms, "rooms.ser");
			FileStorage.storeObject(room, "room.ser");
			FileStorage.storeObject(guest, "guests.ser");
			System.out.println("\nSAVED: GOODBYE !!");
		}
		else {																			//do not save to file			
			System.out.println("NOT SAVED: GOODBYE !!");
		}														

	}																					//START PROGRAM METHOD ENDS

	public void displayMenu() {															//This is the displayMenu method
		double overallTotal; 
		try{
			overallTotal = (double)FileStorage.readObject("Earnings.ser");
		}
		catch(Exception e){
			overallTotal = 0;
		}
		overallTotal = overallTotal + control.totalEarnings();
		System.out.println("");
		System.out.println("    CORK INSTITUTE OF TECHNOLOGY HOTEL    ");
		System.out.println("*********************** Days Earnings: €"+control.totalEarnings()+"0");
		System.out.println("1. Display All Available Rooms");
		System.out.println("2. Display All Current Guests");
		System.out.println("3. Process A New Reservation");
		System.out.println("4. Display Payments");
		System.out.println("5. Exit System");
		System.out.println("********************** Total Earnings: €"+overallTotal+"0");
	}

	public void reservationMenu() {														//This is the reservationMenu method
		System.out.println("");
		System.out.println("        CIT HOTEL RESERVATION MENU         ");
		System.out.println("*******************************************");
		System.out.println("1. New Reservation");
		System.out.println("2. View All Reservations");
		System.out.println("3. Cancel A Reservation");
		System.out.println("4. Return To Main Menu");
		System.out.println("");
		System.out.println("");
		System.out.println("*******************************************");
	}

	//int 'i' allows access to different parts of the method 
	public void allAvailableRooms(int i) {												//This is the reservationMenu method
		System.out.println("");
		System.out.println("        CIT HOTEL AVAILABLE ROOMS          ");
		System.out.println("*******************************************");

		if(i<1) {				//'i' accesses just how many of each type of room are available.
			System.out.println("Suite  : "+rooms.getFreeRooms("suite")+
					"\tDouble : "+rooms.getFreeRooms("double")+
					"\tSingle : "+rooms.getFreeRooms("single")+"\n\n");
		}

		if(i>0) {				//'i' access a list of every room available.

			System.out.println("\t\t== Suites ==");										//prints a list of the suites available
			for(Room r: rooms.getList()) {
				if(r.isEmpty(r)) {
					if(r.getClass().getSimpleName().toUpperCase().contains("SUITE")) {
						System.out.println("\t\t  Room : "+r.getRoomNumber());
					}
				}
			}
			System.out.println("");
			System.out.println("\t\t== Doubles ==");									//prints a list of the doubles available
			for(Room r: rooms.getList()) {
				if(r.isEmpty(r)) {
					if(r.getClass().getSimpleName().toUpperCase().contains("DOUBLE")) {
						System.out.println("\t\t  Room : "+r.getRoomNumber());
					}
				}
			}
			System.out.println("");
			System.out.println("\t\t== Singles ==");									//prints a list of the singles available		
			for(Room r: rooms.getList()) {
				if(r.isEmpty(r)) {
					if(r.getClass().getSimpleName().toUpperCase().contains("SINGLE")) {
						System.out.println("\t\t  Room : "+r.getRoomNumber());
					}
				}
			}
			System.out.println("*******************************************\n");
		}
	}

	public void successfullCheckIn(RoomList rooms, Room room) {				//This is the successfullCheckIn method
		System.out.println("\n        SUCCESSFUL RESERVATION             ");
		System.out.println("*******************************************\n");
		System.out.println(+rooms.getNumberOfGuestsInRoom(room)
		+" GUESTS HAVE CHECKED INTO ROOM NUMBER "							//Prints details of the check-in to the screen
		+room.getRoomNumber()
		+".\n\tTHIS ROOM IS A "+room.getRoomType(room).toUpperCase());
		System.out.println("\n*******************************************\n");
	}

	public void processingPayments() {										//This is the processingPayments menu method
		System.out.println("\n        PROCESS PAYMENTS             ");
		System.out.println("*******************************************\n");
		System.out.println("1. Check an outstanding balance on a room.");
		System.out.println("2. Pay the outstanding balance for a room.");
		System.out.println("\n*******************************************\n");
	}
}//END END


