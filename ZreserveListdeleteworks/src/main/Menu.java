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
	
	private static final int DISPLAY_ALL_AVAILABLE_ROOMS =1;
	private static final int DISPLAY_GUESTS =2;
	private static final int PROCESS_A_NEW_RESERVATION =3;
	private static final int PROCESS_PAYMENTS = 4;
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
			case DISPLAY_GUESTS:				//Display All Current Guests
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
					successfullReservation(rooms, room, guest);							//calls successful check in screen						
					break;
				}											//END OF CASE 1: NEW_RESERVATION
				
				case 2:										//VIEW_RESERVATION
				{
					allAvailableRooms(0);
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
				}//	END_OF_SWITCH(SCENARIO)
				break;
			}//END OF REESERVATION
			
			case PROCESS_PAYMENTS:{
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
		System.out.println("1. Display All Available Rooms");
		System.out.println("2. Display Guests");
		System.out.println("3. Process A New Reservation");
		System.out.println("4. Process Payments");
		System.out.println("5. Exit System");
		System.out.println("*******************************************");
	}

	public void reservationMenu() {					//This is the reservationMenu the user chooses from
		System.out.println("");
		System.out.println("        CIT HOTEL RESERVATION MENU         ");
		System.out.println("*******************************************");
		System.out.println("1. New Reservation");
		System.out.println("2. View All Reservations");
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
		
		if(i<1) {						//the value of i is set in different parts of the program. i=0 and i=1 will load different
										//variations of this Available rooms list.
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
	
	public void successfullReservation(RoomList rooms, Room room, Guest guest) {
	System.out.println("\n         SUCCESSFUL RESERVATION            ");
	System.out.println("*******************************************\n");
	System.out.println("\t"+guest.getClass().getSimpleName().toUpperCase()+":\t"+guest.getName()
						+"\n\tROOM TYPE:\t"+room.getRoomType(room));
	System.out.println("\n*******************************************");
	}

	
	
}//END END


