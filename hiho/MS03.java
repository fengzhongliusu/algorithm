package hiho;

import java.util.Scanner;

/**
 * author: cshuo
 * date: 2017/7/19
 * version: 1.0
 * description:
 */
public class MS03 {
    private static int totalSwap;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numCase = in.nextInt();
        String[] strs = new String[numCase];
        String[] dests = new String[numCase];

        for(int i=0; i<numCase; i++) {
            String src = in.next();
            String dest = in.next();
            if(src.length() < 2){
                System.out.println(0);
                continue;
            }
            System.out.println(minSwap(src, dest, 0));
        }

        in.close();
    }

    public static int minSwap(String src, String dest, int curse) {
        if(curse == src.length() - 2){
            return 1;
        }
        while(src.charAt(curse) == dest.charAt(curse)) curse++;
        if(curse >= src.length() - 1) return 1;

        char s = src.charAt(curse);
        int dIndex = dest.indexOf(s);
        int secondIndex = dest.indexOf(s, dIndex + 1);

        if(secondIndex < 0) {
            src = swap(src, curse, dIndex);
            curse++;
            return minSwap(src, dest, curse) + 1;
        } else {
            String src1 = swap(src, curse, dIndex);
            String src2 = swap(src, curse, secondIndex);
            curse++;
            return Math.min(minSwap(src1, dest, curse), minSwap(src2, dest, curse)) + 1;
        }
    }

    public static String swap(String s, int idx1, int idx2) {
        char[] c = s.toCharArray();
        char tmp = c[idx1];
        c[idx1] = c[idx2];
        c[idx2] = tmp;
        return new String(c);
    }
}
