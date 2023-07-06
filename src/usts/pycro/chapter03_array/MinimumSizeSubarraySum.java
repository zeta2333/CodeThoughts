package usts.pycro.chapter03_array;

/**
 * @author Pycro
 * @version 1.0
 * 2023-05-08 10:35 PM
 * Leetcode：209
 */
public class MinimumSizeSubarraySum {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 2, 4, 3};
        int i = Solution1.minSubArrayLen(7, nums);
        System.out.println(i);
    }

    // 暴力解法：两层for循环 O(n^2)   ---- 超出时间限制
    class Solution1 {
        public static int minSubArrayLen(int target, int[] nums) {
            // 对于每一个位置的元素，都以其为首元素向后寻找最小长度且总和满足条件的子数组
            // 最后求出最小长度
            int result = Integer.MAX_VALUE;
            for (int i = 0; i < nums.length; i++) {
                int sum = 0;
                for (int j = i; j < nums.length; j++) {
                    sum += nums[j];
                    if (sum >= target) {
                        int subLen = j - i + 1;
                        result = subLen < result ? subLen : result;
                        break;
                    }
                }
            }
            // result未被赋值表示没有满足条件的子数组，则返回0
            return result == Integer.MAX_VALUE ? result : 0;
        }
    }

    class Solution2 {
        // 滑动窗口：寻找每个索引为结尾的满足条件的子数组  O(n)
        public int minSubArrayLen(int target, int[] nums) {
            int result = Integer.MAX_VALUE;
            int sum = 0;//滑动窗口的数值之和
            int i = 0;// 滑动窗口的起始位置
            int subLen = 0;// 子数组的长度
            for (int j = 0; j < nums.length; j++) {
                sum += nums[j];
                // 一般情况下，由于子数组长度有限，此处的while循环的时间复杂度为O(1)
                while (sum >= target) {
                    subLen = j - i + 1;
                    result = subLen < result ? subLen : result;
                    sum -= nums[i++];// 起始位置后移，同时sum减少
                }
            }
            return result == Integer.MAX_VALUE ? 0 : result;
        }
    }

    class Solution3 {
        // 滑动窗口：寻找每个索引为首的满足条件的子数组  O(n)
        public int minSubArrayLen(int target, int[] nums) {
            int result = Integer.MAX_VALUE;
            int sum = 0;//滑动窗口的数值之和
            int j = nums.length - 1;// 滑动窗口的结束位置
            int subLen = 0;// 子数组的长度
            for (int i = nums.length - 1; i >= 0; i--) {
                sum += nums[i];
                while (sum >= target) {
                    subLen = j - i + 1;
                    result = subLen < result ? subLen : result;
                    sum -= nums[j--];// 结束位置前移，同时sum减少
                }
            }
            return result == Integer.MAX_VALUE ? 0 : result;
        }
    }
}

