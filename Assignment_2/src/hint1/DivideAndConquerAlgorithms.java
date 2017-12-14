package hint1;
/**
 * The class contains the Divide and Conquer-based Algorithms we are using. 
 */
public class DivideAndConquerAlgorithms {

	//----------------------------------------------
	// Class constructor
	//----------------------------------------------	
	/**
	 * Constructor of the class. Do not edit it.
	 */
	public DivideAndConquerAlgorithms(){}

	//-------------------------------------------------------------------
	// 0. iterativeDisplayElements --> Displays all elements of a MyDynamicList 
	//-------------------------------------------------------------------	
	/**
	 * Given a concrete MyDynamicList, this iterative algorithm displays its elements by screen (if any).
	 * @param m: The MyDynamicList we want to display its elements.	  
	 */	
	public void iterativeDisplayElements(MyDynamicList m){
		//-----------------------------
		//SET OF OPS
		//-----------------------------

		//-----------------------------
		// I. SCENARIO IDENTIFICATION
		//-----------------------------
		int scenario = 0; 

		//Rule 1. MyDynamicList is empty
		if (m.length() == 0) 
			scenario = 1;
		//Rule 2. MyDynamicList is non-empty
		else
			scenario = 2;

		//-----------------------------
		// II. SCENARIO IMPLEMENTATION 
		//-----------------------------
		switch(scenario){	

		//Rule 1. MyDynamicList is empty
		case 1: 
			//1. We print the empty message
			System.out.println("Empty MyDynamicList");

			break;

			//Rule 2. MyDynamicList is non-empty
		case 2: 
			//1. We print the initial message
			int size = m.length();
			System.out.println("MyDynamicList Contains the following " + size + " items: ");

			//2. We traverse the items
			for (int i = 0; i < size; i++)
				System.out.println("Item " + i + ": " + m.getElement(i));

			break;

		}

	}

	//-------------------------------------------------------------------
	// 1. maxInt --> Computes the maximum item of MyDynamicList 
	//-------------------------------------------------------------------	
	/**
	 * The function computes the maximum item of m (-1 if m is empty). 
	 * @param m: The MyDynamicList we want to compute its maximum item.
	 * @return: The maximum item of MyDynamicList	  
	 */	
	public int maxInt(MyDynamicList m){
		if(m.length() == 0) {				//if m is empty return -1.
			return -1;						//Told in instructions should be -1 if empty.
		}

		else if(m.length()==1){				//if m has just 1 element
			return m.getElement(0);				//then the maxInt will be the only int, positioned at (0).

		}
		else{
			int min;											//declare a min int.
			int max;											//declare a max int.
			if(m.getElement(0) <= m.getElement(1)) {		//if 1st element <= to the 2nd element.
				min = m.getElement(0);							//set min to the value at m.getElement(0).
				max = m.getElement(1);							//set max to the value at m.getElement(1).
				m.removeElement(0);								//remove the minimum value.
				maxInt(m);										//solve for the smaller m List.
				m.addElement(0, min);							//add the min back to position (0).
			}
			else {											//else .... the 1st element > 2nd element.		
				max = m.getElement(0);							//now max is equal to value at (0).
				min = m.getElement(1);							//now min is equal to value at (1).
				m.removeElement(1);								//remove the min value.
				maxInt(m);										//solve for the smaller m List.
				m.addElement(1, min);							//add the min value back to position (1).
			}
			return max;										//return the value of max.
		}
	}

	//-------------------------------------------------------------------
	// 2. isReverse --> Computes if MyDynamicList is sorted in decreasing order 
	//-------------------------------------------------------------------	
	/**
	 * The function computes whether m is sorted in decreasing order or not.  
	 * @param m: The MyDynamicList we want to check.
	 * @return: Whether m is sorted in decreasing order or not.  
	 */	
	public boolean isReverse(MyDynamicList m){
		if(m.length() == 0) {				//m is empty so can be true or false. I set as true***
			return true;
		}			
		else if(m.length() == 1) {			//m has 1 element so can be said to be in decreasing order.
			return true;
		}
		else if(m.length() >= 2) {			//if m has 2 or more elements,
			int e0 = m.getElement(0);		//declare int e0 equal to m.getElement(0).
			int e1 = m.getElement(1);		//declare int e1 equal to m.getElement(1).
			if(e1>e0) {					//if e1 is greater than e0 the list not in decreasing order.
				return false;			
			}
			else {						//else if e0 >= e1. 
				m.removeElement(0);		//remover e0.
				isReverse(m);			//solve isReverse(m) for smaller List m.
				m.addElement(0, e0);	//add e0 back to the List m at position (0).
			}
		}
		return true;						//return true.
	}

