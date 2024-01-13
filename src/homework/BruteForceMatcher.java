package homework;

public class BruteForceMatcher implements Matcher {
    @Override
    public int[] match(int[][] pattern, int[][] text) {
        int storage[] = new int[2];
        for(int i = 0; i < text.length-pattern.length+1; i++) {
            for(int j = 0; j < text.length-pattern.length+1; j++) {
                storage[0] = i;
                storage[1] = j;
                if(check(pattern, text, storage)) return storage;
            }
        }
        return null;
    }

    private boolean check(int[][] pattern, int[][] text, int storage[]) {
        for(int i = 0; i < pattern.length; i++) {
            for(int j = 0; j < pattern.length; j++) {
                if(pattern[i][j] != text[storage[0]+i][storage[1]+j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
