package application;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class SerialStorage {

	public static void storeObject(String filename, Object o) {
		try {
			FileOutputStream fileOut = new FileOutputStream(filename);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(o);
			out.close();
			fileOut.close();
			System.out.printf("Serialized data is saved in "+filename+"\n");
		} catch (IOException i) {
			storeObject("IOException.ser",i);
		}
	}

	public static Object readObject(String filename) {
		Object obj = null;
		try {
			FileInputStream fileIn = new FileInputStream(filename);
			ObjectInputStream in = new ObjectInputStream(fileIn);
			obj = in.readObject();
			in.close();
			fileIn.close();
		} catch (FileNotFoundException a) {
			storeObject("FileNotFound.ser", a);
			a.printStackTrace();
		} catch (IOException i) {
			storeObject("IOException.ser", i);
			i.printStackTrace();
		} catch (ClassNotFoundException c) {
			storeObject("ClassNotFoundException.ser", c);
			c.printStackTrace();
		}
		return obj;
	}
}