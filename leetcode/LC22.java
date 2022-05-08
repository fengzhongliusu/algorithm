package leetcode;

import java.util.*;

/**
 * author: cshuo
 * date: 2017/4/3
 * version: 1.0
 * description:
 */
public class LC22 {
    public static void main(String[] args) {
        System.out.println(convert(1010001000));
    }
    public static List<String> generateParenthesis(int n) {
        List<String> l = new ArrayList<>();
        traverse(l, "", 0, 0, n);
        return l;
    }
    public static void traverse(List<String>l, String s, int lnum, int rnum, int n){
        if(lnum == n && rnum == n){
            l.add(s);
            return;
        }
        if(lnum < n){
            traverse(l, s+'(', lnum+1, rnum, n);
        }
        if(rnum < lnum){
            traverse(l, s+')', lnum, rnum+1, n);
        }
    }


    private static String[] map = new String[] {"零", "一","二","三","四","五","六","七","八","九"};

    public static String convert(long val) {
        StringBuilder sb = new StringBuilder();
        // 亿
        int num = (int) val / 100000000;
        if (num > 0) sb.append(helper(num)).append("亿");
        System.out.println(sb.toString());
        // 万
        num = (int) (val % 100000000) / 10000;
        if (num > 0) sb.append(helper(num)).append("万");
        System.out.println(sb.toString());
        // left..
        num = (int) val % 10000;
        if (num > 0) sb.append(helper(num));
        System.out.println(sb.toString());

        return sb.toString();
    }

    private static String helper(int val) {
        StringBuilder sb = new StringBuilder();
        boolean encounterZero = false;
        boolean stashZero = false;
        int thousand = val / 1000;
        if (thousand > 0) {
            sb.append(map[thousand]).append("千");
        } else {
            encounterZero = true;
        }
        int h = (val % 1000) / 100;
        if (h > 0) {
            sb.append(map[h]).append("百");
            encounterZero = false;
        } else if (!encounterZero) {
            encounterZero = true;
            stashZero = true;
        }
        int s = (val % 100) / 10;
        if (s > 0) {
            sb.append(map[s]).append("十");
            if (stashZero) sb.append("零");
        } else if (!encounterZero) {
            stashZero = true;
        }
        s = val % 10;
        if (s > 0) {
            if (stashZero) sb.append("零");
            sb.append(map[s]);
        }
        return sb.toString();
    }

}
