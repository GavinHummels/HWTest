package cn.edu.seu.mytest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * Created by Administrator on 2017/8/10.
 */
public class TestRecursionAndSort {

    public static void main(String[] args) {
        String input = "aavzcadfdsfsdhadfadfadfadfdfggherghth";
        doString(input);
    }

    public static void doString(String input) {
        char[] chars = input.toCharArray();
        ArrayList lists = new ArrayList();
        TreeSet set = new TreeSet();
        for (int i = 0; i < chars.length; i++) {
            lists.add(String.valueOf(chars[i]));
            set.add(String.valueOf(chars[i]));
        }
        System.out.println(set);
        System.out.println(lists);
        Collections.sort(lists);
        System.out.println(lists);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < lists.size(); i++) {
            sb.append(lists.get(i));
        }
        input = sb.toString();
        System.out.println(input);
        int max = 0;
        String maxString = "";
        ArrayList maxlist = new ArrayList();

        Iterator<String> its = set.iterator();
        while (its.hasNext()) {
            String os = its.next();
            int begin = input.indexOf(os);
            int end = input.lastIndexOf(os);
            int value = end - begin + 1;
            if (value > max) {
                max = value;
                maxString = os;
                maxlist.add(os);
            } else if (value == max) {
                maxlist.add(os);
            }
        }

        int index = 0;
        for (int i = 0; i < maxlist.size(); i++) {
            if (maxlist.get(i).equals(maxString)) {
                index = i;
                break;
            }
        }
        System.out.print("max data ");
        for (int i = index; i < maxlist.size(); i++) {
            System.out.print(maxlist.get(i) + " ");
        }
        System.out.println();
        System.out.println("max" + max);
    }
}
