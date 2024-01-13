package bloom;

public class BloomFilter<S> {
    private long[] bitTable;
    public BloomFilter() {bitTable= new long[1024];}
    private static final int MASK = (1<<16)-1;

    public void Bitadd(int key) {bitTable[key/64] |= 1L << (key % 64);}


    public void add(S object) {
        int hashCode =object.hashCode();
        Bitadd(hashCode & MASK);
        Bitadd((hashCode >>> 16) & MASK);

    }
    public boolean containBit(int key) {return ((bitTable[key/64] & (1L << (key % 64))) != 0);}

    public boolean mightContain(S object) {
        int hashCode = object.hashCode();
        return containBit(hashCode & MASK) && containBit((hashCode >>> 16) & MASK);
    }

    public int trueBits() {
        int bitc =0;
        for(long c:bitTable) {
            long c2 = c;
            while (c2 != 0) {
                bitc++;
                c2 = (c2 - 1) & c2;
            }
        }
        return bitc;
    }
}
