/*
* Convert Fahrenheight temperature to Celsius
*/
public class TempConvert{

	// The number we will convert 
	public static final double FAHR = 40.0; // A constant in Java  

	public static void main(String[] args){
		double cel; // initalize 

		cel = (FAHR - 32) * 5.0/9.0; 
		System.out.println("The temp (in C) ="+cel);

	}
}