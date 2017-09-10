package cn.edu.seu.mytest;

import java.util.Scanner;

/**
 * Created by Administrator on 2017/8/11.
 */
public class TestStringDivision {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            StringBuilder sb = new StringBuilder();
            String input = scanner.next();
            sb.append(doStringDivision(input));
            input = scanner.next();
            sb.append(doStringDivision(input));
            System.out.println(sb.toString());
        }
        scanner.close();
    }

    public static String doStringDivision(String str) {
        StringBuilder sb = new StringBuilder();
        if (str == null || str.length() == 0) {
            return sb.toString();
        }
        while (str.length() > 8) {
            sb.append(str.substring(0, 8)).append("\n");
            str = str.substring(8, str.length());
        }
        if (str.length() <= 8) {
            sb.append(str);
            for (int i = 0; i < 8 - str.length(); i++) {
                sb.append("0");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
