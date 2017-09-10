package cn.edu.seu.mytest;

import java.util.Scanner;

/**
 * Created by Administrator on 2017/9/10.
 */
public class TestCountOnes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int input = scanner.nextInt();
            System.out.println(countOnes(input));
        }
        scanner.close();
    }

    private static int countOnes(int input) {
        int result = 0;
        while (input != 0) {
            result += input & 1;//与1并，结果为1则有1，为0则没有
            input >>>= 1;
        }
        return result;
    }
}
