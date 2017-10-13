package exam;

public class Airbnb02 {
    public static void main(String[] args) {
        int[][] maze = {
                {0,2,0},
                {0,0,1},
                {1,1,1}
        };
        System.out.println(minMoves(maze, 1,1));
    }
    static int[][] dir  = { {1,0}, {0,1}, {-1, 0}, {0, -1} };
    static int minStep = Integer.MAX_VALUE;
    public static int minMoves(int[][] maze, int x, int y) {
        int total = 0;
        for(int i=0; i<maze.length; i++)
            for(int j=0; j<maze[0].length; j++) if(maze[i][j] == 2) total++;
        boolean [][] visited = new boolean[maze.length][maze[0].length];
        dfs(visited, total, 0, 0, maze, 0, 0, x, y);
        return minStep == Integer.MAX_VALUE ? -1 : minStep;
    }

    public static void dfs(boolean[][] visited, int total, int taken, int steps, int[][] maze, int px, int py, int x, int y) {
        if(total == taken && px == x && py == y) minStep = Math.min(steps, minStep);
        else {
            for(int i=0; i<4; i++) {
                if(px + dir[i][0] < 0 || px + dir[i][0] >= maze.length || py + dir[i][1] < 0 || py + dir[i][1] >= maze[0].length) continue;
                if(visited[px+dir[i][0]][py+dir[i][1]]) continue;
                if(maze[px+dir[i][0]][py+dir[i][1]] == 1) continue;
                else if(maze[px+dir[i][0]][py+dir[i][1]] == 2) {
                    maze[px+dir[i][0]][py+dir[i][1]] = 0;
                    visited[px+dir[i][0]][py+dir[i][1]]  = true;
                    dfs(visited, total, taken+1, steps+1, maze, px+dir[i][0], py+dir[i][1], x, y);
                    visited[px+dir[i][0]][py+dir[i][1]]  = false;
                    maze[px+dir[i][0]][py+dir[i][1]] = 2;
                } else {
                    visited[px+dir[i][0]][py+dir[i][1]]  = true;
                    dfs(visited, total, taken, steps+1, maze, px+dir[i][0], py+dir[i][1], x, y);
                    visited[px+dir[i][0]][py+dir[i][1]]  = false;
                }
            }
        }
    }
}
