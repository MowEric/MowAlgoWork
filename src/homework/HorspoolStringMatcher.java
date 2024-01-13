package homework;

public class HorspoolStringMatcher {

    private String pattern;
    private int length;

    public HorspoolStringMatcher(String pattern) {
        this.pattern = pattern;
        this.length = pattern.length();
    }

    public int[] preprocess(String S) {
        int T[] = new int[256];
        for(int i = 0; i < 256; i++) {
            T[i] = this.length;
        }
        for(int i = 0; i <= this.length-1; i++) {
            T[(int)this.pattern.charAt(i)] = this.length-1-i;
        }
        return T;
    }

    public int getShift(char m) {
        for(int i = this.length-2; i >= 0; i--) {
            if(this.pattern.charAt(i) == m) {
                return length-1-i;
            }
        }
        return this.length;
    }

    public int match(String s) {
        int T[] = preprocess(s);
        int skip = 0;
        String temp = s;
        while(s.length() - skip >= this.length) {
            temp = s.substring(skip);
            if (same(temp, this.pattern, this.length)) {
                return skip;
            }
            skip = skip + getShift(s.charAt(skip + this.length - 1));
        }
        return -1;
    }

    public boolean same(String s1, String s2, int length) {
        int i = length - 1;
        while (s1.charAt(i) == s2.charAt(i)) {
            if (i == 0) {
                return true;
            }
            i = i - 1;
        }
        return false;
    }
}
