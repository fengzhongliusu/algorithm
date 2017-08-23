package collections.string;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by cshuo on 2017/8/14
 * 左旋字符串的前k位;
 * 通过三次reverse操作来完成.
 */
public class LeftRotate {
    public static void main(String[] args) {
        String s = "abcdef";
        char[] str = s.toCharArray();
        rotate(str, 2);
        for(char c: str) System.out.print(c);
    }

    public static void rotate(char[] str, int k) {
        if(k < 1) return;
        reverse(str, 0, k-1);
        reverse(str, k, str.length-1);
        reverse(str, 0, str.length-1);
    }

    public static void reverse(char[] str, int l, int r) {
        char tmp;
        while(l < r)  {
            tmp = str[l];
            str[l] = str[r];
            str[r] = tmp;
            l++; r--;
        }
    }
}
