package inclass;
import java.lang.Math;

class Poly {
    /**
     * Takes in the coefficients of the polynomials
     */
    private double[] coeff;
    Poly(double[] coeff){
        this.coeff = coeff;
    }

    double eval (double x) {
        double a = 0;
        for(int c = 0; c < coeff.length; c++){
            int expon = coeff.length-1-c;
            double sortax = x;
            for(int d = 1; d < expon; d++) {
                sortax = sortax*sortax;
            }
            if (expon == 0) sortax =1;
            a += coeff[c] * sortax;
        }
        return a;
    }

    double eval2 (double x) {
        double a = coeff[0];
        for(int c = 0; c < coeff.length-1; c++) {
            a *= x;
            a += coeff[c+1];
        }
        return a;
    }

    public static void main(String args[]) {
        double[] test = {1,2,1};
        Poly p = new Poly(test);
        edu.princeton.cs.algs4.StdOut.print(p.eval(4) + "\n");
        edu.princeton.cs.algs4.StdOut.print(p.eval2(4));
    }
}
