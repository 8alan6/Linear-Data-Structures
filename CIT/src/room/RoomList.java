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

	public ArrayList<Room> getList() {
		if(rooms == null) {
			return null;
		}
		return this.rooms;
	}
	

	public ArrayList<Room> occupiedRooms(){
        ArrayList<Room> occupiedRooms = new ArrayList<Room>();
        for (Room r : rooms ){
            if (r.getGuest().size()>0)
                occupiedRooms.add(r);
        }
        return occupiedRooms;
    }
	
	public Room getRoomByRoomNumber(int roomNum, RoomList rooms) {
		System.out.println(rooms.getList().size());
		for(Room r: rooms.getList()) {
			if(r.getRoomNumber() == roomNum){
				if(r.getGuest().size()>0) {
					return r;
				}
			}
		}
		return null;
	}
	
	
	
	/*
    public String guestList(){
        String returnString="";
        for (Room r : occupiedRooms()){
            returnString = returnString + r.getGuest() + " "+ r.guestOccupying()+ "\n";
        }
        if (returnString.equals(""))
            return "No guests";
        return returnString;
    }
*/
	
	public void getAllGuests() {
	
		}
	
	
	public void addRoom(Room room) {
		this.rooms.add(room);
	}
	
	public int getNumberOfGuestsInRoom(Room r) {
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
	
	
	public Room getAvailableSingles() {
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
					System.out.println("No more double rooms available");
					break;
			}
		}
		return null;
	}
	
	
	public Room getAvailableSuite() {
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
	
	public int getFreeRooms(String roomType) {
		int freeRooms = 0;
		
		for(Room room:rooms) {
			switch(roomType) {
				case "suite":	if(room instanceof Suite) {
									if(room.getGuest().size()==0)
										freeRooms++;
								}
								break;
				case "double":	if(room instanceof Double) {
									if(room.getGuest().size()==0)
										freeRooms++;
								}
								break;
				case "single":	if(room instanceof Single && room.getGuest().size()==0) {
									freeRooms++;
								}
								break;
			}
		}
		
		return freeRooms;
	}
	
	public String getRoomType(Room r) {
		String typeOfRoom = null;
		for(Room room:rooms)
			if(r instanceof Suite) {
				typeOfRoom = "suite";
				return typeOfRoom;
			}
			else if(r instanceof Double) {
				typeOfRoom = "double room";
				return typeOfRoom;
			}
			else if(r instanceof Single) {
				typeOfRoom = "single room";
				return typeOfRoom;
			}
		
		return typeOfRoom;
	}
}
