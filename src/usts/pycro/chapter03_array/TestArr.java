package usts.pycro.chapter03_array;

/**
 * @author Pycro
 * @version 1.0
 * 2023-05-08 12:01 PM
 */
public class TestArr {
    public static void main(String[] args) {
        int[][] arr = new int[4][4];
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
            /*
            输出结果：
            [I@4eec7777
            [I@3b07d329
            [I@41629346
            [I@404b9385
            由此可见，Java中二维数组在内存中不是连续存储的
             */
        }
    }
}
