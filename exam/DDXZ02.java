package exam;

import java.util.Scanner;

/**
 * Created by cshuo on 2017/9/10
 */
public class DDXZ02 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            int N = in.nextInt();
            System.out.println(getUglyNum(N));
        }
        in.close();
    }

    public static int getUglyNum(int index){
        if(index < 1) return 0;
        int[] uglyNum = new int[index];
        int pMulti2 = 0, pMulti3 = 0, pMulti5 = 0, nextPos=1;
        uglyNum[0] = 1;
        while(nextPos < index){
            uglyNum[nextPos] = Math.min(Math.min(uglyNum[pMulti2] * 2, uglyNum[pMulti3] * 3), uglyNum[pMulti5]*5);
            while(uglyNum[pMulti2] * 2 <= uglyNum[nextPos]) pMulti2++;
            while(uglyNum[pMulti3] * 3 <= uglyNum[nextPos]) pMulti3++;
            while(uglyNum[pMulti5] * 5 <= uglyNum[nextPos]) pMulti5++;
            nextPos++;
        }
        return uglyNum[nextPos-1];
    }
}
