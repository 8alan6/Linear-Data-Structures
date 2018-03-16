package room;

public class Double extends Room{
	private final int MAX_NUM_GUESTS = 2;
	public Double() {
		super(100.00);
	}
	
	public int getMaxGuests() {
		return MAX_NUM_GUESTS;
	}
}