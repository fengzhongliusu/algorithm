package leetcode;
import java.util.*;

/**
 * author: cshuo
 * date: 2017/8/5
 * version: 1.0
 * description:
 */
public class LC241 {
    public static void main(String[] args) {
        String t = "2-1-1";
        System.out.println(diffWaysToCompute(t));
    }

    public static List<Integer> diffWaysToCompute(String input) {
        List<Integer> rs = new ArrayList<>();
        if(input == null) return rs;
        for(int i=0; i<input.length(); i++) {
            if(input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*') {
                List<Integer> part1 = diffWaysToCompute(input.substring(0, i));
                List<Integer> part2 = diffWaysToCompute(input.substring(i+1));
                for(int e1: part1)
                    for(int e2: part2) {
                        switch(input.charAt(i)) {
                            case '+': rs.add(e1+e2); break;
                            case '-': rs.add(e1-e2); break;
                            case '*': rs.add(e1*e2); break;
                        }
                    }
            }
        }
        if(rs.size() == 0) rs.add(new Integer(input));
        return rs;
    }
}
