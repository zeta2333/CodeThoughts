package pycro.usts.chapter05_hash_table;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Pycro
 * @version 1.0
 * 2023-05-19 5:09 PM
 */
public class ThreeSum {
    // 排序+双指针
    class Solution1 {
        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> ans = new ArrayList<>();
            int n = nums.length;
            for (int first = 0; first < n; ++first) {
                if (first > 0 && nums[first] == nums[first - 1]) continue; // 重复则跳过

                int third = n - 1;
                int target = -nums[first];

                for (int second = first + 1; second < n; ++second) {
                    if (second > first + 1 && nums[second] == nums[second - 1]) continue; // 重复则跳过

                    while (second < third && nums[second] + nums[third] > target) --third; // 大于0则右侧往左

                    if (second == third) break; // 相等时跳出循环

                    if (nums[second] + nums[third] == target) {
                        ans.add(Arrays.asList(nums[first], nums[second], nums[third]));
                    }
                }
            }
            return ans;
        }
    }
}
