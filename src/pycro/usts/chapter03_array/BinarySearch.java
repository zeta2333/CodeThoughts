package pycro.usts.chapter03_array;

/**
 * @author Pycro
 * @version 1.0
 * 2023-05-08 3:10 PM
 * Leetcode：704
 */
public class BinarySearch {
    class Solution1 {
        public int search(int[] nums, int target) {
            //版本一：定义target在一个左闭右闭的区间内，即[left,right]，
            // 此时right初始值为数组最大下标：nums.length-1
            int left = 0;
            int right = nums.length - 1;
            int middle;
            while (left <= right) { //此时需要写left <= right,因为当left==right时，区间内也存在一个值
                middle = left + (right - left) / 2;
                if (nums[middle] == target) return middle;
                else if (nums[middle] > target) right = middle - 1;
                else left = middle + 1;
            }
            return -1;
        }
    }

    class Solution2 {
        // 版本二：左闭右开区间,[left, right),
        // 此时right初始值为数组长度：nums.length
        public int search(int[] nums, int target) {
            int left = 0;
            int right = nums.length;
            while (left < right) {//由于left==right时，区间内没有值，所以只需要"<"
                int middle = left + (right - left) / 2;
                if (nums[middle] > target) right = middle;
                else if (nums[middle] < target) left = middle + 1;
                else return middle;
            }
            return -1;
        }
    }
}



