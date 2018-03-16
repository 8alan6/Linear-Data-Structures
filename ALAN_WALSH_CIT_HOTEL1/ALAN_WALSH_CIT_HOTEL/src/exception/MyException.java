package exception;

import room.Room;

public class MyException extends Exception{
	public MyException(String details) {
		super(details);
	}
}
