package usts.pycro.chapter03_array;

import java.util.Arrays;

/**
 * @author Pycro
 * @version 1.0
 * 2023-05-09 10:48 AM
 * Leetcode：59
 */
public class SpiralMatrix_II {
    public static void main(String[] args) {
        int[][] res = Solution1.generateMatrix(10);
        for (int[] re : res) {
            System.out.println(Arrays.toString(re));
        }
    }

    class Solution1 {
        // 版本一：左开右闭
        public static int[][] generateMatrix(int n) {
            int[][] res = new int[n][n];//声明一个n*n的矩阵
            // 模拟规则：按照右下左上的顺序循环，且步长为[n,n-1,n-1,n-2,n-2,...,2,2,1,1]
            // 即：n出现一次，之后n每次减1，且出现两次
            int i = 0;// 行索引
            int j = 0;// 列索引
            int num = 1;// 当前需要填入的数
            res[0][0] = num;// 填充首位
            for (int k = 0; k < 2 * n - 1; k++) {
                int step = n - (k + 1) / 2;// 每次填充的步长
                if (step == n) step--;
                while (step-- > 0) {// 先移动，再填充
                    switch (k % 4) {
                        case 0 -> j++;
                        case 1 -> i++;
                        case 2 -> j--;
                        case 3 -> i--;
                    }
                    res[i][j] = ++num;
                }
            }
            return res;
        }
    }

    class Solution2 {
        // 版本二：由外到内一圈圈的填充，左闭右开，先填充再移动
        public int[][] generateMatrix(int n) {
            int[][] res = new int[n][n];
            int startX = 0, startY = 0; // 每一个循环圈的起始位置
            int loop = n / 2; // 循环的圈数
            int mid = n / 2; // 矩阵中间的位置
            int num = 1; // 用来给矩阵中的空格赋值
            int curLen = n - 1; // 当前圈的遍历长度
            int i, j;
            while (loop-- > 0) {
                i = startX;
                j = startY;
                // 右
                for (j = startY; j < curLen; j++) {
                    res[i][j] = num++;
                }
                // 下
                for (i = startX; i < curLen; i++) {
                    res[i][j] = num++;
                }
                // 左
                for (; j > startY; j--) {
                    res[i][j] = num++;
                }
                // 上
                for (; i > startX; i--) {
                    res[i][j] = num++;
                }
                // 下一圈开始时，起始位置变化
                startX++;
                startY++;
                // 长度变化
                curLen--;
            }
            // 给最中间的位置赋值
            if (n % 2 == 1) {
                res[mid][mid] = num;
            }
            return res;
        }
    }

    class Solution3 {
        //版本三：设置上下左右四个边界；每次填充完一段，即更新对应的边界
        public int[][] generateMatrix(int n) {
            int l = 0, r = n - 1, t = 0, b = n - 1;
            int[][] mat = new int[n][n];
            int num = 1, tar = n * n;
            while (num <= tar) { //此处也可以写成 l <= r || t <= b
                for (int i = l; i <= r; i++) mat[t][i] = num++; // left to right.
                t++;
                for (int i = t; i <= b; i++) mat[i][r] = num++; // top to bottom.
                r--;
                for (int i = r; i >= l; i--) mat[b][i] = num++; // right to left.
                b--;
                for (int i = b; i >= t; i--) mat[i][l] = num++; // bottom to top.
                l++;
            }
            return mat;
        }
    }
}