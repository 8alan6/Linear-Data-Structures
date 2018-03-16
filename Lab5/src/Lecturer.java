
import java.io.Serializable;

public class Lecturer implements Serializable{

	private BookList books;
	private final int MAX_BOOKS = 15;
	private String name;
	private int ID;
	static int LECT_ID = 1001;
	
	
	public Lecturer(String name, int id) {
		id = ID;
		this.name = name;
		books = new BookList(MAX_BOOKS);
		ID = LECT_ID;
		LECT_ID++;
	}
	
	public void addBook(Book b) {										//adds book b
		if(books.getList().size()<MAX_BOOKS) {
		this.books.add(b);
		}
		else {
			System.out.println("No more books can be added for this Lecturer");
		}
	}
	
	
	public void removeBook(Book b) { 									//Removes book b
		if(books.getList().size()>=1) {
			System.out.println("'"+b.getName()+"' has been removed from the booklist.");
			this.books.remove(b);
		}
		else {
			System.out.println("BookList for this Lecturer is already empty");
		}
	}
	
	public BookList getBooks() {				//gets booklist
		return this.books;
	}
	
	public String getName() {return this.name;} //gets lecturer name
	public int getID() {return this.ID;}		//gets lecturer ID
	
	public String toString() {					//Lecturer details toString
		return "\n\tLecturer: "+this.name+
				"\n\tID: "+this.ID;
	}
	
	public void Print() {
		System.out.println(toString());			//prints lecturer details from "toString method"
	}
}
