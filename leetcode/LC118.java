package leetcode;
import java.util.*;

/**
 * 杨辉三角, 每一行的第j个数，等于上一行的第j-1个数和第j个数相加.
 */
public class LC118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> rs = new ArrayList<>();
        List<Integer> cur, prev = null;
        for(int i=0; i<numRows; i++) {
            cur = new ArrayList<>();
            for(int j=0; j<=i; j++) {
                if(j == 0 || j == i) cur.add(1);
                else cur.add(prev.get(j-1) + prev.get(j));
            }
            prev = cur;
            rs.add(cur);
        }
        return rs;
    }

    public static void main(String[] args) {
    }
}
