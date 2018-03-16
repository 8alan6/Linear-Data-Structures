
import java.io.Serializable;

public class Book implements Serializable {
	String isbn;
	double price;
	String name;
	String author;
	
	public Book(String name, double price, String isbn, String author) {
		this.name=name;
		this.price=price;
		this.isbn=isbn;
		this.author = author;
	}
	
	public String getName() {return this.name;}			//gets book Name
	public String getAuthor() {return this.author;}		//gets book Author
	public String getISBN() {return this.isbn;}			//gets book ISBN
	public double getPrice() {return this.price;}		//gets book price
	
	public String toString() {							//All book details toString()
		return "\n\tBook Name : "+this.name+
				"\n\tBook Author : "+this.author+
				"\n\tBook ISBN : "+this.isbn+
				"\n\tBook Price : €"+this.price+
				"\n\t  ";
	}
}
