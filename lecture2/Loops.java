/*
* This file gives some examples of for-loops and while-loops
* It also shows examples with continue and break statements 
*/

public class Loops{

	// Uses a for loop to print out powers of 2 
	public static void forPowers2(){
		int n = 5; 
		int power=1; 
		for (int i = 0; i <=n; i++){
			System.out.println(i + " "+ power); 
			power = 2 * power; 
		}
	}

	// Uses a for loop to print out the factorial 
	public static void factorial(){
		int n = 4;
		int product = 1;
		for (int i =1; i <= n; i++){
		    product *= i;
		}
		System.out.println(product);
	}

	// Uses a while loop to print out powers of two 
	public static void whilePowers2(){
		int n = 5; 
		int power = 1; 
		while (power <= n/2){
			power = 2*power; 
			System.out.println(power); 
		}
	}

	// Uses a while loop plus a break statement
	// To print out powers of 2 
	public static void breakExample(){
		int power = 1;
		while(power <= 1000000){
			power = 2*power; 

			if(power > 10){
				break; 
			}
			System.out.println(power); 
		}
		System.out.println("Final="+power);
	}

	// "Wonky" factorial 
	// Only increment for every other integer
	// Example 1*3*5 or 1*3*5*7
	public static void continueExample(){
		int n = 10; 
		int product = 1; 
		for(int i=0; i <= n; i++){
			if(i%2 == 0){
				continue; 
			}
			product *= i; 
			System.out.println(product); 
		}
	}

	public static void main(String[] args){
		// Comment and uncomment these static methods to isolate them 
		forPowers2(); 
		// factorial(); 
		// whilePowers2(); 
		// breakExample(); 
		// continueExample(); 
	}
}