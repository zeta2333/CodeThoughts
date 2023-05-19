package pycro.usts.chapter05_hash_table;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Pycro
 * @version 1.0
 * 2023-05-19 4:13 PM
 * Leetcode：1
 */
public class TwoSum {
    // 解法1：遍历两次，O(n^2)
    class Solution1 {
        public int[] twoSum(int[] nums, int target) {
            // 遍历两次：
            int n = nums.length;
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (nums[i] + nums[j] == target) {
                        return new int[]{i, j};
                    }
                }
            }
            return null;
        }
    }

    // 解法2：哈希表，O(n)
    // 后面的数，匹配到了之前加进哈希表中的数
    class Solution2 {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                int delta = target - nums[i];
                if (map.containsKey(delta)) {
                    return new int[]{map.get(delta), i};
                } else {
                    map.put(nums[i], i);
                }
            }
            throw new IllegalArgumentException("No two sum solution");
        }
    }
}
