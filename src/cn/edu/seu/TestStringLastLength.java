package cn.edu.seu;

import java.util.Scanner;

/**
 * Created by wjy on 2017/7/5.
 *
 * 计算字符串最后一个单词的长度，单词以空格隔开。
 输入描述:
 一行字符串。
 输出描述:
 整数N，最后一个单词的长度。
 输入例子:
 hello world
 输出例子:
 5
 *
 */
public class TestStringLastLength {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String str = sc.nextLine();
            String[] strs = str.split("\\s+");
            if (strs.length > 0) {
                System.out.println(strs[strs.length - 1].length());
            }
        }
    }
}
