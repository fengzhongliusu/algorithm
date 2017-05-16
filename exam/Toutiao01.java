package exam;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * author: cshuo
 * date: 2017/4/18
 * version: 1.0
 * description:
 */
public class Toutiao01 {
    public static void main(String[] args) {
        int m, n;
        int[] l1;
        int[] l2;
        ArrayList<Integer> rs;
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            rs = new ArrayList<>();
            m = in.nextInt();
            l1 = new int[m];
            for(int i=0; i<m;i++){
                l1[i] = in.nextInt();
            }
            n = in.nextInt();
            l2 = new int[n];
            for(int i=0; i<n; i++){
                l2[i] = in.nextInt();
            }
            int tmp;
            for(int i=0; i<n; i++){
                tmp = l2[i];
                for(int j=0; j<m; j++){
                    if(tmp == l1[j]){
                        rs.add(tmp);
                        break;
                    }
                }
            }
            for(int e: rs){
                System.out.print(e + " ");
            }
            System.out.println();
        }
    }
}
