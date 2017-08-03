package exam;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by cshuo on 2017/8/1
 */
public class PDD03 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            int hLen = in.nextInt();
            int[] hArr = new int[hLen];
            for(int i=0; i<hLen; i++) hArr[i] = in.nextInt();
            int wLen = in.nextInt();
            int[] wArr = new int[wLen];
            for(int i=0; i<wLen; i++) wArr[i] = in.nextInt();

            Arrays.sort(hArr);
            Arrays.sort(wArr);
            int sum = 0, curse = 0;
            for(int i=0; i<wLen; i++){
                for(int j=curse; j<hLen; j++) {
                    if(wArr[i] < hArr[j]) break;
                    else {
                        curse++;
                        sum++;
                        break;
                    }
                }
            }
            System.out.println(sum);
        }
        in.close();
    }
}
