/*
* This program prints the roots of a quadratic equation of the form: 
* ax^2 + bx + c 
*/
public class QuadForm{

	public static void quadFormula(double a, double b, double c){

		double discriminant = b*b - 4.0* a*c; 

		if(a==0){
			System.out.println("No quadratic (a=0)"); 
		}
		else if (discriminant < 0){
			System.out.println("No real roots"); 
		}
		else{
			double result_plus = - b+ Math.sqrt(discriminant)/(2.0*a); 

			if (discriminant==0.0){
				System.out.println("One real root: "+result_plus); 
			}
			else{
				double result_minus = - b - Math.sqrt(discriminant)/(2.0*a);
				System.out.println("Two roots: "+result_plus+" and "+result_minus); 
			}
		}
	}

	public static void main(String[] args){
		//Test driven development: We'll write these tests first! 
		
		//Interative development: We'll compile and test once we think we've written a solution to each part

		// Test 1: a = 0 
		System.out.println("===Test 1===");
		double a_example1 = 0.0; 
		double b_example1 = -5.0/2.0; 
		double c_example1 = 2.0; 
		quadFormula(a_example1, b_example1, c_example1);
		System.out.println();


		// Test 2: Should have no real roots 
		// x^2 + 2x + 5 
		System.out.println("===Test 2===");  
		double a_example2 = 1.0; 
		double b_example2 = 2.0; 
		double c_example2 = 5.0; 
		quadFormula(a_example2, b_example2, c_example2);
		System.out.println();


		// Test 3: one real root 
		System.out.println("===Test 3==="); 
		double a_example3 = 1.0; 
		double b_example3 = -2.0; 
		double c_example3 = 1.0; 
		quadFormula(a_example3, b_example3, c_example3);
		System.out.println();

		// Test 4: two real roots
		// Roots: 1 and 4  
		System.out.println("===Test 4==="); 
		double a_example4 = 0.5; 
		double b_example4 = -5.0/2.0; 
		double c_example4 = 2.0; 
		quadFormula(a_example4, b_example4, c_example4);
		System.out.println();
	}
}