package cn.edu.seu.mytest;

import java.util.Scanner;

/**
 * Created by Administrator on 2017/8/11.
 */
public class TestRedix {
    public static void main(String[] args) {
//        int i = 20;
//        String str = Integer.toBinaryString(i);
//        String str1 = Integer.toOctalString(i);
//        String str2 = Integer.toHexString(i);
//        System.out.println("二进制:" + str);
//        System.out.println("八进制:" + str1);
//        System.out.println("十六进制:" + str2);
//        System.out.println(Integer.valueOf("A", 16).toString());
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str16 = scanner.next();
            str16 = str16.substring(2, str16.length());
            System.out.println(Integer.valueOf(str16, 16));
        }
        scanner.close();
    }
}
