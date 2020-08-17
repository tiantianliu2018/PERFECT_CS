package competition.week201;

/**
 * @author Kelly
 * @create 2020-08-09 10:36
 */
public class T5438 {
    public static void main(String[] args) {
        String s = makeGood("Pp");
        System.out.println(s);
    }
    public static String makeGood(String s) {
        StringBuilder sb = new StringBuilder(s);
        while (true) {
            boolean flag = true;
            for (int i = 0; i < sb.length(); i++) {
                if (sb.charAt(i) == sb.charAt(i - 1) + 32 || sb.charAt(i) == sb.charAt(i - 1) - 32) {
                    sb.replace(i - 1, i + 1, "");
                    flag = false;
                }
            }
            if (flag) break;
        }
        return sb.toString();
    }

}
