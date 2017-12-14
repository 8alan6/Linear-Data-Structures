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
		int num = 0;												//declare int num = 0. this will be the number of times a coin is used
		int count = 0;												//declare int count = 0
		if(val == 0) {
			System.out.println("No Coins required to make up a value of "+val+"c");
		}
		else {
			System.out.println("");
			System.out.println("");
			for(int i=0; i<denoms.length; i++) {						//loop through each value int denoms Array
				if(denoms[i]<=val) {									//if the value of denoms is less or equal to val
					num = val/denoms[i];									//num is val divided by the value of denoms
																			// eg. 35/20 = 1, 15/10 = 1, 5/5 = 1

					System.out.println(num+"  x  "+denoms[i]+"c coins.");	//print value of num, denoms (coin value)
					val -= num*denoms[i];									//value = value - (num*denoms[i])
					count++;
				}															//eg. 	value = 35 - (35/20  x  20)		35 - 20 = 15	
			}														//		value = 15 - (15/10  x  10)	 	15 - 10 = 5
		}															// 		value = 5  - ( 5/5   x   5)		5  -  5 = 0		finished			
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
