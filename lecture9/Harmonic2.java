/**
 * Version 1 of Harmonic we did in Lecture 3: https://github.com/cs136-s24/public_cs136/blob/main/lecture3/Harmonic.java
 * 
 */

public class Harmonic2 {

    // // Interative version works 
    // public static double harmonic(int n) {
    //     double sum = 0.0;
    //     for (int i = 1; i <= n; i++) {
    //         sum += 1.0 / i;
    //     }
    //     return sum;
    // }

    // // Version A 
    // public static double harmonic(int n){
    //     return harmonic(n-1) + 1.0/n; 
    // }

    // // Version B  
    // public static double harmonic(int n){
    //     if(n==1){
    //         return 1.0; 
    //     }
    //     return harmonic(n) + 1.0/n; 
    // }

    // Version C 
    // Should break for N=100K+ 
    public static double harmonic(int n){
        if(n==0){
            return 0.0; 
        }
        return harmonic(n-1) + 1.0/n; 
    }

    /**
     * First command line argument is N
     * 
     * Usage: 
     *  java Harmonic2 10
     */
    public static void main(String[] args) {
        int userN = Integer.parseInt(args[0]);
        System.out.println(userN); 
        double value = harmonic(userN); 
        System.out.println("The "+userN+"th harmonic number is "+value); 
    }
}