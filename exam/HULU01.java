package exam;
import java.util.*;

public class HULU01 {
    static List<Integer> rs;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            int n = in.nextInt(), ent = in.nextInt();
            rs = new ArrayList<>();
            List<Integer>[] funcs = new ArrayList[n];
            for(int i=0; i<n; i++) {
                String tmp = in.nextLine();
                String[] strs = tmp.split(" ");
                for(int j=0; j<strs.length; j++) {
                    funcs[i].add(Integer.parseInt(strs[j]));
                }
            }
        }
        in.close();
    }

    public static void dfs(List<Integer>[] funcs, int idx1) {
        for(int e: funcs[idx1]) {

        }
    }
}
