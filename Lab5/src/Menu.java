import java.util.Scanner;

public class Menu {
	private Lecturer lect;
	private Book book;
	private Scanner keyboard;
	private BookList books;
	private int menuChoice;
	
	
	private static final int ADD_LECTURER =1;
	private static final int SEARCH_FOR_LECTURER_BY_ID =2;
	private static final int ADD_BOOK =3;
	private static final int REMOVE_BOOK = 4;
	private static final int SEARCH_FOR_BOOK = 5;
	private static final int CALCULATE_YEARLY_PAYMENT = 6;
	private static final int ALL_BOOK_DETAILS_ON_SYSTEM = 7;
	private static final int EXIT = 8;


	public Menu() {
		this.books = new BookList(15);
		new ObjectList(15);
	}

	public void startUserMenu() {
		keyboard = new Scanner(System.in);
		loadFile();																		//Loads file if there is one, and prints it to screen.
		displayMenu();																	//prints the displayMenu on the screen
		menuChoice = keyboard.nextInt();												//User picks from the menu

		while(menuChoice != EXIT) 														//keep looping while user does not hit EXIT
		{
			switch(menuChoice) 
			{
				case ADD_LECTURER:																//this case adds a student
				{
					String name;
					keyboard.nextLine();
					System.out.println("What is the name of the Lecturer you want to add?");	//asks for new lecturer name
					name = keyboard.nextLine();
		
					this.lect = new Lecturer(name,0);											//Lecturer(name,ID)
					books.addLect(this.lect);												//adds a new lecturer
					break;
				}//END OF ADD_LECTURER
				
				case SEARCH_FOR_LECTURER_BY_ID:												//this case searches for a lecturer by ID number
				{	
					System.out.println("**Lecturer ID's start at 1001, then 1002 and so on**");
					System.out.println("Please enter the ID number of the Lecturer you are looking for");//print message to screen
					
					int IDinput;
					IDinput = keyboard.nextInt();
					System.out.println(books.searchForLectuerByID(IDinput));					//prints "search for Lecturer by ID" method
					break;
				}//END OF SEARCH_SEARCH_FOR_LECTURER_BY_ID

				case ADD_BOOK:{																			//option to add a book
					String name,author,ISBN;
					double price;
					System.out.println("**Lecturer ID's start at 1001, then 1002 and so on**");			//prints message to screen
					System.out.println("Please enter the ID number of the Lecturer you wish to add a book for?");
					int IDinput;
					IDinput = keyboard.nextInt();

					lect = books.SearchAndReturnLecturerByID(IDinput);					//lect = call "search lecturers by ID" method
					if(lect == null) {														//If does not match a lecturer ID
						System.out.println("\n\t No Lecturer found with that ID \n\t");		//print message to screen
						displayMenu();
						break;
					}//end of if
					else {																	//if ID entered does match a Lecturer ID
						System.out.println("");												
						keyboard.nextLine();
						
						System.out.println("What is the name of the book "+lect.getName()+" wishes to add?"); //ask for a book name
						name = keyboard.nextLine();

						System.out.println("Who is the author of "+"'"+name+"'");			//ask for the author name
						author = keyboard.nextLine();

						System.out.println("What is the ISBN of "+"'"+name+"'");			//ask for the Book ISBN
						ISBN = keyboard.next();

						System.out.println("What is the price of "+"'"+name+"'");			//ask for the book price
						price = keyboard.nextDouble();

						this.book = new Book(name,price,ISBN,author);			
						this.lect.addBook(this.book);										//add book for this lecturer but the addBook method
						break;
						}//end of else
				}// END OF ADD_BOOK
				
				case REMOVE_BOOK:{															//option to remove a book by ISBN
					String ISBN;
					System.out.println("What is the ISBN of the book you wish to remove?");	//print message to screen
					ISBN = keyboard.next();
					books.removeBook(ISBN);											//calls method to remove book by ISBN 
					break;
				}//END OF REMOVE_BOOK
				
				case SEARCH_FOR_BOOK:														//option to search for book by ISBN
				{	
					String ISBN;
					System.out.println("What is the ISBN of the book you are looking for?"); //print message
					ISBN = keyboard.next();
					System.out.println(books.findBook(ISBN));							//calls method to find book by ISBN
					break;
				}//SEARCH_FOR_BOOK
				
				case ALL_BOOK_DETAILS_ON_SYSTEM:											//option to display all books on system
				{
					if(books.isEmpty()) {												//if Lecturers is empty print message
						System.out.println("\n\t ** No Lecturers or Books have been added to the system **");
					}//end of if
					else {																	//if Lecturers is not empty
						System.out.println(books.getAllDetails());						//print "get all details" method
					}//end of else
					break;
				}//END OF ALL_BOOK_DETAILS_ON_SYSTEM
				
				case CALCULATE_YEARLY_PAYMENT:											//option to calculate payment for a lecturer
				{																		//ask for lecturer ID
					System.out.println("**Lecturer ID's start at 1001, then 1002 and so on**");
					System.out.println("Please enter the ID number of the Lecturer you wish to add a book for?");
					int IDinput;
					IDinput = keyboard.nextInt();

					lect = books.SearchAndReturnLecturerByID(IDinput);				//lect = lecturer that matches ID input user
					if(lect == null) {													//if there was no lecturer that matched the ID
						System.out.println("\n\t No Lecturer found with that ID \n\t");	//print message to screen
						displayMenu();
						break;
					}//end of if
					else {																//if a lecturer did match the ID input
						int numBooks = lect.getBooks().getList().size();				//numBooks is the number of books a lecturer has
						
							if(numBooks==1) {												//if numBooks is 1, print message to screen.
								System.out.println("\n\t"+lect.getName()+" has only "+numBooks+" book");
							}//end of if(numBooks==1)
							else {															//if numBooks is not 1, print message to screen
								System.out.println("\n\t"+lect.getName()+" has "+numBooks+" books");
							}//end of else
							
						System.out.println("\tTotal Bill : €"+books.getYearlyBookPayment(lect));	//print the result of the method
																										//"getYearlyBookPayment(lect)"
					}//end of else
					break;
				}//END OF PROCESS_PAYMENT
			}//SWITCH

			System.out.println("");
			FileStorage.storeObject(books, "BOOKS.ser");													//stores LECTURERS												
			System.out.println("");
			System.out.println("");
			System.out.println("");
			displayMenu();
			
			menuChoice = keyboard.nextInt();
		}//while
	}//StartUserMenu		

	public void displayMenu() {					//This is the displayMenu the user chooses from
		System.out.println("");
		System.out.println(" Library book system for Lecturers");
		System.out.println("****************************************");
		System.out.println("1. Add A Lecturer");
		System.out.println("2. Display Lecturer by ID number");
		System.out.println("3. Add a book");
		System.out.println("4. Remove a Book");
		System.out.println("5. Search For Book");
		System.out.println("6. Calculate yearly payment");
		System.out.println("7. Display all Details");
		System.out.println("8. Exit");
		System.out.println("");
	}


	public void loadFile() {			
		books = (BookList)FileStorage.readObject("BOOKS.ser");
		if (books == null) {														//if(lecturers == null)
			System.out.println("BookList not read from file");						//print message to screen
			System.out.println("");
			books = new BookList(1);
		}//end of if
		else {																			//if(lecturers is not null)
			System.out.println("BookList read from file");							//print message to screen				
			System.out.println("");
			System.out.println(books.getAllDetails());								//print the results of the method "getAllDetails"
		}//end of else
	}// end of load file
}// end end
