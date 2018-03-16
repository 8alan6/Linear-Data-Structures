package application;

public class Main{
	
	public static void main(String[] args) {
		Controller c = new Controller();
		c.login(0);							//0 is used as a counter. Max no of Login attempts is 3
	}
}
