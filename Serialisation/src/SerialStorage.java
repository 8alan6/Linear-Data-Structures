import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerialStorage {

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
			i.printStackTrace();
			System.out.println("\t"+filename+" does not exist");
			
		} catch (ClassNotFoundException c) {
			System.out.println("Person class not found");
			c.printStackTrace();
		}
		return e;
	}
}
