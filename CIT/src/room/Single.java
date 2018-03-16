package room;

public class Single extends Room{
	private static int MAX_NUM_GUESTS = 1;
	public Single() {
		super(75.00);
	}	
	
	public int getMaxGuests() {
		return MAX_NUM_GUESTS;
	}
	
}
