package bignum;

import java.util.ArrayList;

public class BigNumO {

    private ArrayList<Integer> bignum;

    public BigNumO(String numbers) {
        for(int c = 0; c < numbers.length(); c++) {
            int x = (int) numbers.charAt(c);
            bignum.set(c, x);
        }
    }

    public String toString(int i) {
        return "" + i;
    }


    public BigNumO plus(BigNumO b) {
        return b;
    }

    public BigNumO times(BigNumO b) {
        return b;
    }
}
