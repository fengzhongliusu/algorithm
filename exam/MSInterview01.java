package exam;

import java.util.Stack;

/**
 * author: cshuo
 * date: 2017/7/31
 * version: 1.0
 * description:
 */
public class MSInterview01 {
    public static void main(String[] args) {
        String s = "/home/cshuo/test/../../../../files/./file1";
        System.out.println(normalize(s));
    }

    public static String normalize(String str) {
        if(str == null) return null;
        String[] words = str.split("/");
        Stack<String> st = new Stack<>();

        for (String word : words) {
            if (word.equals("..") && !st.isEmpty()) st.pop();
            else if(word.equals("..") || word.equals(".")) continue;
            else if (word.length() > 0) st.push(word);
        }

        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()) sb.insert(0, "/" + st.pop());

        return sb.length() == 0 ? "/":sb.toString();
    }
}
