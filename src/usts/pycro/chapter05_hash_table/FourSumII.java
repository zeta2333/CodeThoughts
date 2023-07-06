package usts.pycro.chapter05_hash_table;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Pycro
 * @version 1.0
 * 2023-05-19 4:38 PM
 * Leetcode：454
 */
public class FourSumII {
    public static void main(String[] args) {

    }
    // 暴力循环(超时)：O(n^4)
    class Solution0 {
        public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
            int n = nums1.length;
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < n; k++) {
                        for (int l = 0; l < n; l++) {
                            if (nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0) cnt++;
                        }
                    }
                }
            }
            return cnt;
        }
    }

    // 分治+哈希表：O(n^2)
    class Solution1 {
        public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
            int n = nums1.length;
            int cnt = 0;// 返回结果
            // 分治：A、B为一组，C、D为一组
            // 计算A、B中所有元素组合可能的和，并计算每种和出现的次数
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int curSum = nums1[i] + nums2[j];
                    map.put(curSum, map.getOrDefault(curSum, 0) + 1);
                }
            }
            // 计算C、D中所有元素组合可能的和，如果和map中的某个值匹配，则计入cnt
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int curSum = nums3[i] + nums4[j];
                    int target = -curSum;
                    if (map.containsKey(target)) {
                        cnt += map.get(target);
                    }
                }
            }
            return cnt;
        }
    }

    // 更优雅的写法
    class Solution2 {
        public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
            Map<Integer, Integer> mapAB = new HashMap<>();
            for (int a : A) {
                for (int b : B) {
                    int sum = a + b;
                    mapAB.put(sum, mapAB.getOrDefault(sum, 0) + 1);
                }
            }
            int count = 0;
            for (int c : C) {
                for (int d : D) {
                    int sum = c + d;
                    count += mapAB.getOrDefault(-sum, 0);
                }
            }
            return count;
        }
    }
}
