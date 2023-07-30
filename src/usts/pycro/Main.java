package usts.pycro;

/**
 * @author Pycro
 * @version 1.0
 * 2023-05-21 6:05 PM
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(digitSum(1));
    }

    public static int digitSum(int num) {
        int res = 0;
        while (num > 0) {
            res += num % 10;
            num /= 10;
        }
        return res;
    }
}

