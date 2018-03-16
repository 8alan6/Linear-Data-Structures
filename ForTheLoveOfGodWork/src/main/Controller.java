package main;
import guest.Guest;
import guest.Lecturer;
import guest.Student;
import persistence.FileStorage;
import room.Room;
import room.Double;
import room.Single;
import room.Suite;
import room.RoomList;
import java.util.Scanner;

import exception.MyException;

public class Controller {
	private double dayEarnings = 0;
	private Guest guest;
	private Room room;
	Scanner keyboard = new Scanner(System.in);
	private int userChoice;
	

	public int chooseFromReservationMenu() {							//this method is called to allow the user to choose an
		final int NEW_RESERVATION =1;									//option from the reservations sub menu
		final int VIEW_RESERVATION =2;
		final int CANCEL_RESERVATION =3;

		userChoice = keyboard.nextInt();

		int scenario = 0; 
		if (userChoice == NEW_RESERVATION)
			scenario = 1;
		else if(userChoice == VIEW_RESERVATION)
			scenario = 2;
		else if(userChoice == CANCEL_RESERVATION)
			scenario = 3;
		else
			scenario = 4;

		return scenario;													//int scenario returned is entered into a 'switch'
	}


	public Guest addGuest() {												//addGuest gets guest info such as name and guest type.
		String name;
		keyboard.nextLine();
		System.out.println("What is the name of the new guest?");
		name = keyboard.nextLine();
		name = name.substring(0, 1).toUpperCase() + name.substring(1);		//makes first letter of name capital

		System.out.println("Is "+name+" ......\n\t1. A Lecturer\n\t   Or\n\t2. A Student");
		userChoice = keyboard.nextInt();									//choose if guest is Lecturer/Student

		switch(userChoice) {
		case 1:	//is Lecturer
			guest = new Lecturer(name);										//if Lecturer, create new guest of type lecturer
			break;

		case 2:	// is Student
			guest = new Student(name);										//if Student, create new guest of type student
			break;
		}		
		return guest;														//returns a guest
	}

