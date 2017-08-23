package exam;

import java.util.Scanner;

/**
 * Created by cshuo on 2017/8/12
 */
public class NNet01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            int x = in.nextInt(), f = in.nextInt(), d = in.nextInt(), p = in.nextInt();
            int sum = 0;
            for(int i=0; i<f && d > 0; i++){
                d -= x;
                sum++;
            }
            if(d < 0){
                sum--;
                System.out.println(sum);
                continue;
            }
            while(d > 0) {
                d -= p;
                d -= x;
                sum++;
            }
            if(d < 0) sum--;
            System.out.println(sum);
        }
        in.close();
    }
}
