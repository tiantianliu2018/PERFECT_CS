package practice.string.sort;

/**
 * @author Kelly
 * @description
 * @create 2021-07-03 10:50
 * <p>
 * 给你两个版本号 version1 和 version2 ，请你比较它们。
 */
public class T165_CompareVersionNumbers {
    /**
     * 循环遍历比较，空间复杂度O(n)
     *
     * @param version1
     * @param version2
     * @return
     */
    public int compareVersion(String version1, String version2) {
        String[] s1 = version1.split("\\.");
        String[] s2 = version2.split("\\.");
        int n1 = s1.length;
        int n2 = s2.length;
        for (int i = 0; i < Math.max(n1, n2); i++) {
            int num1 = i < n1 ? Integer.parseInt(s1[i]) : 0;
            int num2 = i < n2 ? Integer.parseInt(s2[i]) : 0;
            if (num1 < num2) {
                return -1;
            } else if (num1 > num2) {
                return 1;
            }
        }
        return 0;
    }

    /**
     * 双指针
     *
     * @param version1
     * @param version2
     * @return
     */
    public int compareVersion1(String version1, String version2) {
        int n = version1.length();
        int m = version2.length();
        int i = 0;
        int j = 0;
        while (i < n || j < m) {
            int v1 = 0;
            while (i < n && version1.charAt(i) != '.') {
                v1 = v1 * 10 + version1.charAt(i) - '0';
                i++;
            }
            int v2 = 0;
            while (j < m && version2.charAt(j) != '.') {
                v2 = v2 * 10 + version2.charAt(j) - '0';
                j++;
            }
            if (v1 > v2) {
                return 1;
            } else if (v1 < v2) {
                return -1;
            }
            i++;
            j++;
        }
        return 0;
    }
}

