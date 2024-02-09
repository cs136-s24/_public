/*
* Prints the nth harmonic number: 1/1 + 1/2 + ... + 1/n.
* Adapted from: Sedgewick and Wayne https://introcs.cs.princeton.edu/java/21function/Harmonic.java.html
*/

public class Harmonic {

    public static double harmonic(int n) {
        double sum = 0.0;
        for (int i = 1; i <= n; i++) {
            sum += 1.0 / i;
        }
        return sum;
    }

    public static void main(String[] args) {
        int userN = Integer.parseInt(args[0]);
        System.out.println(userN); 
        double value = harmonic(userN); 
        System.out.println("The "+userN+"th harmonic number is "+value); 
    }
}