//package h03;

/**
 *  
 * The class implements all the operations available in MyStaticList<br>
 */
public class MyStaticList{

	//--------------------------------------------------
	// Attributes
	//--------------------------------------------------
	/**
	 * @param items: It stores the items of MyStaticList.
	 * @param numItems: It represents the number of items of MyStaticList.
	 * @param maxItems: It represents the maximum number of items a MyStaticList can contain.  
	 */
	private int items[]; 
	private int numItems;
	private int maxItems;

	/**
	 * The constructor creates 1 instance (1 object) of the class MyStaticList<br>
	 * @param m: The maximum number of items MyStaticList can contain.
	 */		
	public MyStaticList(int m){
		
		this.maxItems = m;
		this.items = new int[this.maxItems];
		this.numItems = 0;
	}

	//-------------------------------------------------------------------
	// Basic Operation --> Get number of integers in MyStaticList: my_get_length
	//-------------------------------------------------------------------	
	/**
	 * Given a concrete MyStaticList, it returns its number of items.<br>
	 * @return: Number of items of MyStaticList.
	 */	
	public int length(){
		//-----------------------------
		//Output Variable --> InitialValue
		//-----------------------------
		int res = 0;

		//-----------------------------
		//SET OF OPS
		//-----------------------------

		//-----------------------------
		// I. SCENARIO IDENTIFICATION
		//-----------------------------
		int scenario = 0; 

		//Rule 1. The number of elements is included in the attribute numItems
		scenario = 1;

		//-----------------------------
		// II. SCENARIO IMPLEMENTATION 
		//-----------------------------
		switch(scenario){	
		//Rule 1. Empty MyStaticList 
		case 1: 
			res = this.numItems;
			break;
		}			

		//-----------------------------
		//Output Variable --> Return FinalValue
		//-----------------------------	
		return res;
	}

	//-------------------------------------------------------------------
	// Basic Operation --> Get integer of MyStaticList at a concrete index: my_get_element
	//-------------------------------------------------------------------
	/**
	 * Given a concrete MyStaticList and a concrete index, it returns the item placed at that index (if any).<br>
	 * @param index: Index of MyStaticList we are looking for.	 
	 * @return: Item placed at the desired index of MyStaticList (ERROR if there is no item at such position).
	 */	
	public int getElement(int index){
		//-----------------------------
		//Output Variable --> InitialValue
		//-----------------------------
		int res = 0;

		//-----------------------------
		//SET OF OPS
		//-----------------------------

		//-----------------------------
		// I. SCENARIO IDENTIFICATION
		//-----------------------------
		int scenario = 0; 

		//Rule 1. Valid index: 0 <= index < numItems
		if ((index >= 0) && (index < numItems))
			scenario = 1;
		else{
			//Rule 2. Invalid index due to the current length of MyStaticList: numItems <= index < maxItems  
			if ((numItems <= index) && (index < maxItems))
				scenario = 2;
			//Rule 3. Invalid index: index < 0 || index >= maxItems
			else
				scenario = 3;		
		}

		//-----------------------------
		// II. SCENARIO IMPLEMENTATION 
		//-----------------------------
		switch(scenario){	
		//Rule 1. Valid index: 0 <= index < numItems
		case 1: 
			res = this.items[index];
			break;

			//Rule 2. Invalid index due to the current length of MyStaticList: numItems <= index < maxItems 
		case 2: 
			res = 0;
			System.out.println("ERROR: MyStaticList contains " + this.length() + " elements, it is not possible to get an item at index " + index);
			break;


			//Rule 3. Invalid index: index < 0 || index >= maxItems
		case 3: 
			res = 0;
			System.out.println("ERROR: No valid index for MyStaticList");
			break;
		}

		//-----------------------------
		//Output Variable --> Return FinalValue
		//-----------------------------		
		return res;	
	}

