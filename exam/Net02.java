package exam;

import java.util.Scanner;

/**
 * author: cshuo
 * date: 2017/3/25
 * version: 1.0
 * description:
 */


public class Net02{
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        while(sc.hasNext()){
            String line = sc.next();
            int gNum=0,bNum=0,cg=0,cb=0;
            for(int i=0; i<line.length(); i++){
                if(line.charAt(i) == 'G') {
                    gNum += (i-cg);
                    cg++;
                }
                else {
                    bNum += (i-cb);
                    cb++;
                }
            }

        System.out.println(Math.min(gNum, bNum));
        }
        sc.close();

    }

}

