package inclass;
import edu.princeton.cs.algs4.*;

public class MyMath {
    /**
     * raise first argument to power of second
     * @param a is the base
     * @param b is the exponent, with b >= 0
     * @return base raised to the exponent power
     */

    public static int pow(int a, int b) {
        int ans = 1;
        if (b == 0) return 1;
        for(int c = 0; c<b; c++) {
            ans *= a;
        }
        return ans;
    }

    public static int pow2(int a, int b) {
        if (b == 0) return 1;
        if (b%2==0) {
            int r = pow2(a,b/2);
            return r*r;
        }
        else {
            int r = pow2(a, (b-1)/2);
            return a*r*r;
        }
    }



    public static void main(String[] unused) {
        StdOut.println(pow(2,10));
    }
}
