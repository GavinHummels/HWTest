package cn.edu.seu;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class Main {

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

}
