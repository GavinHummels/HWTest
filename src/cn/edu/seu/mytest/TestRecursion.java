package cn.edu.seu.mytest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2017/8/8.
 */
public class TestRecursion {
    public static void main(String[] args) {
        String[] array = new String[]{
                "1", "2", "3", "4"
        };
        listAll(Arrays.asList(array), "");
    }

    public static void listAll(List<String> candidate, String prefix) {
        if (candidate.isEmpty()) {
            System.out.println(prefix);
        }
        for (int i = 0; i < candidate.size(); i++) {
            List<String> temp = new ArrayList<>(candidate);
            listAll(temp, prefix + temp.remove(i));
        }
    }
}
