package bytedance.string;

/**
 * @author Kelly
 * @create 2020-07-19 15:38
 *
 * IP 地址转 整数
 */
public class IPToLong {
    // 将 IP 地址转为整数
    private static long IPToLong(String ip) {
        String[] strings = ip.split("\\.");
        Long[] nums = new Long[4];
        for (int i = 0; i < 4; i++) {
            System.out.println(strings[i]);
            nums[i] = Long.parseLong(strings[i]);
        }
        return (nums[0] << 24) + (nums[1] << 16) + (nums[2] << 8) + (nums[3]);
    }
    private static String LongToIP(long num) {
        String res = "";
        for (int i = 0; i < 4; i++) {
            res = "." + (num % 256) + res;
            num >>>= 8;
        }
        return res.substring(1);
    }
    private static String LongToIP2(long num) {
        StringBuilder sb = new StringBuilder();
        sb.append((num) >>> 24).append(".");
        sb.append((num & (0x00ffffff)) >>> 16).append(".");
        sb.append((num & (0x0000ffff)) >>> 8).append(".");
        sb.append((num & (0x000000ff)));
        return sb.toString();
    }

    public static void main(String[] args) {
        String IP = "192.168.0.1";
        long longIp = IPToLong(IP);
        System.out.println("192.168.0.1 的整数形式为：" + longIp);
        String s = LongToIP(longIp);
        System.out.println(s);
        String s2 = LongToIP2(longIp);
        System.out.println(s2);
    }

}
