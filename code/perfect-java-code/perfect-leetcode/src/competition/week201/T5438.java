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
        char[] charArray = s.toCharArray();
        for (int i = 0; i < s.length() - 1; i++) {
            char c1 = charArray[i];
            char c2 = charArray[i + 1];
            if ((Character.isLowerCase(c1) && Character.isUpperCase(c2))) {
                String s1 = s.substring(0, i);
                String s2 = s.substring(i + 2);
                s = s1 + s2;
            }
        }
        return s;
    }

}
