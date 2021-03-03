package bit;

public class BitCount {

    public int[] countBits(int num) {
        int[] res = new int[num+1];
        for (int i = 0; i <= num; i++) {
            res[i] = countOnes(i);
        }
        return res;
    }

    public int bitCount(int num) {
        int count = 0;
        do {
            count += num & 1;
            num = num >> 1;
        } while (num != 0 );
        return count;
    }

    /*
        x = x&(x-1)将x的二进制表示的最后一个1变成0。直达x变成0
     */
    public int countOnes(int x) {
        int ones = 0;
        while (x > 0) {
            x &= (x - 1);
            ones++;
        }
        return ones;
    }

    public int[] countBits2(int num) {
        int[] res = new int[num+1];
        for (int i = 1; i <= num; i++) {
            res[i] = res[i&(i-1)] + 1;
        }
        return res;
    }

    public int[] countBits3(int num) {
        int[] bits = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            bits[i] = bits[i >> 1] + (i & 1);
        }
        return bits;
    }

    public static void main(String[] args) {
        BitCount target = new BitCount();
        //System.out.println(target.countOnes(7));
        System.out.println(target.countOnes(8));
    }
}
