package cn.edu.seu.mytest;

import java.util.Scanner;

/**
 * Created by Administrator on 2017/8/9.
 */
public class TestCharNum {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String input = scanner.next();
            String key = scanner.next();
            System.out.println(countCharNumber(input, key));
        }
        scanner.close();
    }

    public static int countCharNumber(String str, String key) {
        int count = 0;
        str = str.toLowerCase();
        key = key.toLowerCase();
        char[] chars = str.toCharArray();
        char ch = key.charAt(0);
        for (char c : chars) {
            if (c == ch) {
                count++;
            }
        }
        return count;
    }

    public static char toLow(char ch) {
        if ('A' <= ch && ch <= 'Z') {
            ch = (char) (ch - 'A' + 'a');
        }
        return ch;
    }
}
