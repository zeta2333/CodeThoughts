package pycro.usts.chapter06_string;

/**
 * @author Pycro
 * @version 1.0
 * 2023-06-03 11:08 PM
 */
public class Reverse {
    public static void main(String[] args) {
        String s = "a good   example";
        System.out.println(Solution1.reverseWords(s));
    }

    // 拆分，反转，合并
    class Solution1 {
        public static String reverseWords(String s) {
            // 去除首位空格，并按照一个或多个空格分成多个单词
            String[] words = s.strip().split("\\s+");
            int i = 0;
            int j = words.length - 1;
            while (i < j) {
                String temp = words[i];
                words[i] = words[j];
                words[j] = temp;
                ++i;
                --j;
            }
            return String.join(" ", words);
        }
    }
}
