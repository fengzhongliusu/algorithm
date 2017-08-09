package leetcode;
import java.math.BigInteger;
import java.util.*;

/**
 * Created by cshuo on 2017/8/7
 * A binary watch has 4 LEDs on the top which represent the hours (0-11), and the 6 LEDs on the bottom represent the minutes (0-59).

 Each LED represents a zero or one, with the least significant bit on the right.
 For example, the above binary watch reads "3:25".

 Given a non-negative integer n which represents the number of LEDs that are currently on, return all possible times the watch could represent.

 Example:
 Input: n = 1
 Return: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"]
 */
public class LC401 {
    public static void main(String[] args) {
        List<String> rs = readBinaryWatch(2);
        System.out.println(rs);
        System.out.println(rs.size());
    }

    /**
     * backtrack回溯法.
     */
    public static List<String> readBinaryWatch(int num) {
        ArrayList<String> rs = new ArrayList<>();
        ArrayList<Integer> h = new ArrayList<>(), m = new ArrayList<>();
        dfs(rs, h, m, 0, 0, num);
        return rs;
    }

    public static void dfs(ArrayList<String>rs, ArrayList<Integer> h, ArrayList<Integer> m, int usedH, int usedM, int num) {
        if(num == 0) {
            int hSum = 0, mSum = 0;
            for(int e: h) hSum += (1<<e);
            if(hSum > 11) return;
            for(int e: m) mSum += (1<<e);
            if(mSum > 59) return;
            String time = Integer.toString(hSum)+":";
            time += mSum>9?mSum:"0"+mSum;
            if(!rs.contains(time)) rs.add(time);
            return;
        }
        for(int i=usedH; i<4; i++) {
            h.add(i);
            dfs(rs, h, m, i+1, usedM, num-1);
            h.remove(new Integer(i));
        }

        for(int i=usedM; i<6; i++) {
            m.add(i);
            dfs(rs, h, m, usedH, i+1, num-1);
            m.remove(new Integer(i));
        }
    }
}
