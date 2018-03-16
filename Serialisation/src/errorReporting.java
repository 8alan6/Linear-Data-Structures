import java.io.IOException;

public class errorReporting {

	public errorReporting(IOException io) {
		
	}
	
	public void printError(IOException io) {
	io.printStackTrace();	
	}
}
