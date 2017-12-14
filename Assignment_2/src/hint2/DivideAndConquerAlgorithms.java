package hint2;

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
	// 1. recursiveDisplayElements --> Displays all elements of a MyDynamicList  
	//-------------------------------------------------------------------	
	/**
	 * Given a concrete MyDynamicList, this recursive algorithm displays its elements by screen (if any).
	 * @param m: The MyDynamicList we want to display its elements.	  
	 */	
	public void recursiveDisplayElements(MyDynamicList m){

		//-----------------------------
		// I. SCENARIO IDENTIFICATION
		//-----------------------------
		int scenario = 0; 

		//Rule 1. If MyDynamicList is Empty
		if (m.length() == 0) 				
			scenario = 1;
		//Rule 2. MyDynamicList is non-empty
		else
			scenario = 2;

		//-----------------------------
		// II. SCENARIO IMPLEMENTATION 
		//-----------------------------
		switch(scenario){	
		case 1:
		{
			System.out.println("MyDynamicList is Empty");	//prints when MyDynamicList is empty
			System.out.println("");
			break;
		}
		case 2:
			int e0 = m.getElement(0);			//e0 = the element at position 0 of list m
			System.out.println(e0);				//print the value of e0

			if(m.length()>1) {					// putting in this if statement means "MyDynamicList is Empty won't print"
												// as MyDynamicList will always have one element remaining.
				m.removeElement(0);				//removes element at position 0 of List m.
				recursiveDisplayElements(m);	//recursively solve the smaller problem.
				m.addElement(0, e0);			//add e0 to the List m1 to keep its original state.
			}
			else {
				System.out.println("");			//creates a space between MyDynamicLists
			}
			break;
		}
	}

	//-------------------------------------------------------------------
	// 2. smallerMyList --> Filters all elements in MyDynamicList smaller than e
	//-------------------------------------------------------------------	
	/**
	 * The function filters all elements of MyDynamicList being smaller than 'e'  
	 * @param m: The MyDynamicList we want to check.
	 * @param e: The number 'e' we want to compare each element of MyDynamicList to.
	 * @return: The new MyDynamicList containing just the elements being smaller than 'e'  
	 */	
	public MyDynamicList smallerMyList(MyDynamicList m, int e){

		//-----------------------------
		//Output Variable --> InitialValue
		//-----------------------------
		MyDynamicList res = null;
		//-----------------------------
		   //SET OF OPS
		   //-----------------------------

		   //-----------------------------
		   // I. SCENARIO IDENTIFICATION
		   //-----------------------------
		   int scenario = 0;
		   if (m.length()==0)
		      scenario = 0;
		   
		   if (m.length()==1)
		      scenario = 1;
		   
		   if (m.length()>1)
		      scenario =2;

		   //-----------------------------
		   // II. SCENARIO IMPLEMENTATION 
		   //-----------------------------
		   switch(scenario){
		      case 0:
		         res = new MyDynamicList();			//MyDynamicList is Empty.
		         break;
		      case 1:								//MyDynamicList has only 1 value.
		         res = new MyDynamicList();
		         int elem0 = m.getElement(0);		//declare int elem0 = 1st value of List 'm'.
		         if (elem0 < e)						// if elem0 is less than 'e'.
		            res.addElement(0,elem0);		//add elem0 to the resulting List.
		         break;
		      case 2:								//myDynamicList has more than 1 value.
		         int element0 = m.getElement(0);	//declare int element0 = 1st value of List 'm'.
		         m.removeElement(0);				//remove the first element of List 'm'.
		         res = smallerMyList(m,e);			//solve the smaller List 'm'.
		         if (element0 < e)					//if element0 is less than 'e'
		            res.addElement(0, element0);	//add element0 to the resulting List.
		         m.addElement(0,element0);			//add element0 back to the original List.
		         break;
		   }

		   //-----------------------------
		   //Output Variable --> Return FinalValue
		   //-----------------------------       
		   return res;
	}

	//-------------------------------------------------------------------
	// 3. biggerMyList --> Filters all elements in MyDynamicList bigger than e
	//-------------------------------------------------------------------	
	/**
	 * The function filters all elements of MyDynamicList being bigger than 'e'  
	 * @param m: The MyDynamicList we want to check.
	 * @param e: The number 'e' we want to compare each element of MyDynamicList to.
	 * @return: The new MyDynamicList containing just the elements being bigger or equal than 'e'  
	 */	
	public MyDynamicList biggerEqualMyList(MyDynamicList m, int e){
		
		//-----------------------------
		//Output Variable --> InitialValue
		//-----------------------------
		MyDynamicList res = null;
		//-----------------------------
		   //SET OF OPS
		   //-----------------------------

		   //-----------------------------
		   // I. SCENARIO IDENTIFICATION
		   //-----------------------------
		   int scenario = 0;
		   
		   if (m.length()==0)			//if MyDynamicList m is empty.
		      scenario = 0;				
		   
		   if (m.length()==1)			//if MyDynamicList m  has just 1 element.
		      scenario = 1;
		   
		   if (m.length()>1)			//if MyDynamicList m has more than 1 element
		      scenario =2;

		   //-----------------------------
		   // II. SCENARIO IMPLEMENTATION 
		   //-----------------------------
		   switch(scenario){
		      case 0:
		         res = new MyDynamicList();		//List is Empty
		         break;
		      case 1:							//List has 1 value.
		         res = new MyDynamicList();		
		         int elem0 = m.getElement(0);	//declare it elem0 equal to the first element of List m.
		         if (elem0 >= e) {				//if elem0 greater than equal to e.
		            res.addElement(0,elem0);	//add elem0 to the resulting list.
		            }
		         	break;						//if elem0 is less that e, then res will remain empty.
		      case 2:
		         int element0 = m.getElement(0);	//declare int element0 equal to m.getElement(0).
		         m.removeElement(0);				//remove the element at (0).
		         res = biggerEqualMyList(m,e);		//solve the smaller m list
		         
		         if (element0 >= e) {				//if element0 is >= to 'e'
		            res.addElement(0, element0);	//add element0 to the result List
		            m.addElement(0,element0);		//add element0 back to List m.
		         }
		         else if (element0 < e) 			//or if element0 is less than 'e'.
		         {	
		        	 m.addElement(0, element0);		//only add element0 back to the original list m.
		         }
		         break;
		   }
		
		//-----------------------------
		//Output Variable --> InitialValue
		//-----------------------------
		 //result is only the values in List 'm' equal to or greater than the value of 'e'.
		return res;				

			}
		
	//-------------------------------------------------------------------
	// 3. concatenate --> It concatenates 2 MyDynamicList   
	//-------------------------------------------------------------------	
	/**
	 * The function concatenates the content of 2 MyDynamicList.   
	 * @param m1: The first MyDynamicList.
	 * @param m2: The second MyDynamicList.
	 * @return: The new MyDynamicList resulting of concatenate the other 2 MyDynamicList
	 */	
	public MyDynamicList concatenate(MyDynamicList m1, MyDynamicList m2){

		//-----------------------------
		//Output Variable --> InitialValue
		//-----------------------------
		MyDynamicList res = null;

		//-----------------------------
		//SET OF OPS
		//-----------------------------

		//-----------------------------
		// I. SCENARIO IDENTIFICATION
		//-----------------------------
		int scenario = 0; 

		//Rule 1. MyDynamicList m1 is empty
		if (m1.length() == 0) 
			scenario = 1;
		else{
			//Rule 2. MyDynamicList m2 is empty
			if (m2.length() == 0) 
				scenario = 2;
			else{
				scenario = 3;
			}
		}

		//-----------------------------
		// II. SCENARIO IMPLEMENTATION 
		//-----------------------------

		int size = 0;
		int e0m1 = 0;
		int e0m2 = 0;
		int auxE = 0;

		switch(scenario){	

		//Rule 1. MyDynamicList m1 is empty
		case 1: 
			//1. We create the new list as a result
			res = new MyDynamicList();

			//2. We traverse all elements of m2, adding them to the list
			size = m2.length() - 1;
			while (size >= 0){
				//2.1. We access to the element in m2
				auxE = m2.getElement(size);

				//2.2. We append the element to res
				res.addElement(0, auxE); 

				//2.3. We decrease the index of size
				size--;
			}

			break;

			//Rule 2. MyDynamicList m2 is empty
		case 2: 
			//1. We create the new list as a result
			res = new MyDynamicList();

			//2. We traverse all elements of m1, adding them to the list
			size = m1.length() - 1;
			while (size >= 0){
				//2.1. We access to the element in m1
				auxE = m1.getElement(size);

				//2.2. We append the element to res
				res.addElement(0, auxE); 

				//2.3. We decrease the index of size
				size--;
			}

			break;

			//Rule 3 both lists have at least 1 element
		case 3: 
			//1. We get the first element of List m2
			e0m2 = m2.getElement(0);

			//2. We remove the first element from m2 we just checked
			m2.removeElement(0);

			//3. We recursively solve the smaller problem
			res = concatenate(m1, m2);

			//4. We add e0m2 to the resulting list.
			res.addElement(0, e0m2);

			//5. We also add the element back to m2, so as to not to modify its original state
			m2.addElement(0, e0m2);
			
			//1. We get the first element of List m1
			e0m1 = m1.getElement(0);

			//2. We remove the first element from m1 we just checked
			m1.removeElement(0);

			//3. We recursively solve the smaller problem
			res = concatenate(m1, m2);

			//4. We add back e0m1 to the resulting list.
			res.addElement(0, e0m1);

			//5. We also add the element back to m1, so as to not to modify its original state
			m1.addElement(0, e0m1);

			break;							
		}

		//-----------------------------
		//Output Variable --> Return FinalValue
		//-----------------------------		
		return res;				//res will be a concatenation of Lists m1 and m2.
	}	

}