	//-------------------------------------------------------------------
	// Basic Operation --> Add integer to MyStaticList at a concrete index: my_add_element 
	//-------------------------------------------------------------------
	/**
	 * Given a concrete MyStaticList, an index and an item, it adds the item at the desired index of MyStaticList (if capacity allows it).<br>
	 * @param index: Index of MyStaticList we want to add the item at.
	 * @param item: Item we want to add to MyStaticList.	 
	 */	
	public void addElement(int index, int item){
		//-----------------------------
		//SET OF OPS
		//-----------------------------

		//-----------------------------
		// I. SCENARIO IDENTIFICATION
		//-----------------------------
		int scenario = 0; 

		if ((index >= 0) && (index <= numItems)){
			//Rule 1. Valid index and free room: (0 <= index <= numItems) and (numItems < maxItems)  
			if (numItems < maxItems)
				scenario = 1;
			//Rule 2. Valid index and full MyStaticList: (0 <= index <= numItems) and (numItems < maxItems) 
			else
				scenario = 2;
		}
		else{
			//Rule 3. Invalid index due to the current length of MyStaticList: numItems < index < maxItems 
			if ((numItems < index) && (index < maxItems))
				scenario = 3;
			//Rule 4. Invalid index: index < 0 || index >= maxItems
			else	
				scenario = 4;		
		}

		//-----------------------------
		// II. SCENARIO IMPLEMENTATION 
		//-----------------------------
		switch(scenario){	
		//Rule 1. Valid index and free room: (0 <= index <= numItems) and (numItems < maxItems) 
		case 1: 
			//1.1. We traverse all existing items from numItems-1 to index, shifting them one position to the right
			for (int i = (this.numItems - 1); i >= index; i--)
				this.items[i+1] = this.items[i];

			//1.2. We add the item at the desired index
			this.items[index] = item;	

			//1.3. We increase the number of items
			this.numItems = this.numItems + 1;

			break;

			//Rule 2. Valid index and full MyStaticList: (0 <= index <= numItems) and (numItems < maxItems) 
		case 2: 
			System.out.println("ERROR: MyList is already full");
			break;


			//Rule 3. Valid index but MyStaticList does not contain enough elements so as to add to it: numItems < index < maxItems 
		case 3: 
			System.out.println("ERROR: MyList contains " + this.length() + " elements, it is not possible to add an item at index " + index);
			break;

			//Rule 4. Invalid index: index < 0 || index >= maxItems
		case 4: 
			System.out.println("ERROR: No valid index for MyStaticList");
			break;

		}
	}

	//-------------------------------------------------------------------
	// Basic Operation --> Remove index of MyStaticList: my_remove_element 
	//-------------------------------------------------------------------	
	/**
	 * Given a concrete MyStaticList and index, it removes the item placed at the desired index of MyStaticList (if any).
	 * @param index: Index of MyStaticList we want to remove its item from.
	 */	
	public void removeElement(int index){
		//-----------------------------
		//SET OF OPS
		//-----------------------------

		//-----------------------------
		// I. SCENARIO IDENTIFICATION
		//-----------------------------
		int scenario = 0; 

		//Rule 1. Valid index: 0 <= index < numItems
		if ((index >= 0) && (index < numItems))
			scenario = 1;
		else{
			//Rule 2. Invalid index due to the current length of MyStaticList: numItems <= index < maxItems  
			if ((numItems <= index) && (index < maxItems))
				scenario = 2;
			//Rule 3. Invalid index: index < 0 || index >= maxItems
			else
				scenario = 3;		
		}

		//-----------------------------
		// II. SCENARIO IMPLEMENTATION 
		//-----------------------------
		switch(scenario){	
		//Rule 1. Valid index: 0 <= index < numItems
		case 1: 
			//1.1. We traverse all existing items from index to 0, shifting them one position to the left
			for (int i = index; i < (this.numItems - 1); i++)
				this.items[i] = this.items[i+1];

			//1.2. We decrease the number of items
			this.numItems = this.numItems - 1;

			break;

			//Rule 2. Invalid index due to the current length of MyStaticList: numItems <= index < maxItems 
		case 2: 
			System.out.println("ERROR: MyStaticList contains " + this.length() + " elements, it is not possible to remove an item from index " + index);
			break;


			//Rule 3. Invalid index: index < 0 || index >= maxItems
		case 3: 
			System.out.println("ERROR: No valid index for MyStaticList");
			break;
		}
	}

}

