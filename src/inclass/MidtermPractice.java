package inclass;

public class MidtermPractice {
    Comparable[] A;

    // Invariant: The leftmost i items in the array are less than or equal to maximum;
    // Real invariant: maximum = max(A[0:i-1])
    // Initialization: i = 1. max(A[0:0]) = A[0]
    // Maintenance: Assumption: invariant holds for value i
    // r = max(X[0:i-1])
    // "max(r, A[i])" - Mathematical function of max. Compares two values. This is the if statement.
    // r = "max(max(A[0:i-1]), A[i])
    // r = max(A[0:i])
    // "i++"
    // r = max(A[0:i-1] (updated version of i)
    private Comparable max(Comparable A[]) {
        Comparable maximum = A[0];
        for (int i = 1; i < A.length; i++) {
            if(A[i].compareTo(maximum) > 0) maximum = A[i];
        }
        return maximum;
    }
}
