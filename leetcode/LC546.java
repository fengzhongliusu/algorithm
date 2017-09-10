package leetcode;

import java.util.*;

public class LC546 {
    public static void main(String[] args) {
        int[] nums = new int[] {1, 3, 2, 2, 2, 3, 1};
        System.out.println(removeBoxesDP(nums));
        System.out.println(removeBoxes(nums));
    }

    static class Box {
        int val;
        int num;
        public Box(int val, int num) {this.num = num; this.val = val;}
    }

    /**
     * 思路错误...
     */
    public static int removeBoxes(int[] boxes) {
        if(boxes == null || boxes.length < 1) return 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        for(int e: boxes) map.put(e, map.getOrDefault(e, 0) + 1);
        Stack<Box> st = new Stack<>();
        int i = 0;
        while(i < boxes.length) {
            if(map.get(boxes[i]) == 1) {
                sum += 1; map.remove(boxes[i]);
                i++;
            }
            else if(st.isEmpty()) {
                st.push(new Box(boxes[i], 1));
                i++;
            }
            else if(st.peek().val == boxes[i]) {
                int num = map.get(boxes[i]);
                if(st.peek().num + 1 == num) {
                    sum += num * num;
                    st.pop();
                    map.remove(boxes[i]);
                } else {
                    Box tmp = st.pop();
                    tmp.num += 1;
                    st.push(tmp);
                }
                i++;
            } else {
                int minNum = Collections.min(map.values());
                if(map.get(st.peek().val) == minNum) {
                    sum += st.peek().num * st.peek().num;
                    map.put(st.peek().val, map.get(st.peek().val) - st.peek().num);
                    st.pop();
                } else {
                    st.push(new Box(boxes[i], 1));
                    i++;
                }
            }
            System.out.println(st);
        }
        if(!st.isEmpty()) sum += st.peek().num * st.peek().num;
        return sum;
    }

    public static int removeBoxesDP(int[] boxes) {
        if (boxes == null || boxes.length == 0) {
            return 0;
        }

        int size = boxes.length;
        int[][][] dp = new int[size][size][size];

        return get(dp, boxes, 0, size-1, 1);
    }

    private static int get(int[][][] dp, int[] boxes, int i, int j, int k) {
        if (i > j) {
            return 0;
        } else if (i == j) {
            return k * k;
        } else if (dp[i][j][k] != 0) {
            return dp[i][j][k];
        } else {
            int temp = get(dp, boxes, i + 1, j, 1) + k * k;

            for (int m = i + 1; m <= j; m++) {
                if (boxes[i] == boxes[m]) {
                    temp = Math.max(temp, get(dp, boxes, i + 1, m - 1, 1) + get(dp, boxes, m, j, k + 1));
                }
            }

            dp[i][j][k] = temp;
            return temp;
        }


    }
}
