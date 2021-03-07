package bitmap;

public class IpSet {

    private LongBitMap longBitMap;

    public IpSet() {
        this.longBitMap = new LongBitMap(1L << 32);
    }

    private long ip2long(String ip) {
        String[] ips = ip.split("\\.");
        return  ((Integer.parseInt(ips[0]) << 24) |
                (Integer.parseInt(ips[1]) << 16) |
                (Integer.parseInt(ips[2]) <<  8) |
                (Integer.parseInt(ips[3]))) & 0x0ffffffffL;
    }

    public void set(String ip) {
        long idx = ip2long(ip);
        longBitMap.set(idx);
    }

    public boolean contains(String ip) {
        long idx = ip2long(ip);
        return longBitMap.isSet(idx);
    }

    public long size() {
        return longBitMap.size();
    }

    public static void main(String[] args) {
        IpSet ipTable = new IpSet();
        ipTable.set("192.168.0.1");
        ipTable.set("21.196.12.100");
        ipTable.set("21.196.12.1");
        ipTable.set("21.196.22.1");
        String ip = "21.196.12.100";

        if (ipTable.contains(ip)) {
            System.out.println("ip set has ip: " + ip);
        }
        System.out.println(ipTable.size());
        System.out.println(1L << 32);
        System.out.println(Integer.MAX_VALUE*2L);
    }
}
