package room;

public class Suite extends Room{
	private final int MAX_NUM_GUESTS = 3;
	public Suite() {
		super(150.00);
	}
	
	public int getMaxGuests() {
		return MAX_NUM_GUESTS;
	}
}
