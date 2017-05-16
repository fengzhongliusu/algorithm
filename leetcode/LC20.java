package leetcode;

import java.util.Stack;

/**
 * author: cshuo
 * date: 2017/4/3
 * version: 1.0
 * description:
 */
public class LC20 {
    public boolean isValid(String s) {
        if(s.length() < 1) return false;
        Stack<Character> st = new Stack();
        char tmp;
        for(int i=0; i<s.length(); i++){
            tmp = s.charAt(i);
            if(tmp == '(' || tmp == '[' || tmp == '{'){
                st.push(tmp);
            } else {
                if(st.empty()) return false;
                if(tmp == ')'){
                    if(st.pop() != '(') return false;
                } else if(tmp == ']'){
                    if(st.pop() != '[') return false;
                } else {
                    if(st.pop() != '{') return false;
                }
            }
        }
        return st.empty();
    }
}
