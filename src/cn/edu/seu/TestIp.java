package cn.edu.seu;


import java.util.Scanner;

/**
 * Created by wjy on 2017/7/5.
 * 题目描述
 子网掩码是用来判断任意两台计算机的IP地址是否属于同一子网络的根据。
 子网掩码与IP地址结构相同，是32位二进制数，其中网络号部分全为“1”和主机号部分全为“0”。利用子网掩码可以判断两台主机是否中同一子网中。若两台主机的IP地址分别与它们的子网掩码相“与”后的结果相同，则说明这两台主机在同一子网中。
 示例：
 I P 地址　 192.168.0.1
 子网掩码　 255.255.255.0
 转化为二进制进行运算：
 I P 地址　11010000.10101000.00000000.00000001
 子网掩码　11111111.11111111.11111111.00000000
 AND运算
 　　　　11000000.10101000.00000000.00000000
 转化为十进制后为：
 　　　　192.168.0.0

 I P 地址　 192.168.0.254
 子网掩码　 255.255.255.0

 转化为二进制进行运算：
 I P 地址　11010000.10101000.00000000.11111110
 子网掩码　11111111.11111111.11111111.00000000
 AND运算
 　　　　　11000000.10101000.00000000.00000000
 转化为十进制后为：
 　　　　　192.168.0.0
 通过以上对两台计算机IP地址与子网掩码的AND运算后，我们可以看到它运算结果是一样的。均为192.168.0.0，所以这二台计算机可视为是同一子网络。
 输入描述:
 输入子网掩码、两个ip地址
 输出描述:
 得到计算结果
 输入例子:
 255.255.255.0
 192.168.224.256
 192.168.10.4
 输出例子:
 1
 *
 */
public class TestIp {
    public static void main(String[] s) {
        Scanner sc = new Scanner(System.in);
        String[] strs = new String[3];
        int i=0;
        while (sc.hasNextLine()){
            strs[i] = sc.nextLine();
            i++;
            if(i>2){
                break;
            }
        }
        System.out.println(checkNetSegment(strs[0], strs[1], strs[2]));
    }

    public static int checkNetSegment(String mask, String ip1, String ip2) {
        String[] strs = mask.split("\\.");
        if (strs.length != 4) {
            return 1;
        }
        int[] masks = new int[4];
        try {
            for (int i = 0; i < strs.length; i++) {
                masks[i] = Integer.parseInt(strs[i]);
                if (masks[i] != 255 && masks[i] != 0) {
                    return 1;
                }
            }
        } catch (Exception e) {
            return 1;
        }
        String[] strs1 = ip1.split("\\.");
        if (strs1.length != 4) {
            return 1;
        }
        int[] ip1s = new int[4];
        try {
            for (int i = 0; i < strs1.length; i++) {
                ip1s[i] = Integer.parseInt(strs1[i]);
                if (ip1s[i] > 255 || ip1s[i] < 0) {
                    return 1;
                }
            }
        } catch (Exception e) {
            return 1;
        }
        String[] strs2 = ip2.split("\\.");
        if (strs2.length != 4) {
            return 1;
        }
        int[] ip2s = new int[4];
        try {
            for (int i = 0; i < strs2.length; i++) {
                ip2s[i] = Integer.parseInt(strs2[i]);
                if (ip2s[i] > 255 || ip2s[i] < 0) {
                    return 1;
                }
            }
        } catch (Exception e) {
            return 1;
        }
        int[] result1 = new int[4];
        for (int i = 0; i < masks.length; i++) {
            result1[i] = masks[i] & ip1s[i];
        }
        int[] result2 = new int[4];
        for (int i = 0; i < masks.length; i++) {
            result2[i] = masks[i] & ip2s[i];
        }
        for (int i = 0; i < result1.length; i++) {
            if (result1[i] != result2[i]) {
                return 2;
            }
        }
        return 0;
    }

    public static int add(int x, int y) {
        if (y == 0) return x;
        int sum, carry;
        sum = x ^ y;
        carry = (x & y) << 1;
        return add(sum, carry);
    }
}
