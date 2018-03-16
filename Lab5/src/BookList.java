
public class BookList extends ObjectList{

	public BookList(int max) {
		super(max);		
	}	

	public String getAllDetails() {		//gets all details of lecturers and books.
		String val = "LECTURERS\n=================";
		
		for(Object o:getList()) {
			Lecturer lect = (Lecturer)o;
			val+="\nName: "+lect.getName()+
					"\nID: "+lect.getID()+
					"\n\tBOOKS==========="+
					"\n\t";
			
			for(Object n:lect.getBooks().getList()) {
				Book b = (Book)n;
				val+="\n\tBook Name: "+b.getName()+
						"\n\tBook Author: "+b.getAuthor()+
						"\n\tBook Price: €"+b.getPrice()+
						"\n\tBook ISBN: "+b.getISBN()+
						"\n\t";
			}
		}
		
		return val;
	}


	public String findBook(String ISBN) {			//finds Book by ISBN
		String val = "BOOKS\n=================";

		if(getList().size()>=1) {
			for(Object o:getList()) {
				Lecturer lect = (Lecturer)o;
				for(Object n:lect.getBooks().getList()) {
					Book b = (Book)n;
					if(b.getISBN().toUpperCase().equals(ISBN.toUpperCase())) {
						val+="\n\tBook Name: "+b.getName()+
								"\n\tBook Author: "+b.getAuthor()+
								"\n\tBook Price: €"+b.getPrice()+
								"\n\tBook ISBN: "+b.getISBN()+
								"\n\t";
					}//End of if
				}//End of for(object n:getList())
			}//End of for(object o:getList())
		}//End of if(getList.size()>=1)

		return val;
	}



	public String getAllLecturerNames() {				//unused method but could be useful for another assignment
		String val = "LECTURERS\n=================";

		for(Object o:getList()) {
			Lecturer lect = (Lecturer)o;
			val+="\nName: "+lect.getName();
		}
		return val;
	}


	public String searchForLectuerByID(int ID) {		//Searches for lecturer by ID and returns string
		String lectFound = "Could Not Find a Lectuer with "+ID+" as an ID Number";
		for(Object o:getList()) {
			Lecturer lect = (Lecturer)o;
			if(ID == lect.getID()) {
				lectFound ="\n\tLecturer ID: "+lect.getID()+
						"\n\tLecturer Name: "+lect.getName()+
						"\n\t";
			}
		}
		return lectFound;
	}

	public Lecturer SearchAndReturnLecturerByID(int ID) {	//searches for Lecture by ID and returns that Lecturer
		Lecturer lect = null;
		for(Object o:getList()) {
			lect = (Lecturer)o;
			if(lect.getID() == ID) {
				return lect;
			}
		}	
		return null;
	}

	public Boolean removeBook(String ISBN) { //removes book
		Book b = null;
		if(getList().size()>=1) {
			for(Object o:getList()) {
				Lecturer lect = (Lecturer)o;
				for(Object n:lect.getBooks().getList()) {
					b = (Book)n;
					if(b.getISBN().toUpperCase().equals(ISBN.toUpperCase())) {
						lect.removeBook(b);
						return true;
					}//End of if
				}//End of for(object n:getList())
			}//End of for(object o:getList())
		}//End of if(getList.size()>=1)

		return false;
	}
	

	public double getYearlyBookPayment(Lecturer lect) { //calculates yearly payment due for a lecturer
		double payment = 0;

				for(Object n:lect.getBooks().getList()) {
					Book b = (Book)n;
					payment += b.getPrice();
				}//End of for(object n:getList())
			
		

		return payment;
	}

}




