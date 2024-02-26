/**
 * Computes the greatest common divisor between two integers in multiple ways:  
 * 1. iterative_gcd: Iterative brute force
 * 2. iterative_gcd2: Euclid's algorithm, iterative 
 * 3. recursive_gcd: Euclid's algorithm, recursively
 */

public class GCD{

	// O(q)
	public static int iterative_gcd(int p, int q){
		// Now do the "brute force" and check every integer 
		int largest = 1; // 1 always divides everything
		for(int i=2; i<q; i++){
			// Check if i divides both p qnd q  
			if (q % i == 0 & p % i == 0){
				largest = i; 
			}
		}
		return largest; 
	}

	// Euclid's algorithm 
	// O(log(q))
	public static int interative_gcd2(int p, int q){
		while (q != 0) {
            int temp = q;
            q = p % q;
            p = temp;
        }
        return p;
	}

	// Euclid's algorithm, recursively
	// O(log(q))
	public static int recursive_gcd(int p, int q){
		if(q == 0){
			return p; 
		else{
			return recursive_gcd(q, p % q); 
		}
	}

	public static int[] checkSwap(int p, int q){
		// 1. Ensure q always be the smaller one  
		if(q > p){
			// Swap with a temp variable 
			int temp = q; 
			q = p; 
			p = temp; 
		}
		int[] out = {p, q}; 
		return out; 
	}

	public static void main(String[] args){
		// Testing 
		// int p = 20; 
		// int q = 16;

		// GCD of two primes should be 1 
		int p = 17; 
		int q = 7;

		// Ensure q is always the smaller one 
		int[] pq_arr = checkSwap(p, q); 
		p = pq_arr[0]; 
		q = pq_arr[1];

		System.out.println(iterative_gcd(p, q)); 
	}

}