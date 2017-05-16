package hiho;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 出勤记录2
 */
public class Hiho3_2 {
    private static final int base = (int)Math.pow(10, 9) + 7;
    public static int numOK(int len){
        ArrayList<int[]> bitNum;
        bitNum = new ArrayList<>();
        if(len < 1) return 0;
        if(len == 1) return 3;

        bitNum.add(new int[]{1,1,0,1,0,0});

        int[] tmp;
        for(int i=1; i<len; i++){
            tmp = bitNum.get(i-1);
            bitNum.add(new int[]{
                    addN(tmp, 0, 2),
                    tmp[0],
                    tmp[1],
                    addN(tmp, 0, 5),
                    tmp[3],
                    tmp[4]
            });
        }
        int[] res = bitNum.get(len-1);

        int sum = 0;
        for(int e: res){
            sum = (sum +e)%base;
        }
        return sum;
    }

    public static int addN(int[]nums, int bg, int end){
        int sum =0;
        for(int i = bg; i<end+1; i++){
            sum = (sum + nums[i]) % base;
        }
        return sum;
    }

    public static void main(String[] args) {
        int len;
        Scanner sc = new Scanner(System.in);
        len = sc.nextInt();
        System.out.println(numOK(len));
    }
}