	//-------------------------------------------------------------------
	// 3. getNumAppearances --> Computes the amount of times that integer appears in MyDynamicList  
	//-------------------------------------------------------------------	
	/**
	 * The function computes the amount of times that the integer n appears in m.   
	 * @param m: The MyDynamicList we want to use.
	 * @param n: The number we want to compute its appearances for.
	 * @return: The amount of appearances of n into m  
	 */	
	public int getNumAppearances(MyDynamicList m, int n){
		int matches = 0;					//declare int matches = 0.

		if(m.length() == 0) {				//if MyDynamicList is equal to 0.
			return matches;					// matches will be 0.
		}
		else if(m.length()==1) {			//if MyDynamicList is equal to 1.
			if(m.getElement(0)==n) {		//if the only element is equal to int n.
				matches++;					// increase matches by a value of 1.
			}
			return matches;					//return the int matches.
		}

		else if(m.length()>1)						//if MyDynamicList has a more than 1 elements
		{
			int e0 = m.getElement(0);				//declare int e0 = to first element in 'm'.
			if(e0 == n) {							//if e0 is equal to n.
				m.removeElement(0);					//remove the element (0) from List 'm'.
				matches = getNumAppearances(m,n);	//solve for smaller list 'm'.
				matches++;							//increase matches by 1.
				m.addElement(0, e0);				//add e0 back to the original list.
			}
			else {									//else if e0 is not equal to n
				m.removeElement(0);					//remove first element of m
				matches = getNumAppearances(m,n);	//solve for smaller list m
				m.addElement(0, e0);				//add e0 back to the original list.
			}
		}
		return matches;
	}

	//-------------------------------------------------------------------
	// 4. power --> Computes the m-est power of n
	//-------------------------------------------------------------------	
	/**
	 * The function computes n to the power of m.
	 * @param n: The base number.
	 * @param m: The power of n we want to compute
	 * @return: n to the power of m.  
	 */	

	public int power(int n, int m){
		if(m == 0) {					//if m is equal to 0,
			return 1;					// the n^m must be equal to 1.
		}
		return ( n * power(n,m-1));		//n multiply by (solve for smaller list)

	}

	//-------------------------------------------------------------------
	// 5. lucas --> Computes the n-est term of the Lucas series
	//-------------------------------------------------------------------	
	/**
	 * The function computes the n-est term of the Lucas series
	 * @param n: The n-est term of the series we want to compute
	 * @return: The term being computed 
	 */	
	public int lucas(int n){
		if(n == 0) {
			return 2;
		}
		else if(n == 1) {
			return 1;		
		}
		else {
			int n1 = lucas(n-1);
			int n2 = lucas(n-2);
			int n3 = n1 + n2;
			return n3;
		} 
	}

	//-------------------------------------------------------------------
	// 6. drawImage --> Prints a pattern of a given length
	//-------------------------------------------------------------------	
	/**
	 * The function prints prints a pattern of a given length.
	 * *
	 * **
	 * ***
	 * ... 
	 * @param n: The length of the desired pattern
	 */	
	public void drawImage(int n){
		int count = n - 1;
			while(count+1>0) {
			drawLine(n - count);
			count--;
		}
			System.out.println(".......................");
	}
	//-------------------------------------------------------------------
	// 7. drawLine --> Prints a line of a given length
	//-------------------------------------------------------------------	
	public void drawLine(int n){

		if (n > 0) {
			System.out.print("*");
			drawLine(n - 1);
		}
		else {
			System.out.println();
		}
	}
}

