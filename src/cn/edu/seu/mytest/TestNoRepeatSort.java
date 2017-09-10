package cn.edu.seu.mytest;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Administrator on 2017/8/10.
 */
public class TestNoRepeatSort {

    public static void main(String[] args) {
//        noRepeatSortWithTreeSet();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = scanner.nextInt();
            }
        }
    }

    public static void noRepeatSortWithArray() {

    }

    public static void noRepeatSortWithTreeSet() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            Set<Integer> numSet = new TreeSet<>();
            for (int i = 0; i < num; i++) {
                numSet.add(scanner.nextInt());
            }
            for (Integer i : numSet) {
                System.out.println(i);
            }
        }

    }


}
