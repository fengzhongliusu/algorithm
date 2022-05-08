package leetcode;

import java.util.*;
import java.util.function.BiFunction;

/**
 * Created by cshuo on 2021/8/8
 *
 * Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
 *
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 *
 *
 *
 * Example 1:
 *
 * Input: grid = [
 *   ["1","1","1","1","0"],
 *   ["1","1","0","1","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","0","0","0"]
 * ]
 * Output: 1
 * Example 2:
 *
 * Input: grid = [
 *   ["1","1","0","0","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","1","0","0"],
 *   ["0","0","0","1","1"]
 * ]
 * Output: 3
 */
public class LC200 {
    public static void main(String[] args) {
        char[][] arr =new char[][] {{'1','1','1','1','1','0','1','1','1','1','1','1','1','1','1','0','1','0','1','1'},{'0','1','1','1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','1','0'},{'1','0','1','1','1','0','0','1','1','0','1','1','1','1','1','1','1','1','1','1'},{'1','1','1','1','0','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},{'1','0','0','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},{'1','0','1','1','1','1','1','1','0','1','1','1','0','1','1','1','0','1','1','1'},{'0','1','1','1','1','1','1','1','1','1','1','1','0','1','1','0','1','1','1','1'},{'1','1','1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','0','1','1'},{'1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','1','1','1','1','1'},{'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},{'0','1','1','1','1','1','1','1','0','1','1','1','1','1','1','1','1','1','1','1'},{'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},{'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},{'1','1','1','1','1','0','1','1','1','1','1','1','1','0','1','1','1','1','1','1'},{'1','0','1','1','1','1','1','0','1','1','1','0','1','1','1','1','0','1','1','1'},{'1','1','1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','1','1','0'},{'1','1','1','1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','0','0'},{'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},{'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},{'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'}};
        System.out.println(numIslands2(arr));
    }

    public static int numIslands2(char[][] grid) {
        int count = 0;
        Queue<int[]> q = new LinkedList<>();

        BiFunction<Integer, Integer, Void> processAndMark = (x, y) -> {
            grid[x][y] = '0';
            q.add(new int[]{x, y});
            return null;
        };

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '0') {
                    continue;
                }
                count += 1;
                processAndMark.apply(i, j);
                while (!q.isEmpty()) {
                    int[] cur = q.poll();
                    int x = cur[0], y = cur[1];
                    if (x > 0 && grid[x-1][y] == '1') {
                        processAndMark.apply(x - 1, y);
                    }
                    if (y > 0 && grid[x][y-1] == '1') {
                        processAndMark.apply(x, y - 1);
                    }
                    if (x < grid.length -1 && grid[x+1][y] == '1') {
                        processAndMark.apply(x + 1, y);
                    }
                    if (y < grid[0].length -1 && grid[x][y+1] == '1') {
                        processAndMark.apply(x, y + 1);
                    }
                }
            }
        }
        return count;
    }

    public static int numIslands(char[][] grid) {
        Set<List<Integer>> mem = new HashSet<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') mem.add(Arrays.asList(i, j));
            }
        }

        boolean[][] visited = new boolean[grid.length][grid[0].length];

        int size = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!visited[i][j] && grid[i][j] == '0') continue;
                // mark as visited
                visited[i][j] = true;
                if (!mem.isEmpty() && mem.contains(Arrays.asList(i, j))) {
                    size += 1;
                }
                // bfs to remove all sub-islands
                ArrayDeque<List<Integer>> q = new ArrayDeque<>();
                q.add(Arrays.asList(i, j));
                while (!q.isEmpty() && !mem.isEmpty()) {
                    List<Integer> top = q.pop();
                    mem.remove(top);
                    int idx_i = top.get(0) + 1, idx_j = top.get(1);
                    if (idx_i < grid.length && !visited[idx_i][idx_j] && grid[idx_i][idx_j] == '1')  {
                        // mark as visited
                        visited[idx_i][idx_j] = true;
                        q.add(Arrays.asList(idx_i, idx_j));
                    }
                    idx_i = top.get(0) - 1; idx_j = top.get(1);
                    if (idx_i > -1 && !visited[idx_i][idx_j] && grid[idx_i][idx_j] == '1')  {
                        // mark as visited
                        visited[idx_i][idx_j] = true;
                        q.add(Arrays.asList(idx_i, idx_j));
                    }
                    idx_i = top.get(0); idx_j = top.get(1) + 1;
                    if (idx_j < grid[0].length && !visited[idx_i][idx_j] && grid[idx_i][idx_j] == '1')  {
                        // mark as visited
                        visited[idx_i][idx_j] = true;
                        q.add(Arrays.asList(idx_i, idx_j));
                    }
                    idx_i = top.get(0); idx_j = top.get(1) - 1;
                    if (idx_j > - 1 && !visited[idx_i][idx_j] && grid[idx_i][idx_j] == '1')  {
                        // mark as visited
                        visited[idx_i][idx_j] = true;
                        q.add(Arrays.asList(idx_i, idx_j));
                    }
                }
            }
        }
        return size;
    }
}
