package inclass;
import edu.princeton.cs.algs4.*;

public class Factorial {

    public static int factorial(int n) {
        int r = 1;
        for(int k = 1; k<=n;k++) {
            // Invariant: r = k!
            // Initialization:
            //  k = 1, r = 1 --> 1 = r = k! = 1! = 1
            // Maintenance:
            //  k' = k + 1, r' = r*k'
            //  r       = k!   (assumption)
            //  r*(k+1) = k!(k+1)   (multiply both sides)
            //  r*k'    = (k+1)!   (definition of factorial)
            //  r*k'    = k'!
            //  r'      = k'!
            // Termination:
            //  Exit the loop when k reaches n --> k = n && n! is computed
            // Order of growth:
            //  Loop executed n-1 times. independent of n --> factorial belongs to Big Theeta(n)
            //  All cases (worst, best average) are identical asymptotic to asymptotic behavior.

            r *= k;
        }
        return r;
    }

    public static void main(String[] args){
        StdOut.println(factorial(19));
    }
}
