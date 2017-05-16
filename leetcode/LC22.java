package leetcode;

import java.util.*;

/**
 * author: cshuo
 * date: 2017/4/3
 * version: 1.0
 * description:
 */
public class LC22 {
    public List<String> generateParenthesis(int n) {
        List<String> l = new ArrayList<>();
        traverse(l, "", 0, 0, n);
        return l;
    }
    public void traverse(List<String>l, String s, int lnum, int rnum, int n){
        if(lnum == n && rnum == n){
            l.add(s);
            return;
        }
        if(lnum < n){
            traverse(l, s+'(', lnum+1, rnum, n);
        }
        if(rnum < lnum){
            traverse(l, s+')', lnum, rnum+1, n);
        }
    }
}
