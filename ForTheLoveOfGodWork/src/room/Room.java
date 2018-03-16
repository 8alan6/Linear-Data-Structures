package room;

import java.io.Serializable;
import java.util.ArrayList;

import exception.MyException;								//declare variables
import guest.Guest;
import guest.Lecturer;
import guest.Student;

public abstract class Room  implements Serializable{
	private static int ROOM_NUM = 1;
	private int roomNumber;
	private String roomType;
	private double pricePerGuest;
	private double totalPrice;
	private final double LECTURER_DISCOUNT = .10;
	private ArrayList<Guest> guests;
	
	public Room(double totalPrice) {
		roomNumber = ROOM_NUM;
		ROOM_NUM++;
		pricePerGuest = 0;
		guests = new ArrayList<Guest>();
		this.totalPrice = totalPrice;
	}
	
	
	public Room(String roomType) {
		this.roomType = roomType;
	}
	
	public boolean roomIsFull(Room room) {								//isRoomfull?
		if(room.getGuest().size() == room.getMaxGuests()) {
			return true;
		}
		return false;
	}
	 
	public boolean isNotFull(Room room) {								//Room is not full but may not be empty either
		if(!roomIsFull(room)) {
			return true;
		}
		return false;
	}
	
	public int getRoomNumber() {return this.roomNumber;}				//gets room number
	
	public boolean isEmpty(Room r) {									//room is empty
		if(r.getGuest().size() == 0) {
			return true;
		}else
			return false;
	}
	
	
	
	public ArrayList<Guest> getGuest() {								//guests list
		return this.guests;
	}
	
	public void reservationList(Room r) {								//reservationList
		for(Guest g: r.getGuest()) {									//gets guests details in a room
			System.out.println("Name: "+g.getName()+" ("+g.guestType(g)+")\t"+r.getClass().getSimpleName()
																			+"\tRoom: "+r.getRoomNumber());	
		}
	}
	
	public void getNamesOfLecturers(Room r) {							//gets just lecturers names 
		Lecturer l = new Lecturer("");
			for(Guest g: r.getGuest()) {								//scan all guests in a room
				if(g.getClass() == l.getClass() ) {						//if guest is of type lecture
					System.out.println("Room No: "+r.getRoomNumber()+"\t"+g.guestType(g)+" Name: "+g.getName());
			}															//print the lecturers details		
		}
	}
	
	public void getNamesOfStudents(Room r) {							//gets just the students names
		Student s = new Student("");												
			for(Guest g: r.getGuest()) {								//scan all guests in a room
				if(g.getClass() == s.getClass() ) {						//if guest is of type student
				System.out.println("Room No: "+r.getRoomNumber()+"\t"+g.guestType(g)+" Name: "+g.getName());	
			}															//print the stuents details
		}
	}
	
	public abstract int getMaxGuests();									//max Guests
	
	
	public void addGuest(Guest guest) throws MyException {				//adds Guest to Guest list
		if(getGuest().size()<getMaxGuests()) {
			this.guests.add(guest);
		}
		else
			throw new MyException("Can't add any more guests");
	}
	
	public double Price(Guest guest, Room room, int RoomNum) {			//gets price due for room 
		//Price is per Room, so price per guest is (price per Room / no of guests in room)
		double amountDue = totalPrice;
		pricePerGuest = amountDue/room.getGuest().size();				//price per guest is room total divided by amount of guests
		
		System.out.println("          BILL FOR "+room.getClass().getSimpleName().toUpperCase()+": ROOM "+RoomNum);
		System.out.println("**********************************************");
		for(Guest g: room.getGuest())									//scan all guests in a room
			if(g instanceof Lecturer) {									//if guest is of type lecturer
				amountDue = amountDue - pricePerGuest*(LECTURER_DISCOUNT);			//apply discount
				System.out.println(g.getClass().getSimpleName()+": \t"+g.getName()	//print lecturers price
									+"\tAmount Due: €"+pricePerGuest*(1-LECTURER_DISCOUNT)+"0");
			}
			else {														//if guest is student
				System.out.println(g.getClass().getSimpleName()+": \t"+g.getName()+"\tAmount Due: €"+pricePerGuest+"0");
			}															//print student price
		
		System.out.println("\n\t\tROOM PRICE :\t€"+totalPrice+"0");					//room price
		System.out.println("\t\tDISCOUNT   :\t€"+(totalPrice - amountDue)+"0");		//discount if lecturer booked in
		System.out.println("**********************************************");
		System.out.println("\t\tAMOUNT DUE :\t€"+amountDue+"0");					//actual amount due for room
		return amountDue;
	}
	
	
	
	
	public void removeAllGuestsFromRoom(Room r) {						//Removes All Guests from Room 'r' by recursion
		int numOfGuestsInRoom = r.getGuest().size();					//Declare int numOfGuests in room = number of guests in Room 'r'.
		
		if(r.getGuest().size()>0) {										//if there is guests in the room
			r.getGuest().remove(numOfGuestsInRoom-1);					//remove the last guest in the room
			removeAllGuestsFromRoom(r);									//solve the problem again, now with one less guest in the room.
		}
		else {															//else if all guests are removed print the Reservation cancelled...
																		//...message to the screen
			System.out.println("**********************************************\n");
			System.out.println("** "+r.getClass().getSimpleName().toUpperCase()							//Prints RoomType, "text", RoomNumber...
					+" : ROOM NUMBER "+r.getRoomNumber()+" NOW HAS "+numOfGuestsInRoom+" GUESTS **");	//..."text", NumberOfGuests, "text".
			System.out.println("\n**********************************************");
		}
		
	}
	public Room findRoomByName(Room r, String name) {					//finds Room by guest name
		Room match = null;
		for(Guest g: r.getGuest()) {									
			if(g.getName().toUpperCase().equals(name.toUpperCase())) { //if name matches a name staying in a rooom
				match = r;												//match is the room the guest is staying in
			}	
		}
		return match;
	}
	
	
	
	
	
	public String getRoomType(Room room) {						//gets the type of room
		Suite su = new Suite();
		Double d = new Double(); 
		Single s = new Single();
		String typeOfRoom = null;
		if(room.getClass() == su.getClass()) {					//if room is of type suite
			typeOfRoom = "suite";								//then return suite
			return typeOfRoom;
		}
		else if(room.getClass() == d.getClass()) {				//if room is of type double 
			typeOfRoom = "double room";							//then return double
			return typeOfRoom;
		}
		else if(room.getClass() == s.getClass()) {				//if room is of type single then return singe
			typeOfRoom = "single room";
			return typeOfRoom;
		}
		return typeOfRoom;
	}
}
