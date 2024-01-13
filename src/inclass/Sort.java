package inclass;

import edu.princeton.cs.algs4.StdOut;

public class Sort {

    public static void insertionSort(Comparable[] a) {

        for (int i = 1; i<= a.length; i++) {
            Comparable v = a[i];
            int j = i - 1;
            while (j >= 0 && a[j].compareTo(v) > 0) {
                a[j+1] = a[j];
                j--;
            }
            a[j+1] = v;
        }
    }

    public static void main(String[] unused) {
        int[] a = {5,4,3,2,-1};
        //insertionSort(a);
        for (int i = 0; i <a.length; ++i) {
            StdOut.print(a[i] + " ");
        }


        char[] a1 = "Today is pirate day".toCharArray();
        //insertionSort(a1);
    }
}
