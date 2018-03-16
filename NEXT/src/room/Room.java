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
	
	public void reservationList(Room r) {
		for(Guest g: r.getGuest()) {
			System.out.println("Name: "+g.getName()+" ("+g.guestType(g)+")\t"+r.getClass().getSimpleName()+"\tRoom: "+r.getRoomNumber());	
		}
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
	
	
	public void addGuest(Guest guest) throws DiarmuidsException {
		if(getGuest().size()<getMaxGuests()) {
			this.guests.add(guest);
		}
		else
			throw new DiarmuidsException("Can't add guest as the room is full, Room number is "+this.getRoomNumber());
	}
	
	public void Price(Guest guest, Room room, int RoomNum) {
		//Price is per Room, so price per guest is (price per Room / no of guests in room)
		double fullPrice = totalPrice;
		pricePerGuest = fullPrice/room.getGuest().size();
		System.out.println("          BILL FOR "+room.getClass().getSimpleName().toUpperCase()+": ROOM "+RoomNum);
		System.out.println("**********************************************");
		for(Guest g: room.getGuest())
			if(g instanceof Lecturer) {
				fullPrice = fullPrice - pricePerGuest*(LECTURER_DISCOUNT);
				System.out.println(g.getClass().getSimpleName()+": \t"+g.getName()
									+"\tAmount Due: €"+pricePerGuest*(1-LECTURER_DISCOUNT)+"0");
			}
			else {
				System.out.println(g.getClass().getSimpleName()+": \t"+g.getName()+"\tAmount Due: €"+pricePerGuest+"0");
			}
		
		System.out.println("\n\t\tROOM PRICE :\t€"+totalPrice+"0");
		System.out.println("\t\tDISCOUNTED :\t€"+fullPrice+"0");
		System.out.println("**********************************************");
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
	public Room findRoomByName(Room r, String name) {
		Room match = null;
		for(Guest g: r.getGuest()) {
			if(g.getName().toUpperCase().equals(name.toUpperCase())) {
				match = r;
			}	
		}
		return match;
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
