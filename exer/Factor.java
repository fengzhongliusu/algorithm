package exer;

import java.util.ArrayList;

/**
 * author: cshuo
 * date: 2017/3/25
 * version: 1.0
 * description:
 */
public class Factor {
    public static void main(String[] args) {
        if(1 == 1.0){
            System.out.println(getFactor(10));
        }
    }
    public static ArrayList<Integer> getFactor(int n){
        ArrayList<Integer> arr = new ArrayList<>();

        for(int i=2; i<= Math.sqrt(n); i++){
            if(n % i == 0){
                arr.add(i);
                if(n / i != i)
                    arr.add(n/i);
            }
        }
        return arr;
    }
}
