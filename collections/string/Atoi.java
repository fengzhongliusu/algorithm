package collections.string;

import java.util.*;

/**
 *  String to Int.
 *  考虑点:
 *  1) null或"".
 *  2) + -, 以及只有+ -.
 *  3) 包含非数字字符.
 *  4) 溢出.
 */
public class Atoi {
    public static void main(String[] args) throws Exception {
        int a = atoi("-2147483648");
        List<int[]> list = new ArrayList<>();
        list.add(new int[] {a, 1});
        for (int[] e : list)
            System.out.println(e[0]);
        System.out.println("asdf".compareTo("Asd"));
    }

    public static int atoi(String s) throws Exception {
        if (s == null || s.length() == 0) {
            throw new Exception("illegal number input");
        }
        final int MAX_DIV = Integer.MAX_VALUE / 10;
        final int MIN_DIV = -(Integer.MIN_VALUE / 10);
        final int MAX_M = Integer.MAX_VALUE % 10;
        final int MIN_M = -(Integer.MIN_VALUE % 10);
        int result = 0;
        int i = 0, len = s.length();
        int sign = 1;
        int digit = s.charAt(0);            //当前字符

        if (digit == '-' || digit == '+') {
            if (digit == '-') {
                sign = -1;
            }
            if (len == 1) {
                throw new Exception("illegal number input");
            }
            i++;
        }

        while (i < len) {
            digit = s.charAt(i++) - '0';
            if (digit >= 0 && digit <= 9) {
                if (sign > 0 && (result > MAX_DIV || (result == MAX_DIV && digit > MAX_M))) { // 正数溢出
                    throw new Exception("number overflow");
                } else if (sign < 0 && (result > MIN_DIV || (result == MIN_DIV && digit > MIN_M))) { //负数溢出
                    throw new Exception("number overflow");
                }
                result = result * 10 + digit;
            } else {
                throw new Exception("illegal number input");
            }
        }
        return sign > 0 ? result : -result;
    }
}
