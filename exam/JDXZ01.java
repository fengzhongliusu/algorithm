package exam;

import java.util.*;

public class JDXZ01 {
    static int cnt;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            String s = in.next();
            cnt = 0;
            char[] strs = s.toCharArray();
            dfs(strs,new boolean[strs.length], strs.length);
            System.out.println(cnt);
        }
        in.close();
    }

    public static void dfs(char[] strs, boolean[] used, int leftNum) {
        if(leftNum == 0) cnt++;
        int k = 0;
        for(; k<strs.length; k++) {
            if(used[k]) continue;
            if(strs[k] == '(') {used[k] = true; break;}
        }
        for(int i=0; i<strs.length; i++) {
            if(used[i]) continue;
            if(strs[i] == ')') {
                used[i] = true;
                if(isValid(strs, used)) dfs(strs, used, leftNum-2);
                used[i] = false;
            }
        }
        if(k < strs.length) used[k] = false;
    }

    public static boolean isValid(char[] strs, boolean[] used) {
        Stack<Character> st = new Stack<>();
        for(int i=0; i<strs.length; i++) {
            if(used[i]) continue;
            if(strs[i] == '(') st.push('(');
            else if(st.isEmpty()) return false;
            else st.pop();
        }
        return st.isEmpty();
    }
}
