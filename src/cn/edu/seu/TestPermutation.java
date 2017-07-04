package cn.edu.seu;

/**
 * Created by wjy on 2017/7/3.
 */
public class TestPermutation {

    public static void main(String[] args) {
        test(3);
    }


    public static void test(int n) {
        String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String elements = alphabet.substring(0, n);
        permutation(elements);
    }

    /**
     * 对String s="abcde"的全排列，递归为（1）前缀为a、s为"bcde"、（2）前缀为b、s为"acde"...的全排列。
     * 直到s.length()为0
     */
    public static void permutation(String str) {
        perm("", str);
    }

    private static void perm(String prefix, String str) {
        int len = str.length();
        if (len == 0)
            System.out.println(prefix);
        else {
            for (int i = 0; i < len; i++)
                perm(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, len));
        }
    }
}
