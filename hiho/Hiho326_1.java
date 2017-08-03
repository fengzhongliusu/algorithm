package hiho;

import java.util.*;

/**
 * author: cshuo
 * date: 2017/3/26
 * version: 1.0
 * description: find the shortest substr containing 'h','h','i','o' from a string.
 */

public class Hiho326_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str;
        str = sc.next();
        sc.close();
        if(str.length() < 4){
            System.out.println(-1);
            return;
        }

        List<Integer> cost = new ArrayList<>();
        List<Character> subStr = new ArrayList<>();

        int pre = -1;
        char tmp;
        for(int i=str.length()-1; i>=0; i--){
            tmp = str.charAt(i);
            if(tmp == 'h' || tmp == 'i' || tmp == 'o'){
                subStr.add(0, tmp);
                if(pre == -1) cost.add(0, 1);
                else cost.add(0, pre - i);
                pre = i;
            }
        }

        int min_cost = Integer.MAX_VALUE, tmp_sum;
        for(int i=0; i<=subStr.size()-4; i++){
            if(isHiho(subStr, i, i+3)){
                tmp_sum = getCost(cost, i, i+3);
                if(tmp_sum < min_cost) min_cost = tmp_sum;
            }
        }
        if(min_cost == Integer.MAX_VALUE)
            System.out.println(-1);
        else
            System.out.println(min_cost);
    }

    public static int getCost(List<Integer> cost, int l, int r){
        int sum =0;
        for(int i=l; i<r; i++)
            sum += cost.get(i);
        sum += 1;
        return sum;
    }

    public static boolean isHiho(List<Character> str, int l, int r){
        int[] sign = new int[]{2, 1, 1};
        for(int i =l; i<=r; i++){
            if(str.get(i) == 'h') sign[0]--;
            else if(str.get(i) == 'i') sign[1]--;
            else if(str.get(i) == 'o') sign[2]--;
        }
        return sign[0] == 0 && sign[1] == 0 && sign[2] == 0;
    }
}
