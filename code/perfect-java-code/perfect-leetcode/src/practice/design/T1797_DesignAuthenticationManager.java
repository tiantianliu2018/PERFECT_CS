package practice.design;

import java.util.HashMap;
import java.util.Map;

/**
 * 检查验证码是否过期
 *
 * @author Kelly
 * @create 2021-07-17 11:22
 */
public class T1797_DesignAuthenticationManager {
    class AuthenticationManager {
        // key 验证码 value 过期时间
        Map<String, Integer> codeMap = new HashMap<>();
        int timeToLive = 0;

        public AuthenticationManager(int timeToLive) {
            this.timeToLive = timeToLive;
        }

        public void generate(String tokenId, int currentTime) {
            codeMap.put(tokenId, currentTime + timeToLive);
        }

        public void renew(String tokenId, int currentTime) {
            if (codeMap.containsKey(tokenId)) {
                if (codeMap.get(tokenId) > currentTime) {
                    codeMap.put(tokenId, currentTime + timeToLive);
                }
            }
        }

        public int countUnexpiredTokens(int currentTime) {
            int count = 0;
            for (Integer value : codeMap.values()) {
                if (value > currentTime) {
                    count++;
                }
            }
            return count;
        }
    }
}
