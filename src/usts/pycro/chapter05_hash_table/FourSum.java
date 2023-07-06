package usts.pycro.chapter05_hash_table;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Pycro
 * @version 1.0
 * 2023-06-03 9:20 PM
 * Leetcode：18
 */
public class FourSum {
    // 排序 + 三指针
    class Solution1 {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            int n = nums.length;
            Arrays.sort(nums);
            List<List<Integer>> res = new ArrayList<>();
            for (int i = 0; i < n; ++i) {
                // 去重
                if (i > 0 && nums[i] == nums[i - 1]) continue;
                for (int j = i + 1; j < n; ++j) {
                    // 去重
                    if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                    long diff = (long) target - nums[i] - nums[j];
                    int m = n - 1;
                    for (int k = j + 1; k < n; k++) {
                        // 去重
                        if (k > j + 1 && nums[k] == nums[k - 1]) continue;
                        while (k < m && (long) nums[k] + nums[m] > diff) m--;
                        if (k == m) break;
                        if ((long) nums[k] + nums[m] == diff) {
                            res.add(Arrays.asList(nums[i], nums[j], nums[k], nums[m]));
                        }
                    }
                }
            }
            return res;
        }
    }
}
