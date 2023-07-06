package usts.pycro.chapter05_hash_table;

import java.util.*;

/**
 * @author Pycro
 * @version 1.0
 * 2023-05-19 5:09 PM
 * Leetcode：15
 */
public class ThreeSum {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3);
    }

    // 排序+双指针
    class Solution1 {
        public List<List<Integer>> threeSum(int[] nums) {
            int n = nums.length;
            Arrays.sort(nums);// 排序(重要)，去重的重要步骤
            List<List<Integer>> res = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                // 与前面元素重复则跳过当次循环
                if (i > 0 && nums[i] == nums[i - 1]) continue;
                int k = n - 1; // 第3个从数组末尾开始往左寻找
                for (int j = i + 1; j < n; j++) {
                    // 与前面元素重复则跳过当次循环
                    if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                    // 当j在k左侧且三数之和大于0时，往左移动k
                    while (j < k && nums[i] + nums[j] + nums[k] > 0) k--;
                    // 如果由于j和k重合而跳出循环，则表示后续没有符合条件的元素，直接终止循环
                    if (j == k) break;
                    // 如果当前三数之和为0，则加入返回数组中
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    }
                }
            }
            return res;
        }
    }
}
