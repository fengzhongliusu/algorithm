package leetcode;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int num_test;
        num_test = Integer.parseInt(in.next());
        String a, b, c;
        Main m = new Main();
        for(int i=0; i<num_test; i++){
            a = in.next();
            b = in.next();
            c = in.next();
            in.nextLine();
            System.out.println(m.getPlans(a, b, c));
        }
    }

    public int getPlans(String a, String b, String c){
        if(a.length() == 0 && b.length() == 0){
            return 1;
        } else if(a.length() == 0){
            if(b.charAt(0) == c.charAt(0)) return 1;
            else return 0;
        } else if(b.length() == 0){
            if(a.charAt(0) == c.charAt(0)) return 1;
            else return 0;
        }

        int sum = Integer.valueOf(c);
        int last_n = sum % 10;
        int sig, db, op1;

        if(a.charAt(a.length() - 1) == 'X' && b.charAt(b.length() - 1) == 'X'){
            sig = (last_n-1) * getPlans(a.substring(0,a.length()-1), b.substring(0, b.length()-1), c.substring(0, c.length()-1));
            if(sum < 10)
                return sig;
            else{
                int new_sum = sum/10 - 1;
                db = (9-last_n) * getPlans(a.substring(0,a.length()-1), b.substring(0,b.length()-1), String.valueOf(new_sum));
                return sig + db;
            }
        } else if (a.charAt(a.length() - 1) == 'X'){
            op1 = (int) b.charAt(b.length()-1);
            if(op1 < last_n){
                return getPlans(a.substring(0,a.length()-1), b.substring(0, b.length()-1), c.substring(0, c.length()-1));
            } else {
                int new_sum = sum/10 - 1;
                return getPlans(a.substring(0,a.length()-1), b.substring(0, b.length()-1), String.valueOf(new_sum));
            }
        } else if (b.charAt(b.length()-1) == 'X'){
            op1 = (int) a.charAt(a.length()-1);
            if(op1 < last_n){
                return getPlans(a.substring(0,a.length()-1), b.substring(0, b.length()-1), c.substring(0, c.length()-1));
            } else {
                int new_sum = sum/10 - 1;
                return getPlans(a.substring(0,a.length()-1), b.substring(0, b.length()-1), String.valueOf(new_sum));
            }

        } else {
            if(last_n == (int) a.charAt(a.length() - 1) + (int) b.charAt(b.length() - 1)){
                return getPlans(a.substring(0,a.length()-1), b.substring(0, b.length()-1), c.substring(0, c.length()-1));
            } else {
                int new_sum = sum/10 - 1;
                return getPlans(a.substring(0,a.length()-1), b.substring(0, b.length()-1), String.valueOf(new_sum));
            }
        }
    }
}
