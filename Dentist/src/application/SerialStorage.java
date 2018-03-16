package application;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class SerialStorage {

	private Scanner keyboard;

	//save an object to file..
	//all our objects are at their base an OBJECT
	public boolean saveToFile(String filename, Object o) {
		try {
			FileOutputStream fileOut = new FileOutputStream(filename);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(o);
			out.close();
			fileOut.close();
			System.out.printf("Serialized data is saved in " + filename);
		} catch (IOException i) {
			i.printStackTrace();
			return false; // something went wrong
		}

		return true;
	}

	//return an object as everything is an object
	//we can cast to our calling class later
	public Object readFromFile(String filename) {
		Object e = null;
		try {
			FileInputStream fileIn = new FileInputStream(filename);
			ObjectInputStream in = new ObjectInputStream(fileIn);
			e = in.readObject();
			in.close();
			fileIn.close();
		} catch (IOException i) {
			keyboard = new Scanner(System.in);
			String choice;
			System.out.println("\t"+filename+" does not exist\n\t"+filename+" will be created.");
			System.out.println("\tDo you wish to print the exception?\t(YES/NO)");
			choice = keyboard.next();
			if(choice.toUpperCase().equals("YES")||choice.toUpperCase().equals("Y")) {
				i.printStackTrace();	
			}
			
			
		} catch (ClassNotFoundException c) {
			System.out.println("Person class not found");
			c.printStackTrace();
		}
		return e;
	}
}
