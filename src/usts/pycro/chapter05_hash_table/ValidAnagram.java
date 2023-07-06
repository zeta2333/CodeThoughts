package usts.pycro.chapter05_hash_table;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Pycro
 * @version 1.0
 * 2023-05-18 7:41 PM
 * Leetcode：242
 */
public class ValidAnagram {
    // 解法1：数组判断
    class Solution1 {
        public boolean isAnagram(String s, String t) {
            // 数组
            int[] arr = new int[26];
            int n = s.length();
            if (t.length() != n) return false;
            for (int i = 0; i < n; i++) {
                char ch = s.charAt(i);
                arr[ch - 'a']++;
            }
            for (int i = 0; i < n; i++) {
                char ch = t.charAt(i);
                if (arr[ch - 'a'] == 0) {
                    return false;
                }
                arr[ch - 'a']--;
            }
            return true;
        }
    }
    // 解法2：哈希表，可以处理任何Unicode字符
    class Solution2 {
        public boolean isAnagram(String s, String t) {
            Map<Character,Integer> map = new HashMap<>();
            int n = s.length();
            if (n != t.length()) return false;
            for (int i = 0; i < n; i++){
                char ch = s.charAt(i);
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }
            for (int i = 0; i < n; i++){
                char ch = t.charAt(i);
                if (map.getOrDefault(ch, 0) == 0) return false;
                map.put(ch, map.getOrDefault(ch, 0) - 1);
            }
            return true;
        }
    }
}

