/**
 * A recursive and dynamic-programming approach to getting the 
 * nth number of the Fibonacci sequence. 
 */

public class Fibonacci{	

	// Static variable that we use to cache computations we make 
	private static int[] fibCache = new int[100]; 	

	// Dynamic-programming approach 
	// O(n) 
	public static int topDownFibonacci(int n){
		 if (n <= 1) {
	        return n;
	    }

	    // Second base case 
	    if(fibCache[n]> 0){
	    	return fibCache[n]; 
	    }

	    // Recursive step
	    fibCache[n] = topDownFibonacci(n - 1) + topDownFibonacci(n - 2);
		return fibCache[n]; 
	}

	// Recursive approach
	// O(2^n)
	public static int fibonacci(int n) {
	    if (n <= 1) {
	        return n;
	    } else {
	        return fibonacci(n - 1) + fibonacci(n - 2);
	    }
	}

	public static void main(String[] args){
		int n = 5; 
		//int nthNumber = fibonacci(n); 
		int nthNumber = topDownFibonacci(n);
		System.out.println(nthNumber);  
	}
}