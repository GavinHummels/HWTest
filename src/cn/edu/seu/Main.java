package cn.edu.seu;

import java.util.*;

public class Main {

    private static List<String> permList = new ArrayList<>();

    private static List<int[]> permIntList = new ArrayList<>();

    private static boolean isLegal(int[] in, int[] out, int n) {
        LinkedList<Integer> stack = new LinkedList<Integer>();
        int i = 0;
        int j = 0;
        while (i < n) { // in 还有元素的时候都需要判断
            if (in[i] == out[j]) { //  相等时候就不用入栈，直接后移
                i++;
                j++;
            } else {
                if (stack.isEmpty()) { //空stack 就只有入栈了
                    stack.push(in[i]);
                    i++;
                } else {
                    int top = stack.peek(); // 栈顶元素相等，进行出栈
                    if (top == out[j]) {
                        j++;
                        stack.pop();
                    } else if (i < n) { //  不等时候入栈
                        stack.push(in[i]);
                        i++;
                    }
                }
            }
        }
        while (!stack.isEmpty() && j < n) { // in 的结束后，栈中元素进程出栈序列应该和out剩余的元素 相同
            int top = stack.pop();
            if (top == out[j]) {
                j++;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void permtest(String prefix, String source) {
        if (source.length() == 0) {
            permList.add(prefix);
        } else {
            for (int i = 0; i < source.length(); i++) {
                String prefixTemp = prefix + source.charAt(i);
                String sourceTemp = source.substring(0, i) + source.substring(i + 1, source.length());
                permtest(prefixTemp, sourceTemp);
            }
        }
    }

    public static void main(String[] args) {
//        permtest("", "abcd");
//        System.out.println(permList.size());
//        for (String str : permList) {
//            System.out.println(str);
//        }

        int[] source = {1, 2, 3, 4};
        permtest(source, 0, 4);
//        System.out.println(permIntList.size());
//        for (int[] ints : permIntList) {
//            for(int i:ints){
//                System.out.print(i);
//            }
//            System.out.print("\n");
//        }
    }

    public static void permtest(int[] result, int start, int n) {
        if (start == n) {
            return;
        }
        if (start == n - 1) {
            int[] temp = result.clone();
            permIntList.add(temp);
            for(int i:temp){
                System.out.print(i);
            }
            System.out.print("\n");
            return;
        }
        for (int i = start; i < n; i++) {
            swap(result, start, i);
            permtest(result, start + 1, n);
            swap(result, start, i);
        }
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void validStack(int[] input,int[] output) {
        Stack<Integer> stack = new Stack<>();

        stack.size();
    }

}
