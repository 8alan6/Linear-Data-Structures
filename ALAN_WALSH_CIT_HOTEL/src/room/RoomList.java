package room;
import guest.Guest;
import guest.Lecturer;
import guest.Student;
import java.io.Serializable;
import java.util.ArrayList;

public class RoomList  implements Serializable{
	private ArrayList<Room> rooms;
	private Guest guest;
	
	
	public RoomList() {									
		rooms = new ArrayList();
	}

	public ArrayList<Room> getList() {					//gets room list 
		if(rooms == null) {
			return null;
		}
		return this.rooms;
	}
	

	public Room getRoomByRoomNumber(int roomNum, RoomList rooms) {	//gets room by room number
		for(Room r: rooms.getList()) {								//scan rooms in the roomlist	
			if(r.getRoomNumber() == roomNum){						//if roomNum is a room number on the list
				return r;
			}
		}
		return null;
	}
	
	public void addRoom(Room room) {								//adds a room to the roomlist
		this.rooms.add(room);
	}
	
	public int getNumberOfGuestsInRoom(Room r) {					//gets the number of guests in a room
			r.getGuest().size();
			return r.getGuest().size();
	}

	public Room getAvailableDoubles() {						//gets the first empty double room based on room number
		int dRoom = 4;										//Double rooms start at room number 4 and go up to room number 9
		for(Room room:rooms) {
			if(room.getRoomNumber() == dRoom) {
				if(room.getGuest().size()==0) { 
					return room;
				}
			}
			else if(room.getRoomNumber() == dRoom+1){
				if(room.getGuest().size()==0) { 
					return room;
				}
			}
			else if(room.getRoomNumber() == dRoom+2){
				if(room.getGuest().size()==0) { 
					return room;
				}
			}
			else if(room.getRoomNumber() == dRoom+3){
				if(room.getGuest().size()==0) { 
					return room;
				}
			}
			else if(room.getRoomNumber() == dRoom+4){
				if(room.getGuest().size()==0) { 
					return room;
				}
			}
			else if(room.getRoomNumber() == dRoom+5){
				if(room.getGuest().size()==0) { 
					return room;
				}
				else
					System.out.println("No more double rooms available");
					break;
			}
		}
		return null;
	}
	
	
	public Room getAvailableSingles() {								//gets the first available single room available
		int sRoom = 10;
		for(Room room:rooms) {
			if(room.getRoomNumber() == sRoom) {
				if(room.getGuest().size()==0) { 
					return room;
				}
			}
			else if(room.getRoomNumber() == sRoom+1){
				if(room.getGuest().size()==0) { 
					return room;
				}
			}
			else if(room.getRoomNumber() == sRoom+2){
				if(room.getGuest().size()==0) { 
					return room;
				}
			}
			else if(room.getRoomNumber() == sRoom+3){
				if(room.getGuest().size()==0) { 
					return room;
				}
			}
			else if(room.getRoomNumber() == sRoom+4){
				if(room.getGuest().size()==0) { 
					return room;
				}
			}
			else if(room.getRoomNumber() == sRoom+5){
				if(room.getGuest().size()==0) { 
					return room;
				}
				else
					System.out.println("No more Single rooms available");
					break;
			}
		}
		return null;
	}
	
	
	public Room getAvailableSuite() {											//gets the first available suite
		int suiteRoomNum = 1;
		for(Room room:rooms) {
			if(room.getRoomNumber() == suiteRoomNum) {
				if(room.getGuest().size()==0) { 
					return room;
				}
			}
			else if(room.getRoomNumber() == suiteRoomNum+1){
				if(room.getGuest().size()==0) { 
					return room;
				}
			}
			else if(room.getRoomNumber() == suiteRoomNum+2){
				if(room.getGuest().size()==0) { 
					return room;
				}
				else
					System.out.println("No more suites available");
					break;
			}
		}
		return null;
	}
	
	public int howManyRooms() {
		return rooms.size();
	}
	public boolean isEmpty() {
		if(rooms.size()==0)
			return true;
		else
			return false;
	}
	
	public int getFreeRooms(String roomType) {									//gets the available rooms
		int freeRooms = 0;
		
		for(Room room:rooms) {													//scans all the rooms on the room list
			switch(roomType) {
				case "suite":	if(room instanceof Suite) {						//if room is suite
									if(room.getGuest().size()==0)				//if no guests
										freeRooms++;							//add 1 to the available free room
								}
								break;
				case "double":	if(room instanceof Double) {					//same as above but for double
									if(room.getGuest().size()==0)
										freeRooms++;
								}
								break;
				case "single":	if(room instanceof Single && room.getGuest().size()==0) {
									freeRooms++;								//same as above but for Single
								}
								break;
			}
		}
		
		return freeRooms;
	}
	
	public String getRoomType(Room r) {								//gets room type
		String typeOfRoom = null;
		for(Room room:rooms)										//scans all rooms on roomlist
			if(r instanceof Suite) {								//if room is of type suite
				typeOfRoom = "suite";								// return suite
				return typeOfRoom;
			}
			else if(r instanceof Double) {							//same as above but for double
				typeOfRoom = "double room";
				return typeOfRoom;
			}
			else if(r instanceof Single) {							//same as above but for single
				typeOfRoom = "single room";
				return typeOfRoom;
			}
		
		return typeOfRoom;
	}
}
