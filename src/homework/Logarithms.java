package homework;

public class Logarithms {
    public static int log(int a, int b) {
        int c;
        for (c = 0; b >= 1; c++) {
            b = b / a;
        }
        return c-1;
    }

}