package cn.edu.seu.mytest;

/**
 * Created by Administrator on 2017/8/10.
 */
public class TestPermWithRepeat {
    static int count = 0;

    public static void main(String[] args) {
        String s2 = "1232";
        int t = 1 & 0;
        System.out.println(t);

        int[] index = new int[s2.length()];
        for (int i = 0; i < s2.length(); i++) {
            index[i] = s2.indexOf(s2.charAt(i));
        }
        pailie(s2, "");
        System.out.println("Total:" + count);
    }

    static void pailie(String s, String p) {
        if (s.length() < 1) {
            System.out.println(p);
            count++;
        } else {
            int index[] = new int[s.length()];

            //该循环将所有的字符第一次出现的位置记录在数组
            for (int i = 0; i < s.length(); i++) {
                index[i] = s.indexOf(s.charAt(i));
            }
            for (int i = 0; i < s.length(); i++) {
                if (i == index[i]) {
                    pailie(s.substring(1), p + s.substring(0, 1));
                }
                s = s.substring(1) + s.substring(0, 1);
            }
        }
    }
}
