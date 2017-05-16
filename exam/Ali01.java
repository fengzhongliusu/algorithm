package exam;

/**
 * author: cshuo
 * date: 2017/4/26
 * version: 1.0
 * description:
 */
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Ali01 {

    public static void main(String[] args) {

        ArrayList<Integer> inputs = new ArrayList<Integer>();
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        if(line != null && !line.isEmpty()) {
            int res = resolve(line.trim());
            System.out.println(String.valueOf(res));
        }
    }

    // write your code here
    public static int resolve(String expr) {
        String[] ops = expr.split(" +");
        Stack<Integer> st = new Stack<>();
        int op1, op2;
        for(String e: ops){
            if(e.equals("^")){
                if(st.isEmpty()) return -1;
                op1 = st.pop();
                st.push(op1+1);
            }
            else if(e.equals("+")){
                if(st.size() < 2) return -1;
                op1 = st.pop();
                op2 = st.pop();
                st.push(op1+op2);
            } else if(e.equals("*")){
                if(st.size() < 2) return -1;
                op1 = st.pop();
                op2 = st.pop();
                st.push(op1*op2);
            } else {
                if(st.size() >= 16) return -2;
                st.push(Integer.parseInt(e));
            }
        }
        return st.pop();
    }
}
