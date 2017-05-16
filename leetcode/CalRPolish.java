package leetcode;

import java.util.Stack;

/**
 * cal the value of an arithmetic expression in reverse polish notation.
 */
public class CalRPolish {
    public int evalRPN(String[] tokens){
        if(tokens.length == 0) return 0;
        Stack<Integer> tks = new Stack<Integer>();

        String ops = "+-*/";
        int op1, op2;
        for(String e: tokens){
            if(ops.contains(e)){
                op1 = tks.pop();
                op2 = tks.pop();
                if(e.equals("+"))
                    tks.push(op1 + op2);
                else if(e.equals("-"))
                    tks.push(op2 - op1);
                else if(e.equals("*"))
                    tks.push(op1 * op2);
                else
                    tks.push(op2 / op1);
            } else{
                tks.push(Integer.parseInt(e));
            }
        }
        return tks.peek();
    }

    public static void main(String[] args) {
        String a = "-4";
        System.out.println(Integer.parseInt(a) + 1);
    }
}
