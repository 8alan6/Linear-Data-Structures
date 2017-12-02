package hint3;
/**
 * Class: ChangeMaking
 * This class implements a greedy algorithm for solving the change making problem.
 */

public class ChangeMaking {
	/**
	 * Method: testChangeMaking
	 * 
	 * Tests and compares the algorithm for making change.
	 */
	public static void testChangeMaking()
	{
	
			int[] denoms = new int[4];

			// possible changes of coins 
			denoms[0]=20; // coin of value 20
			denoms[1]=10; // coin of value 10
			denoms[2]=5;  // coin of value 5
			denoms[3]=1;  // coin of value 1
	
			int val1 = 0; // maximum amount of money 0
			int val2 = 35; // maximum amount of money 1*20 + 1*10 + 1*5 
			int val3 = 53; // maximum amount of money 2*20 + 1*10 + 3*1
			
		    System.out.println("\n(Greedy solution) Number of coins needed: " + makeChangeGreedy(denoms, val1));
			System.out.println("\n(Greedy solution) Number of coins needed: " + makeChangeGreedy(denoms, val2));
			System.out.println("\n(Greedy solution) Number of coins needed: " + makeChangeGreedy(denoms, val3));

	
	}

	/**
	 * Method: makeChangeGreedy
	 * 
	 * Implements the greedy algorithm for solving
	 * the change making problem.
	 * 
	 * @param denoms array containing the different denominations
	 * @param val the target sum
	 * @return the number of coins needed
	 */
	public static int makeChangeGreedy(int[] denoms, int val)
	{
		int value = val;
		int count = 0;
		while(val>0) {
		if(val>=20) {
				val = val - 20;
				System.out.println();
				count += 1;
		}
		else if(val>=10) {
				val = val - 10;
				count += 1;
			}
		else if(val>=5) {
				val = val - 5;
				count += 1;
			}
		else if(val>=1) {
				val = val - 1;
				count += 1;
			}
		}
		
		int num = 0;
		if(count == 0) {
			System.out.println("No Coins required to make up a value of "+count+"c");
		}
		else {
		System.out.println(value+"c is made up of the following "+count+" coins");
		for(int i=0; i<denoms.length; i++) {
			if(denoms[i]<=value) {
			num = value/denoms[i];	
			System.out.println(num+"  x  "+denoms[i]+"c coins.");
			value-=num*denoms[i];
		}
			}
		}
		return count;// Complete this function
	}

	/**
	 * Main.
	 */
	public static void main(String[] args)
	{
		testChangeMaking();
	}
}
