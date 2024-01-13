package inclass;
import edu.princeton.cs.algs4.*;

/**
 * fib n = fib n-1 + fib n-2
 * fib 0 = 0
 * fib 1 = 1
 */
public class Fibonacci {

    static public void main(String[] unused) {
        StdOut.println(fib(20));
        StdOut.println(fib(8));
        StdOut.println(fib(10));
        //StdOut.println(fib2(4));
        //StdOut.println(fib2(8));
        //StdOut.println(fib2(40));
    }


    static int fib(int n) {
        if (n <= 2) return n-1;
        int val, prev1, prev2;
        val = 1;
        prev1 = 1;
        prev2 = 0;
        for(int c = 3; c<=n; c++){
            prev2 = prev1;
            prev1 = val;
            val = prev1 + prev2;
        }
        return val;
    }

/*
     static long fib(int n) {

        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;
        return fib(n-1) + fib(n-2));
     }
*/

    /*
    private static int[] cachedEntries = new int[92];

    static long fib(int n) {
        if (cachedEntries[n] > 0) return cachedEntries[n];
        if (n == 0) return 0;
        if (n == 1) return 1;
        int f = (int) (fib(n-1) + fib(n-2));
        cachedEntries[n] = f;
        return f;
    }

    static int fib2(int n) {
        return go(n, 0, 1);
    }

    private static int go(int n, int a, int b) {
        if (n==0) return a;
        if (n == 1) return b;
        return go(n -1, b, a+b);
    }
    */
}
