package power;

public class Power {

	public static int factorial(int n){
		if(n==1) {
			return 1;
		}
		return n*factorial(n-1);
	}
	
	
	
	
	public static int power(int n, int m){
		
		
		if(m == 0) {					//if m is equal to 0,
			return 1;					// the n^m must be equal to 1.
		}
		//without this piece of code above the program will not work
		//we will end up with a StackOverFlowError because power(n,(m-1))
		//will result in an infinite recursion loop with minus powers.
		//We have to stop the loop by saying if(m has reached 0) then return 1.
		
		
		
		return ( n * power(n,m-1));		//n multiply by (solve for smaller list)

	}
	
	public static void main(String[] args) {
		System.out.println("5! = "+factorial(5));
		System.out.println("2^3 = "+power(2,3));	
	}

}
