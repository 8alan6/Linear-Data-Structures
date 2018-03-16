package room;

import java.io.Serializable;
import java.util.ArrayList;

import exception.DiarmuidsException;
import guest.Guest;
import guest.Lecturer;
import guest.Student;

public abstract class Room  implements Serializable{
	private static int ROOM_NUM = 1;
	private int roomNumber;
	private String roomType;
	private double price;
	private double totalPrice;
	private final double LECTURE_DISCOUNT = .10;
	private ArrayList<Guest> guests;
	
	public Room(double price) {
		roomNumber = ROOM_NUM;
		ROOM_NUM++;
		this.price = price;
		guests = new ArrayList<Guest>();
		totalPrice = 0;
	}
	
	
	public Room(String roomType) {
		this.roomType = roomType;
	}
	
	public boolean roomIsFull(Room room) {
		if(room.getGuest().size() == room.getMaxGuests()) {
			return true;
		}
		return false;
	}
	 
	public boolean isNotFull(Room room) {
		if(!roomIsFull(room)) {
			return true;
		}
		return false;
	}
	
	public int getRoomNumber() {return this.roomNumber;}
	
	public boolean isEmpty(Room r) {
		if(r.getGuest().size() == 0) {
			return true;
		}else
			return false;
	}
	
	
	
	public ArrayList<Guest> getGuest() {
		return this.guests;
	}
	
	public void getGuestNames(Room r,String name) {
		System.out.println("");										//...message to the screen
		System.out.println("\t   "+name.toUpperCase()+"'S RESERVATION");
		System.out.println("**********************************************\n");
		System.out.println("===== \t"+r.getClass().getSimpleName().toUpperCase()+" :  ROOM NUMBER "+r.getRoomNumber()+"  =====");
		for(Guest g: r.getGuest()) {
			System.out.println("\t"+g.guestType(g)+" Name:\t"+g.getName());	
		}
		System.out.println("\n**********************************************");
	}
	
	public String onReservationList(Room r) {			
			for(Guest g: r.getGuest()) {
					return r.getRoomType(r).toUpperCase()+": \t"+g.guestType(g)+" Name: "+g.getName();
			}
			return "";
	}
	
	
	
	
	
	public void getNamesOfLecturers(Room r) {			
		Lecturer l = new Lecturer("");
			for(Guest g: r.getGuest()) {
				if(g.getClass() == l.getClass() ) {
					System.out.println("Room No: "+r.getRoomNumber()+"\t"+g.guestType(g)+" Name: "+g.getName());
			}
		}
	}
	
	public void getNamesOfStudents(Room r) {			
		Student s = new Student("");
			for(Guest g: r.getGuest()) {
				if(g.getClass() == s.getClass() ) {
				System.out.println("Room No: "+r.getRoomNumber()+"\t"+g.guestType(g)+" Name: "+g.getName());	
			}	
		}
	}
	
	public abstract int getMaxGuests();
	
	public void Price() {
		System.out.println(totalPrice);
	}
	
	
	public void addGuest(Guest guest) throws DiarmuidsException {
		if(getGuest().size()<getMaxGuests()) {
			this.guests.add(guest);
			if(guest instanceof Lecturer) {
				totalPrice += price - (price*LECTURE_DISCOUNT);
			}
			else {
				totalPrice += price;
			}
		}
		else
			throw new DiarmuidsException("Can't add guest as the room is full, Room number is "+this.getRoomNumber());
	}
	
	public void removeAllGuestsFromRoom(Room r) {						//Removes All Guests from Room 'r' by recursion
		int numOfGuestsInRoom = r.getGuest().size();					//Declare int numOfGuests in room = number of guests in Room 'r'.
		
		if(r.getGuest().size()>0) {										//if there is guests in the room
			r.getGuest().remove(numOfGuestsInRoom-1);					//remove the last guest in the room
			removeAllGuestsFromRoom(r);									//solve the problem again, now with one less guest in the room.
		}
		else {															//else if all guests are removed print the Reservation cancelled...
			System.out.println("");										//...message to the screen
			System.out.println("           RESERVATION CANCELLED           ");
			System.out.println("**********************************************\n");
			System.out.println("** "+r.getClass().getSimpleName().toUpperCase()							//Prints RoomType, "text", RoomNumber...
					+" : ROOM NUMBER "+r.getRoomNumber()+" NOW HAS "+numOfGuestsInRoom+" GUESTS **");	//..."text", NumberOfGuests, "text".
			System.out.println("\n**********************************************");
		}
		
	}
	public void findRoomByName(Room r, String name) {
		for(Guest g: r.getGuest()) {
			if(g.getName().toUpperCase().equals(name.toUpperCase())) {
				getGuestNames(r, name);
			}	
		}
	}
	public void findRoomTypeByName(Room r, String name) {
		for(Guest g: r.getGuest()) {
			if(g.getName().toUpperCase().equals(name.toUpperCase())) {
				getRoomType(r);
			}	
		}
	}
	
	
	
	public String getRoomType(Room room) {
		Suite su = new Suite();
		Double d = new Double(); 
		Single s = new Single();
		String typeOfRoom = null;
		if(room.getClass() == su.getClass()) {
			typeOfRoom = "suite";
			return typeOfRoom;
		}
		else if(room.getClass() == d.getClass()) {
			typeOfRoom = "double room";
			return typeOfRoom;
		}
		else if(room.getClass() == s.getClass()) {
			typeOfRoom = "single room";
			return typeOfRoom;
		}
		return typeOfRoom;
	}
}
