package leetcode;

import java.util.*;

/**
 * author: cshuo
 * date: 2017/4/22
 * version: 1.0
 * description: N-皇后问题
 */
public class Queens {
    static ArrayList<int[]> solutions;

    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(1000);
        int k = 8;
        solutions = new ArrayList<>();
        int[] p = new int[k];
        getSolutions(p, 0);
        System.out.println("Total Solution: " + solutions.size());
        for(int[] sl: solutions)
            System.out.println(Arrays.toString(sl));
    }

    /**
     * @param position 皇后坐标
     * @param cur 当前的行数
     * 用一个一维数组表示, 数组下标代表行, 数组元素代表列, dfs 每次下潜一行, 判断是否与之前的皇后冲突.
     */
    public static void getSolutions(int[] position, int cur){
        if(cur == position.length){
            solutions.add(position.clone());
            return;
        }
        for(int i=0; i<position.length; i++){
            position[cur] = i;
            boolean ok = true;
            for(int j=0; j<cur; j++){
                if(position[j]==i || cur-position[cur] == j-position[j] || cur+position[cur] == j+position[j]){
                    ok = false;
                    break;
                }
            }
            if(ok) getSolutions(position, cur+1);
        }
    }

    /**
     * 统计N-皇后，可能解法个数
     * 三个辅助数组，分别判断是否是同一列，以及同一个对角线或反对角线.
     * **/

    int count = 0;
    public int totalNQueens(int n) {
        getQ(new boolean[n], new boolean[2*n], new boolean[2*n], 0, n);
        return count;
    }
    public void getQ(boolean[] col, boolean[] diag, boolean[] antiDiag, int cur, int n){
        if(cur >= n) { ++count; return; }
        for(int c=0; c<n; c++) {
            int id1 = cur-c+n;
            int id2 = cur+c;
            if(col[c] || diag[id1] || antiDiag[id2]) continue;
            col[c] = true; diag[id1] = true; antiDiag[id2] = true;
            getQ(col, diag, antiDiag, cur+1, n);
            col[c] = false; diag[id1] = false; antiDiag[id2] = false;
        }
    }

}
