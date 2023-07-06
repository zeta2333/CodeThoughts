package usts.pycro.chapter06_string;

/**
 * @author Pycro
 * @version 1.0
 * 2023-07-06 2:55 PM
 * leetcode:28
 */
public class FindtheIndexoftheFirstOccurrenceinaString {
    // 暴力解法，直接匹配，O(n*m)
    class Solution1 {
        public int strStr(String haystack, String needle) {
            int m = needle.length();
            int n = haystack.length();
            for (int i = 0; i < n - m + 1; ++i) {
                int j = 0;
                for (; j < m; ++j) {
                    if (haystack.charAt(i + j) != needle.charAt(j)) break;
                }
                if (j == m) return i;
            }
            return -1;
        }
    }

    // KMP算法

}
