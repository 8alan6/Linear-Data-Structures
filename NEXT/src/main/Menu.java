package main;
import guest.Guest;
import guest.Lecturer;
import guest.Student;
import room.Room;
import room.RoomList;
import room.Double;
import room.Single;
import room.Single;

import java.util.ArrayList;
import java.util.Scanner;

import exception.DiarmuidsException;

public class Menu {
	private Guest guest;
	private RoomList rooms;
	private Room room;
	private Controller control;
	

	private static final int DISPLAY_ALL_AVAILABLE_ROOMS =1;
	private static final int DISPLAY_ALL_CURRENT_GUESTS =2;
	private static final int PROCESS_A_NEW_RESERVATION = 3;
	private static final int DISPLAY_PAYMENTS = 4;
	private static final int EXIT_THE_SYSTEM = 5;

	public Menu(RoomList rooms) {
		this.rooms = rooms;
		this.control = new Controller();
	}

	public void beginProgram()
	{
		Scanner keyboard = new Scanner(System.in);
		int userChoice;

		displayMenu();
		userChoice = keyboard.nextInt();

		while(userChoice != EXIT_THE_SYSTEM) 									//keep looping while user does not hit EXIT
		{
			switch(userChoice) 
			{
			case DISPLAY_ALL_AVAILABLE_ROOMS:{
				allAvailableRooms(1);
				break;
			}
			
			case DISPLAY_ALL_CURRENT_GUESTS:				//Display All Current Guests
			{//case 2 code here
			control.displayAllGuests(rooms);
			break;
			}
			case PROCESS_A_NEW_RESERVATION:													//this case brings user to the Reservations Sub-Menu
			{
				int scenario;
				reservationMenu();												//loads the reservations menu
				scenario = control.chooseFromReservationMenu();					//gets user to choose option from the reservation sub-menu

				switch(scenario){	
				case 1:															//NEW_RESERVATION
				{
					guest = control.addGuest();									//guest info is gathered from control.addGuest
					allAvailableRooms(0);
					room = control.chooseRoom(rooms);							//get user to choose a room 

					try {
						room.addGuest(guest);									//add a guest to the room
					}//END OF TRY
					catch (DiarmuidsException e) {
						e.printStackTrace();
					}//END OF CATCH
					
					control.addExtraGuests(room);								//ask user if more guests are to be checked in to this room.
					successfullCheckIn(rooms, room);							//calls successful check in screen						
					break;
				}											//END OF CASE 1: NEW_RESERVATION
				
				case 2:										//VIEW_RESERVATION
				{
					control.viewReservationList(rooms);
					break;
				}											
				
				case 3:										//CANCEL_RESERVATION
				{
					control.cancelReservation(rooms);
					break;
				}
				
				case 4:										//RETURN_TO_MAIN_MENU
				{
					displayMenu();
					userChoice = keyboard.nextInt();
					break;
				}											//END OF CASE 4: RETURN_TO_MAIN_MENU
				
				}
				break;
			}//END OF REESERVATION
			
			case DISPLAY_PAYMENTS:{
				processingPayments();
				userChoice = keyboard.nextInt();
				
				switch(userChoice) {
				case 1:
				control.payments(rooms, guest);
				break;
				case 2:
				control.payments(rooms, guest);
				break;
				}
				break;
			}
			}//Switch
			displayMenu();
			userChoice = keyboard.nextInt();
		}//while
	}//start program
	public void displayMenu() {					//This is the displayMenu the user chooses from
		System.out.println("");
		System.out.println("    CORK INSTITIUTE OF TECHNOLOGY HOTEL    ");
		System.out.println("*******************************************");
		System.out.println("1. Display All Available Rooms");
		System.out.println("2. Display All Current Guests");
		System.out.println("3. Process A New Reservation");
		System.out.println("4. Display Payments");
		System.out.println("5. Exit System");
		System.out.println("*******************************************");
	}

	public void reservationMenu() {					//This is the reservationMenu the user chooses from
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

	public void allAvailableRooms(int i) {
		System.out.println("");
		System.out.println("        CIT HOTEL AVAILABLE ROOMS          ");
		System.out.println("*******************************************");
		
		if(i<1) {
		System.out.println("Suite  : "+rooms.getFreeRooms("suite")+
				"\tDouble : "+rooms.getFreeRooms("double")+
				"\tSingle : "+rooms.getFreeRooms("single")+"\n\n");
		}
		
		if(i>0) {

		System.out.println("\t\t== Suites ==");
		for(Room r: rooms.getList()) {
			if(r.isEmpty(r)) {
				if(r.getClass().getSimpleName().toUpperCase().contains("SUITE")) {
				System.out.println("\t\t  Room : "+r.getRoomNumber());
				}
			}
		}
		System.out.println("");
		System.out.println("\t\t== Doubles ==");
		for(Room r: rooms.getList()) {
			if(r.isEmpty(r)) {
				if(r.getClass().getSimpleName().toUpperCase().contains("DOUBLE")) {
				System.out.println("\t\t  Room : "+r.getRoomNumber());
				}
			}
		}
		System.out.println("");
		System.out.println("\t\t== Singles ==");
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
	
	public void successfullCheckIn(RoomList rooms, Room room) {
	System.out.println("\n        SUCCESSFUL RESERVATION             ");
	System.out.println("*******************************************\n");
	System.out.println(+rooms.getNumberOfGuestsInRoom(room)
						+" GUESTS HAVE CHECKED INTO ROOM NUMBER "		//Prints details of the check in to the scree,
						+room.getRoomNumber()
						+".\n\tTHIS ROOM IS A "+room.getRoomType(room).toUpperCase());
	System.out.println("\n*******************************************\n");
	}

	public void processingPayments() {
	System.out.println("\n        PROCESS PAYMENTS             ");
	System.out.println("*******************************************\n");
	System.out.println("1. Check an outstanding balance on a room.");
	System.out.println("2. Pay the outstanding balance for a room.");

	System.out.println("\n*******************************************\n");
	}
}//END END


