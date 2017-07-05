package cn.edu.seu;

import java.util.*;

/**
 * Created by wjy on 2017/7/5.
 *
 * 给出一个名字，该名字有26个字符串组成，定义这个字符串的“漂亮度”是其所有字母“漂亮度”的总和。
  每个字母都有一个“漂亮度”，范围在1到26之间。没有任何两个字母拥有相同的“漂亮度”。字母忽略大小写。
 给出多个名字，计算每个名字最大可能的“漂亮度”。
 测试用例：
 2
 zhangsan
 lisi
 输出：192
 101
 */
public class TestNameBeauty {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i = 0;
        List<String> list = new ArrayList<>();
        while (sc.hasNextLine()) {
            String str = sc.nextLine();
            if (i == 0) {
                if (str.matches("\\d")) {
                    i = Integer.parseInt(str);
                } else {
                    System.out.println("请先输入数字");
                }
            } else {
                if (str.matches("[a-zA-Z]+")) {
                    list.add(str);
                    if (list.size() == i) {
                        break;
                    }
                } else {
                    System.out.println("请输入字母");
                }
            }
        }

        for(String str :list){
            System.out.println(getMaxBeauty(str));
        }

    }

    public static int getMaxBeauty(String str) {
        char[] chars = str.toCharArray();
        Map<String, Integer> map = new HashMap<>();
        for (char c : chars) {
            String key = String.valueOf(c);
            if (map.containsKey(key.toUpperCase()) || map.containsKey(key.toLowerCase())) {
                int num = map.get(key.toUpperCase()) + 1;
                map.put(key.toUpperCase(), num);
            } else {
                map.put(key.toUpperCase(), 1);
            }
        }
        List<Integer> list = new ArrayList<>(map.values());
        Integer[] nums = list.toArray(new Integer[list.size()]);
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > nums[i]) {
                    int tem = nums[j];
                    nums[j] = nums[i];
                    nums[i] = tem;
                }
            }
        }
        int val = 26;
        int total = 0;
        for (Integer i : nums) {
            total = total + i * val;
            val--;
        }
        return total;
    }
}