	public void addExtraGuests(Room room) {									//are extra guests checking in to the room?
		keyboard.nextLine();												//decide here(This option is only called if room... 
		if(room.isNotFull(room)) {//if Room has a guest												...is Suite or Double)
			System.out.println("Do you wish to add extra guests to this "+room.getRoomType(room)+" (YES/NO) ?");
			String choice; 
			choice = keyboard.nextLine();
			Guest g = null;
																			//if choice is Yes or Y then add extra guest
			if(choice.toUpperCase().contentEquals("YES") || choice.toUpperCase().contentEquals("Y")){

				if(room.getRoomType(room)=="suite") {						//IF ROOM IS SUITE
					System.out.println("Would you like to add ......\n\t1. One more guest\n\t      Or\n\t2. Two more guests");
					userChoice = keyboard.nextInt();						//Ask if 1 or 2 more guests
					
					switch(userChoice) {							//if userChoice is 1
					case 1:{										//Add one extra guest to suite
						g = addGuest();								//call the addGuest method above to get guest info
						try {
							room.addGuest(g);						//Add new guest to the suite
						} catch (MyException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						break;
					}
					case 2:{										//Add two extra guests to suite
						for(int i=0; i<2; i++) {
							g = addGuest();							//call the addGuest method above 2 times to get guests info	
							try {
								room.addGuest(g);					//add guests to the suite
							} catch (MyException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						break;
					}//case2
				}//switch
				}// end of if room is Suite
				
				else if(room.getRoomType(room)=="double room"){		//if room is Double
					g = addGuest();									//call addGuest method to get guest info																				
					try {
						room.addGuest(g);							//add gust too room
					} catch (MyException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}// end of if room is double
			}// end of if Yes
		}//if(ROOMISNOTFULL)
	}																//END OF EXTRAGUESTSMETHOD


	public Room chooseRoom(RoomList roomList) {						//gets guest to choose a room they would like
		
		System.out.println("Which type of room do you wish to stay in?\n\t1. A Suite\n\t2. A Double\n\t3. A Single");
		userChoice = keyboard.nextInt();

		switch(userChoice) {									
		case 1:														//if userChoice is Suite
			room = roomList.getAvailableSuite();					//gets first available suite from the roomlist
			return room;
		case 2:														//if userChoice is Double
			room = roomList.getAvailableDoubles();					//gets first available double from the roomlist
			return room;
		case 3:														//if userChoice is Single
			room = roomList.getAvailableSingles();					//gets first available single from the roomlist
			return room;
		}
		return null;
	}

	public void viewReservationList(RoomList roomList) {			//views all guests on the reservation list
		System.out.println("");										
		System.out.println("\t\tRESERVATION LIST				  ");
		System.out.println("**********************************************\n");
		for(Room r: roomList.getList()){							//search for all the rooms in the room list
			if(!r.isEmpty(r)) {										//if a room is not empty(it has at least one guest)
				r.reservationList(r);								//gets all the guests in non empty rooms
			}
		}
		System.out.println("\n**********************************************\n");
	}

	public void displayAllGuests(RoomList roomList) {				//Displays all guests by guest type (lecturer/student)
		System.out.println("Display All Current Guests By.....\n\t1. Lecturer\n\t   Or\n\t2. Student");
		int type = keyboard.nextInt();
		if(type == 1) {												//if Lecturer print the start of the this screen
			System.out.println("\n   ALL LECTURERS CHECKED IN TO THE HOTEL\n*******************************************");
		}
		else if(type == 2) {										//if student print the start of this screen
			System.out.println("\n   ALL STUDENTS CHECKED IN TO THE HOTEL\n*******************************************");
		}

		for(Room r: roomList.getList()){							//scan through all the rooms in the roomList
			if(!r.isEmpty(r)) {										//if room has guest
				if(type == 1) {										//if user picked guest type lecturer
					r.getNamesOfLecturers(r);						//get all the lecturer names
				}
				else if(type == 2)									//if user picked guest type student
					r.getNamesOfStudents(r);						//get all the student names
			}
			//in here room is empty. not needed
		}
	}//END OF THE METHOD



	public void cancelReservation(RoomList roomList){				//cancels a reservation for a room by a guest name.
		System.out.println("Which guest is cancelling their reservation?");	
		keyboard.nextLine();
		String name = keyboard.nextLine();							//user enters a guest name
		Room matched = null;

		for(Room r: roomList.getList()){							//scan all the rooms in the roomlist
			if(!r.isEmpty(r)) {										//if a room has a guest
				matched = r.findRoomByName(r, name);				//call the findRoom by name method and return a room if a match
				if(matched!=null) {									//if matched is not its original state (null)
					System.out.println("\n           RESERVATION CANCELLED           ");
					matched.removeAllGuestsFromRoom(matched);		//remove all the guests from the matched room
				}
			}//if
		}//for
	}		
	
	//int allows different access within this method
	public void payments(RoomList rooms, Guest guest, int type) {	//looks for room bill by room number						
		System.out.println("Please enter the room number of the Guest wishing to pay their bill?\nROOM NO:");
		int roomNum = keyboard.nextInt();							//user enters room number
		
		room = rooms.getRoomByRoomNumber(roomNum, rooms);			//call the getRoomByRoomNumber method and return the room
		double roomPrice = room.Price(guest, room, roomNum);		//rooms bill is called using the room.Price method
		
		if(type == 2) {												//if int 'type' is set to 2 when the method is called it brings
			makePayment(roomPrice, room, 0);						//the user to pay the bill now with the make payment method
		}
																	//if int is not 2 the this method is over and the user only sees
																	//the bill for the room and is returned to the main menu	
	}

	public void makePayment(double roomPrice, Room room, int counter) {					//pay a rooms bill
		if(counter < 3) {											//A payment can be attempted 3 times. User enters the amount
		System.out.println("\nPlease enter outstanding balance being payed by customer."); //received from guests for Room
		System.out.println("DUE: €"+roomPrice+"0");
		double moneyPayed = keyboard.nextDouble();											//amount is entered to the screen
 
			if((roomPrice - moneyPayed) <= 0) {											//if guests have give the value of the bill
				System.out.println("\n             GUESTS CHECKED-OUT           ");		
				room.removeAllGuestsFromRoom(room);										//guests of that room are checked out
				System.out.println("*******  THANK YOU FOR YOUR PAYMENT  *********");				
				dayEarnings += moneyPayed; 												//money received is added to the earnings
				if(moneyPayed - roomPrice > 0) {										//if they payed more than required
					System.out.println("\tCHANGE DUE TO CUSTOMER : €"+(moneyPayed-roomPrice)+"0"); //amount of change due is displayed
					dayEarnings = dayEarnings - (moneyPayed - roomPrice);				//change given back is removed from earnings
				}
				System.out.println("**********************************************\n");
			}
			else {																		//guests have not handed over enough money	
				if(counter < 2 )
				System.out.println("\n*******  YOU HAVE NOT PAYED ENOUGH  **********");
				System.out.println("**********************************************\n");
				counter++;																//when counter reaches 3 Payment is not
				roomPrice = roomPrice - moneyPayed;										//accepted and you are put back to mainMenu
				makePayment(roomPrice, room , counter);
			}
		}
		else {
			System.out.println("*******  UNSUCCESSFULL PAYMENT  **********");			//if the guests did not pay correctly 3
			System.out.println("*******     NO MONEY TAKEN      **********");			//times then they are not checked-out
			System.out.println("******************************************\n");			//and their bill is still due
			System.out.println("****  PLEASE TRY TO CHECK-OUT AGAIN  *****");
		}
	}
	
	public double totalEarnings() {														//returns the days earnings
		return dayEarnings;
	}
}			


