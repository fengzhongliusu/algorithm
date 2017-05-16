package hiho;

import leetcode.MaxSubArr;

import java.util.*;

/**
 * author: cshuo
 * date: 2017/4/3
 * version: 1.0
 * description:
 */
public class GeneParen {
    private static int num;

    public static void backtrack(int len, int open, int close, int max){

        if(len == max*2){
            num += 1;
            if(num > Math.pow(10, 9) + 7) num %= Math.pow(10, 9) + 7;
            return;
        }

        if(open < max)
            backtrack(len+1,open+1, close, max);
        if(close < open)
            backtrack(len+1, open, close+1, max);
    }

    public static void main(String[] args) {
        num = 0;
        String str;
        Scanner in = new Scanner(System.in);
        str= in.next();

        Stack<Character> st = new Stack<>();
        int rNum = 0, matched = 0;
        int min;
        for(int i=0; i< str.length(); i++){
            if(str.charAt(i) == '(') st.push('(');
            else{
                if(st.empty()) rNum ++;
                else{
                    st.pop();
                    matched ++;
                }
            }
        }
        min = matched + st.size() +  rNum;

        System.out.print(st.size() + rNum + " ");
        backtrack(0, 0, 0, min);
        System.out.println(num);
    }
}


