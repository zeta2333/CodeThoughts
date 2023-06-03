package pycro.usts.chapter06_string;

/**
 * @author Pycro
 * @version 1.0
 * 2023-06-03 10:22 PM
 */
public class ReverseStringII {
    class Solution {
        public String reverseStr(String s, int k) {
            // 将String转为char数组
            char[] chs = s.toCharArray();
            int n = chs.length;
            // 理论的反转范围
            for (int left = 0; left < n; left += 2 * k) {
                int right = left + k - 1;
                // min方法只在最后超范围的一次执行了有意义的判断
                reverse(chs, left, Math.min(right, n - 1));
            }
            return String.valueOf(chs);
        }

        public void reverse(char[] chs, int i, int j) {
            while (i < j) {
                chs[i] ^= chs[j];
                chs[j] ^= chs[i];
                chs[i] ^= chs[j];
                ++i;
                --j;
            }
        }
    }
}
