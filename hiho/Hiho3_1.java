package hiho;

import java.util.Scanner;

/**
 * 出勤记录1
 */
public class Hiho3_1 {
    public static boolean isOk(String s){
        int num_A = 0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == 'A'){
                num_A += 1;
                if(num_A > 1) return false;
            }
            if(s.charAt(i) == 'L'){
                if( i+1 < s.length() && s.charAt(i+1) == 'L'){
                    if(i+2 < s.length() && s.charAt(i+2) == 'L') return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int numTest;
        Scanner sc = new Scanner(System.in);
        numTest = sc.nextInt();
        String t;
        for(int i=0; i<numTest; i++){
            t = sc.next();
            if(isOk(t)) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
