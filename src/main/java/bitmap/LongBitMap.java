package bitmap;

public class LongBitMap {
    private long bits;
    private final int[] map;

    public static final long SHIFT = 5;
    public static final long MASK  = ((1 << SHIFT) -1);

    public LongBitMap(long nbits) {
        bits = nbits + 1;
        int size  = (int) (((bits >>> SHIFT) + 1) & 0x0ffffffffL);
        map = new int[size];
    }

    public long size() {
        return bits;
    }

    public void set(long index) {
        int offset = (int) ((index >>> SHIFT) & 0x0ffffffffL);
        map[offset] |= (1 << (index & MASK));
    }

    public boolean isSet(long index) {
        int offset = (int) ((index >>> SHIFT) & 0x0ffffffffL);
        int off = (int) (index & MASK);
        return ((map[offset] >>> off) & 0x01) == 0x1;
    }

    public void clear(long index) {
        int offset = (int) ((index >>> SHIFT) & 0x0ffffffffL);
        map[offset] &=  ~(1 << (index & MASK));
    }
}
