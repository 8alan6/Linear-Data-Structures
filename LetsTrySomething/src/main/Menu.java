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
	private Main main = new Main();	
	private RoomList rooms;
	private Room room;
	private Controller control;

	private static final int RESERVATIONS =1;
	private static final int DISPLAY_ALL_CURRENT_GUESTS =2;
	private static final int DISPLAY_ALL_AVAILABLE_ROOMS =3;
	private static final int PROCESS_A_NEW_RESERVATION = 4;
	private static final int DISPLAY_PAYMENTS = 5;
	private static final int EXIT_THE_SYSTEM = 6;

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
			case RESERVATIONS:													//this case brings user to the Reservations Sub-Menu
			{
				int scenario;
				reservationMenu();												//loads the reservations men
				scenario = control.chooseFromReservationMenu();					//gets user to choose option from the reservation sub-menu

				switch(scenario){	
				case 1:															//NEW_RESERVATION
				{	
					guest = control.addGuest();									//guest info is gathered from control.addGuest
					allAvailableRooms(0);
					room = control.chooseRoom(rooms);							//get user to choose a room
					control.addToReservationList(guest);
					
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
					control.displayReservation(rooms, guest, room);
					break;
				}											
				
				case 3:										//CANCEL_RESERVATION
				{
					allAvailableRooms(0);
					control.cancellation(rooms);
					break;
				}
				
				case 4:										//RETURN_TO_MAIN_MENU
				{
					displayMenu();
					userChoice = keyboard.nextInt();
					break;
				}											//END OF CASE 4: RETURN_TO_MAIN_MENU
				}//	END_OF_SWITCH(SCENARIO)
				break;
			}//END OF REESERVATION
			case DISPLAY_ALL_CURRENT_GUESTS:				//Display All Current Guests
			{//case 2 code here
			control.displayAllGuests(rooms);
			}
			break;
			case DISPLAY_ALL_AVAILABLE_ROOMS:{
				allAvailableRooms(1);
				break;
			}//end of DISPLAY ALL AVAILABLE ROOMS
			case DISPLAY_PAYMENTS:{
				room.Price();
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
		System.out.println("1. Reservations");
		System.out.println("2. Display All Current Guests");
		System.out.println("3. Display All Available Rooms");
		System.out.println("4. Process A New Reservation");
		System.out.println("5. Display Payments");
		System.out.println("6. Exit System");
		System.out.println("*******************************************");
	}

	public void reservationMenu() {					//This is the reservationMenu the user chooses from
		System.out.println("");
		System.out.println("        CIT HOTEL RESERVATION MENU         ");
		System.out.println("*******************************************");
		System.out.println("1. New Reservation");
		System.out.println("2. View Reservation");
		System.out.println("3. Cancel Reservation");
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
	System.out.println("\n          SUCCESSFUL CHECK-IN              ");
	System.out.println("*******************************************\n");
	System.out.println(+rooms.getNumberOfGuestsInRoom(room)
						+" GUESTS HAVE CHECKED INTO ROOM NUMBER "		//Prints details of the check-in to the screen,
						+room.getRoomNumber()
						+".\n\tTHIS ROOM IS A "+room.getRoomType(room).toUpperCase());
	System.out.println("\n*******************************************");
	}

	
	
}//END END


