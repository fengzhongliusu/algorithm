package hiho;


/**
 * author: cshuo
 * date: 2017/4/5
 * version: 1.0
 * description:
 */

import java.util.*;

public class Test{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int a, b;
        while(in.hasNext()){
            a = in.nextInt();
            b = in.nextInt();
            System.out.println(a+b);
        }
        in.close();
    }
}
