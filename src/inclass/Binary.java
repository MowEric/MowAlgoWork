package inclass;

public class Binary {
    private int Binary(int x) {
        int i;
        for(i = 1;i <= x; i*=2) {
            
        }
        for(int c = i; c > 0; c/=2) {

        }
        return 0;
    }

    private int[] Binary2(int x) {
        int b[] = new int[31];
        int i = 0;
        while (x > 0) {
            Binary(i);
            x /= 2;
        }
        return b;
    }
}
