package pycro.usts.chapter06_string;

/**
 * @author Pycro
 * @version 1.0
 * 2023-06-03 10:07 PM
 */
public class ReverseString {
    // 双指针
    class Solution1 {
        public void reverseString(char[] s) {
            // 双指针
            int i = 0;
            int j = s.length - 1;
            while (i < j) {
                char temp = s[i];
                s[i] = s[j];
                s[j] = temp;
                ++i;
                --j;
            }
        }
    }
}
