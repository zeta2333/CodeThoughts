package pycro.usts.chapter02_performance_analysis;

import pycro.usts.util.FuncUtil;

/**
 * @author Pycro
 * @version 1.0
 * 2023-05-08 11:19 AM
 */
public class Fibonacci {
    public static void main(String[] args) {
        //FuncUtil.timeConsumer(Fibonacci::fib1, 50);//该方法耗时：0.328s
        FuncUtil.timeConsumer(Fibonacci::testArgs, new int[]{1, 1, 12000});
        /* long start = System.currentTimeMillis();
        System.out.print(fib2(1, 1, 40));
        long end = System.currentTimeMillis();
        System.out.printf("该方法耗时：%.3fs\n", (double) (end - start) / 1000); */
    }

    static void testArgs(int[] args) {
        System.out.println(fib2(args[0], args[1], args[2]));
    }

    static int fib1(int n) {//O(n^2)
        if (n <= 0) return 0;
        if (n == 1) return 1;
        return fib1(n - 1) + fib1(n - 2);
    }

    static int fib2(int first, int second, int n) {//O(n)
        if (n <= 0) return 0;
        if (n < 3) return 1;
        else if (n == 3) return first + second;
        else return fib2(second, first + second, n - 1);
    }
}
