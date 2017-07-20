package exer;

import java.util.*;

/**
 * author: cshuo
 * date: 2017/6/15
 * version: 1.0
 * description:
 */
public class Exercise {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer();
        sb.append("asdf").reverse();
        sb.append(" ");
        System.out.println(sb);
        sb.append("qwer");
        System.out.println(sb);
        sb.setLength(4);
        sb.append("adsf".charAt(1));
        System.out.println(sb);
        System.out.println(sb.length());
        HashMap hm = new HashMap();

        String s = "asmr";
        System.out.println(s.indexOf('m', 3));
    }
}
