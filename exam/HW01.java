package exam;

/**
 * author: cshuo
 * date: 2017/4/20
 * version: 1.0
 * description:
 */
import java.util.ArrayList;
import java.util.Scanner;


public class HW01 {

    static int mincost;
    static ArrayList<Integer> minpath = new ArrayList<>();
    static int[][] map = {
            {0, 2, 10, 5, 3, 1000},
            {1000, 0, 12, 1000, 1000, 10},
            {1000, 1000, 0, 1000, 7, 1000},
            {2, 1000, 1000, 0, 2, 1000},
            {4, 1000, 1000, 1, 0, 1000},
            {3, 1000, 1, 1000, 2, 0}
    };

    public static void main(String[] args) {
        int x, y;
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> rs;
        while(scanner.hasNext()){
            rs = new ArrayList<>();
            x = scanner.nextInt();
            y = scanner.nextInt();
            ArrayList<Integer> path = new ArrayList<>();

            if (y == 5) {
                System.out.println(1000);
                System.out.println("[]");
                continue;
            }

            if (y != 0)
                for (int i = 0; i < 6; ++i) {
                    map[i][y - 1] = 1000;
                }

            boolean[] used = new boolean[7];
            mincost = -1;
            used[5] = true;
            dfs(path, 0, used, x, 5);
            if (mincost >= 1000) System.out.println(1000);
            else System.out.println(mincost);

            if (mincost >= 1000) {
                System.out.println("[]");
                continue;
            }

            rs.add(5);
            for (Integer aMinpath : minpath) {
                rs.add(aMinpath);
            }

            System.out.println(rs);
        }
        scanner.close();
    }

    public static void dfs(ArrayList<Integer> path, int cost, boolean[] used, int target, int next) {
        if (next == target) {
            if (mincost == -1 || cost < mincost) {
                mincost = cost;
                minpath = new ArrayList<>(path);
            }
        }

        for (int i = 1; i <= 6; ++i) {
            if (!used[i] && i != next) {
                used[i] = true;
                path.add(i);
                dfs(path, cost + map[next - 1][i - 1], used, target, i);
                path.remove(path.size() - 1);
                used[i] = false;
            }
        }

    }
}



