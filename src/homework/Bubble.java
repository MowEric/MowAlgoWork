package homework;

// For this code's outer loop, the invariant is that the leftmost i elements are unsorted (in other words, the b.length-i
// rightmost numbers are sorted. This doesn't true at initialization but once it goes through the nested for loop, it
// will hold true by the end of the iteration. Since it will fulfill the invariant after passing through the loop, the
// algorithm should work on the final iteration.

public class Bubble {

    public static void sort(Double b[]) {
        for(int i = b.length-1; i > 0; i--) {
            for(int c = 1; c <= i; c++) {
                if (b[c] < b[c-1]) {
                    double sub = b[c-1];
                    b[c-1] = b[c];
                    b[c] = sub;
                }
            }
        }
    }
}
