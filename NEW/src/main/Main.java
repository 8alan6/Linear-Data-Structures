package main;

import exception.MyException;
import guest.Guest;
import guest.Lecturer;
import guest.Student;
import persistence.FileStorage;
import room.Double;
import room.RoomList;
import room.Single;
import room.Suite;
import room.Room;

public class Main {
	public static void main(String[] args) {
		RoomList rooms = null;
		try {
			rooms = (RoomList)FileStorage.readObject("rooms.ser");
		}catch(Exception e) {
			rooms = loadDefaultRooms();
		}
		/*
		int freeSuites = rooms.getFreeRooms("suite");
		int freeDoubles = rooms.getFreeRooms("double");
		int freeSingles = rooms.getFreeRooms("single");
		
		System.out.println("\nSuites: "+freeSuites+"\tDoubles: "+freeDoubles+"\tSingles: "+freeSingles);
		*/

		Menu start = new Menu(rooms);
		start.beginProgram();
		
	}

	public static RoomList loadDefaultRooms() {
		RoomList rooms = new RoomList();
		Room su1 = new Suite();
		Room su2 = new Suite();
		Room su3 = new Suite();
		
		Room d1 = new Double();
		Room d2 = new Double();
		Room d3 = new Double();
		Room d4 = new Double();
		Room d5 = new Double();
		Room d6 = new Double();
		
		Room s1 = new Single();
		Room s2 = new Single();
		Room s3 = new Single();
		Room s4 = new Single();
		Room s5 = new Single();
		Room s6 = new Single();
		
		rooms.addRoom(su1);
		rooms.addRoom(su2);
		rooms.addRoom(su3);
		
		rooms.addRoom(d1);
		rooms.addRoom(d2);
		rooms.addRoom(d3);
		rooms.addRoom(d4);
		rooms.addRoom(d5);
		rooms.addRoom(d6);
		
		rooms.addRoom(s1);
		rooms.addRoom(s2);
		rooms.addRoom(s3);
		rooms.addRoom(s4);
		rooms.addRoom(s5);
		rooms.addRoom(s6);
		
		FileStorage.storeObject(rooms, "rooms.ser");
		return rooms;
	}
}
