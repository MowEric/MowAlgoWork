package homework;

import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;

public class BigNum {

    private ArrayList<Integer> bignum;

    public BigNum(String numbers) { // takes a string
        if (numbers.length() == 0) { //if the string is empty, return 0
            bignum = new ArrayList<>(1);
            bignum.add(0, 0);
            return;
        }
        assert numbers.length() > 0; //make sure the length of the string is bigger than 0
        bignum = new ArrayList<>(numbers.length()); //make an array list, called bignum
        int counter = 0;
        for (int j = 0; j < numbers.length(); j++) { // for every character in the string, starting at the end and going to 0
            int x = Integer.parseInt(String.valueOf(numbers.charAt(j))); // find the value of the character
            bignum.add(j, x); //add the number to the corresponding index in the arrayList
            counter++;
        }
    }

    public String toString() {
        String result = "";
        int length = this.bignum.size();
        for (int i = 0; i < length; i++) {
            result += this.bignum.get(i);
        }
        return result;
    }

    public BigNum plus(BigNum b) {
        int x = 0;
        int x2 = 0;
        int sum;
        int j = 0;
        int bsize = b.bignum.size();
        int thissize = this.bignum.size();
        boolean l = true;
        StdOut.print("beginning " + b +" \n");
        if (thissize>bsize) l = false;
        BigNum temp = new BigNum("");
        if (!l) {
            for(int i = 0; i< thissize-bsize; i++) {
                b.bignum.add(i, 0);
            }
        }
        if (l) {
            for(int i = 0; i< bsize-thissize; i++) {
                this.bignum.add(i, 0);
            }
        }
        for (int i = 0; i < b.bignum.size(); i++) {
            x = b.bignum.get(i);
            x2 = this.bignum.get(i);
            sum = x + x2;
            if (sum < 10) {
                temp.bignum.add(j, sum);
                if (i == 0) temp.bignum.remove(1);
                j++;
            } else {
                if (i == 0) {
                    temp.bignum.add(1, sum - 10);
                    temp.bignum.set(0, 1);
                    j += 2;
                } else {
                    temp.bignum.set(j - 1, 1);
                    temp.bignum.add(sum - 10);
                    j++;
                }
            }
        }

        if (!l) {
            for(int i = 0; i< thissize-bsize -1; i++) {
                b.bignum.remove(i);
                StdOut.print(b +" \n");
            }
        }
        if (l) {
            for(int i = 0; i< bsize-thissize-1; i++) {
                this.bignum.remove(i);
                StdOut.print(this +" \n");

            }
        }
        return temp;
    }

    public BigNum times(BigNum b) {
        int bsize = b.bignum.size();
        int thissize = this.bignum.size();
        boolean l = true;
        int x, x2;
        int carry = 0;
        int posb = 0;
        int post = 0 ;
        if (thissize>bsize) l = false;
        BigNum temp = new BigNum("");

        for(int i = bsize-1; i >=0; i-- ){
            carry = 0;
            x= b.bignum.get(i) ;
            post = 0;
            for(int j = thissize -1; j>= 0; j--){
                x2 = this.bignum.get(j) ;
                int sum = x*x2 + temp.bignum.get(posb + post) + carry;
                carry = sum/10;
                temp.bignum.set(posb+post, sum%10);
                StdOut.print(temp + "\n");
                post++;
                temp.bignum.add(i, 0);
            }

            if(carry>0){
                int r = temp.bignum.get(posb+post);
                temp.bignum.set(posb+post, r+=carry);
                posb++;

            }

        }

        for(int i =0; i< temp.bignum.size()-1; i++){
            if(temp.bignum.get(i)==0){
                temp.bignum.remove(i);
            }else{
                break;
            }
        }
        return temp;
    }
}


//    int x = 0;
//    int x2 = 0;
//    int product;
//    int j = 0;
//    int bsize = b.bignum.size();
//    int thissize = this.bignum.size();
//    BigNum temp = new BigNum("");
//        for (int i = 0; i < b.bignum.size(); i++) {
//        for (int k = 0; k < bsize; k++) {
//        StdOut.print("j : " + j + "\n");
//        x = b.bignum.get(i);
//        x2 = this.bignum.get(k);
//        product = x * x2;
//        if (product < 10) {
//        temp.bignum.add(j -1, product);
//        if (i == 0) temp.bignum.remove(1);
//        StdOut.print(temp);
//        j++;
//        } else {
//        if (i == 0) {
//        temp.bignum.add(1, product % 10);
//        temp.bignum.set(0, product / 10);
//        j ++;
//        } else {
//        temp.bignum.set(j - 1, product / 10);
//        temp.bignum.add(j, product % 10);
//        j++;
//        }
//        }
//
//        }
//        }
