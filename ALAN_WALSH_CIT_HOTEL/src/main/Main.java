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
		Room room = null;
		Guest guest = null;
		//try {
			rooms = (RoomList)FileStorage.readObject("rooms.ser");		//read RoomList stored on file if one exists
			room = (Room)FileStorage.readObject("room.ser");			//read Room stored on file if one exists
			guest = (Guest)FileStorage.readObject("guest.ser");			//read Guest stored on file if one exists
		//}catch(Exception e) {
			rooms = loadDefaultRooms();									//if no files exist, load a set of empty defaultRooms
		//}
		
		int freeSuites = rooms.getFreeRooms("suite");					//how many free suites stored to int.
		int freeDoubles = rooms.getFreeRooms("double");					//how many free doubles stored to int.
		int freeSingles = rooms.getFreeRooms("single");					//how many free singles stored to int.
		
																		//Display amount of available Suites/Doubles/Singles				
		System.out.println("\n\nSuites: "+freeSuites+"\tDoubles: "+freeDoubles+"\tSingles: "+freeSingles);
		
		Menu start = new Menu(rooms);									//Creates the menu 'start' which uses the RoomList rooms
		start.beginProgram();											//calls the beignProgram method from the Menu
	}
	
	public static RoomList loadDefaultRooms() {							//Generates a set of Rooms for the hotel.
		RoomList rooms = new RoomList();								//RoomList rooms is created
		
		Room su1 = new Suite();											//3 new Suites are created
		Room su2 = new Suite();
		Room su3 = new Suite();
		
		Guest g1 = new Student("DeGea");
		Guest g2 = new Student("Antonio");
		Guest g3 = new Lecturer("Bailly");
		Guest g4 = new Student("Rojo");
		Guest g5 = new Lecturer("Shaw");
		Guest g6 = new Student("Matic");
		Guest g7 = new Lecturer("Pogba");
		Guest g8 = new Student("Martial");
		Guest g9 = new Lecturer("Alexis");
		Guest g10 = new Student("Mata");
		Guest g11 = new Student("Lukaku");
		
		Room d1 = new Double();											//6 new Doubles are created
		Room d2 = new Double();
		Room d3 = new Double();
		Room d4 = new Double();
		Room d5 = new Double();
		Room d6 = new Double();
		
		Room s1 = new Single();											//6 new Singles are created
		Room s2 = new Single();
		Room s3 = new Single();
		Room s4 = new Single();
		Room s5 = new Single();
		Room s6 = new Single();
		try {
			su1.addGuest(g1);
			su1.addGuest(g2);
			su1.addGuest(g3);
			d1.addGuest(g8);
			d1.addGuest(g7);
			d2.addGuest(g6);
			s1.addGuest(g5);
			s2.addGuest(g4);
			su2.addGuest(g11);
			su3.addGuest(g10);
			d3.addGuest(g9);
		} catch (MyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		rooms.addRoom(su1);												//all create rooms are added to the RoomList Rooms.		
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
		
		FileStorage.storeObject(rooms, "rooms.ser");										//save rooms object to a file.
		return rooms;																		//return the RoomList rooms
	}
}
