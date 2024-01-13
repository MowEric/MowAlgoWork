package homework;

//import pattern.Matcher;

public class FingerprintMatcher implements Matcher {

    @Override
    public int[] match(int[][] pattern, int[][] text) {
        int[] begin = {0,0};
        int plength = pattern.length;
        int patternSig = signature(pattern, pattern.length, begin);
        int textSig = 0;
        int storage[] = new int[2];
        for(int i = 0; i < text.length-pattern.length+1; i++) {
            for(int j = 0; j < text.length-pattern.length+1; j++) {
                storage[0] = i;
                storage[1] = j;
                textSig = generateSignature(text, textSig, plength, storage);
                if(patternSig==textSig){
                    if (checkManual(pattern, text, storage)) return storage;
                }
            }
        }
        return null;
    }
    private boolean checkManual(int[][] pattern, int[][] text, int storage[]) {
        for(int i = 0; i < pattern.length; i++) {
            for(int j = 0; j < pattern.length; j++) {
                if(pattern[i][j] != text[storage[0]+i][storage[1]+j]) {
                    return false;
                }
            }
        }
        return true;
    }

    private int generateSignature(int[][] body, int oldSig, int plength, int[] coord){
        int sig = oldSig;
        if(coord[1] == 0) return signature(body, plength, coord);
        if(coord[1]!= body.length) {
           sig = shiftRight(body, coord, plength, sig);
        }
        return sig;
    }

    private int signature(int[][] body, int length, int[] coord){
        int sig = 0;
        for(int i = coord[0]; i <  coord[0] + length ; i++  ){
            for(int j = coord[1]; j < length ; j++){
                sig+= body[i][j];
            }
        }
        return sig;
    }

    private int shiftRight(int[][] body, int[]coord, int plength, int sig){
        for(int i = 0; i < plength ; i ++){
            sig -= body[coord[0] + i][coord[1] -1];
            sig += body[coord[0] + i][plength - 1 + coord[1]];
        }
        return sig;
    }
}
