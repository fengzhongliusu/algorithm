package exam;
import java.util.*;

import exer.Main;

/**
 * author: cshuo
 * date: 2017/4/21
 * version: 1.0
 * description:
 */
public class AliSim {
    static int sum;
    public static void main(String[] args) {
        sum = 0;
        Scanner  in = new Scanner(System.in);
        ArrayList<Integer> nums = new ArrayList<>();
        int tmp;
        while(in.hasNext()){
            tmp = in.nextInt();
            if(tmp == 0){
                System.out.println("get 0");
                break;
            }
            nums.add(tmp);
        }
        System.out.println("hello");
        dfs(nums, 1, 2, 0);
        System.out.println(sum);
    }

    private static void dfs(ArrayList<Integer> l, int level, int position, int length){
        if(level == 4){
            for(int i=0; i<l.size(); i++)
                if(l.get(i) / 100 == 4 && l.get(i)/10%10 + 6 == position){
                    length += l.get(i) %10;
                    sum += length;
                }
        }

        int plus;
        if(level <= 2) plus = 1;
        else if(length == 3) plus = 2;
        else plus = 6;

        for(int i=0; i<l.size(); i++){
            if(l.get(i)/100 == level && l.get(i)/10%10 + plus == position){
                dfs(l, level+1, position*2+1, length+=l.get(i)%10);
                dfs(l, level+1, position*2+2, length+=l.get(i)%10);
            }
        }
    }
}
