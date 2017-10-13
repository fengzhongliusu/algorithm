package exam;

import java.util.Scanner;

public class NETX01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            int nums = in.nextInt();
            for(int i=0; i<nums; i++) {
                String s = in.next();
                System.out.println(transfer(s));
            }
        }
    }
    public static String transfer(String str) {
        String[] strs = str.split(":");
        char[] cs = str.toCharArray();
        int h = Integer.parseInt(strs[0]);
        int m = Integer.parseInt(strs[1]);
        int s = Integer.parseInt(strs[2]);
        if(h>=0 && h <24 && m>=0 && m<60 && s>=0 && s<60) return str;
        if(h > 23) {
            cs[0] = '0';
        }
        if(m > 59) {
            cs[3] = '0';
        }
        if(s > 59) {
            cs[6] = '0';
        }
        return new String(cs);
    }
}
