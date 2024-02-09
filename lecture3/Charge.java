/*
* Class for a "charged particle" 
* Adapted from: https://introcs.cs.princeton.edu/java/32class/Charge.java.html
*/

public class Charge {
    // Instance variables 
    private final double rx, ry;   // position
    private final double q;        // charge

    // Constructor 
    public Charge(double x0, double y0, double q0) {
        rx = x0;
        ry = y0;
        q  = q0;
    }

    // Instance method
    public double potentialAt(double x, double y) {
        double k = 8.99e09;
        double dx = x - rx;
        double dy = y - ry;
        return k * q / Math.sqrt(dx*dx + dy*dy);
    }

    // Instance method
    public String toString() {
        return q + " at (" + rx + ", " + ry + ")";
    }

    // Static main method 
    public static void main(String[] args) {
        double x = Double.parseDouble(args[0]);
        double y = Double.parseDouble(args[1]);
        Charge c1 = new Charge(0.51, 0.63, 21.3);
        Charge c2 = new Charge(0.13, 0.94, 81.9);
        System.out.println(c1);
        System.out.println(c2);
        double v1 = c1.potentialAt(x, y);
        double v2 = c2.potentialAt(x, y);
        System.out.println(v1+v2);
    }
}