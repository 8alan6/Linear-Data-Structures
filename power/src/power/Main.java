package main;

import exception.DiarmuidsException;
import guest.Guest;
import guest.Lecturer;
import guest.Student;
import persistence.FileStorage;
import room.Double;
import room.RoomList;
import room.Single;
import room.Suite;

public class Main {
	public static void main(String[] args) {
		RoomList rooms = null;
		try {
			rooms = (RoomList)FileStorage.readObject("rooms.ser");
		}catch(Exception e) {
			rooms = loadDefaultRooms();
		}
		
		int freeSuites = rooms.getFreeRooms("suite");
		int freeDoubles = rooms.getFreeRooms("double");
		int freeSingles = rooms.getFreeRooms("single");
		
		System.out.println("Suites: "+freeSuites+"\nDoubles: "+freeDoubles+"\nSingles: "+freeSingles);
		
	}
	
	private static RoomList loadDefaultRooms() {
		RoomList rooms = new RoomList();
		Suite su1 = new Suite();
		try {
			Guest g1 = new Student();
			Guest g2 = new Lecturer();
			Guest g3 = new Lecturer();
			Guest g4 = new Lecturer();
			su1.addGuest(g1);
			su1.addGuest(g2);
			su1.addGuest(g3);
			su1.addGuest(g4);
		}
		catch(DiarmuidsException e) {
			e.printStackTrace();
		}
		rooms.addRoom(su1);
		
		rooms.addRoom(new Suite());
		rooms.addRoom(new Suite());
		rooms.addRoom(new Double());
		rooms.addRoom(new Double());
		rooms.addRoom(new Double());
		rooms.addRoom(new Double());
		rooms.addRoom(new Double());
		rooms.addRoom(new Double());
		Single s1 = new Single();
		try {
			s1.addGuest(new Student());
		}catch(DiarmuidsException e) {
			e.printStackTrace();
		}
		rooms.addRoom(s1);
		rooms.addRoom(new Single());
		rooms.addRoom(new Single());
		rooms.addRoom(new Single());
		rooms.addRoom(new Single());
		rooms.addRoom(new Single());
		FileStorage.storeObject(rooms, "rooms.ser");
		return rooms;
	}
}
