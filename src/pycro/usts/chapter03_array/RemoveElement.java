package pycro.usts.chapter03_array;

/**
 * @author Pycro
 * @version 1.0
 * 2023-05-08 9:55 PM
 */
public class RemoveElement {
    // 思路：遇到不等于val的元素就放置到前面，直接从前往后覆盖，相当于直接无视掉val值元素  O(n)
    // 等同于双指针(快慢指针)法
    class Solution1 {
        public int removeElement(int[] nums, int val) {
            int cnt = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != val) {
                    nums[cnt++] = nums[i];
                }
            }
            return cnt;
        }
    }

    // 暴力解法，两层for循环模拟删除元素   O(n^2)
    class Solution2 {
        public int removeElement(int[] nums, int val) {
            int size = nums.length;// size表示新数组的长度
            for (int i = 0; i < size; i++) { // size是不断变化的
                if (nums[i] == val) {
                    // 移除元素
                    for (int j = i; j < size - 1; j++) {
                        nums[j] = nums[j + 1];
                    }
                    i--;// 删除之后i自减，继续比较原来索引处的新元素是否为val(应对相邻两个元素都是val的情况)
                    size--;// 删除之后size自减
                }
            }
            return size;
        }
    }
}
