package bytedance.string;

/**
 * @author Kelly
 * @create 2020-07-25 21:33
 */
public class T1147_LongestChunkedPalindromeDecomposition {
    /**
     * 递归
     */
    public int longestDecomposition(String text) {
        int n = text.length();
        for(int i = 1;i <= n/2; ++i){
            if(text.substring(0,i).equals(text.substring(n-i,n))){
                return 2 + longestDecomposition(text.substring(i,n-i));
            }
        }
        return n == 0 ? 0 : 1;
    }
    /**
     * 维护两个窗口
     */
    public int longestDecomposition1(String text) {
        if (text == null || text.length() == 0) return 0;
        int res = 0;
        int leftL = 0, leftR = 1;
        int rightL = text.length() - 1, rightR = text.length();
        while (leftR <= rightL) {
            String left = text.substring(leftL, leftR);
            String right = text.substring(rightL, rightR);
            if (left.equals(right)) {
                res += 2;
                leftL = leftR;
                rightR = rightL;
            }
            leftR++;
            rightL--;
        }
        return (leftL == rightR) ? res : res + 1;
    }
}
