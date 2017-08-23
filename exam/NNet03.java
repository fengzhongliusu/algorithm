package exam;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by cshuo on 2017/8/12
 */
public class NNet03 {
    static int count = 0;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            int n = in.nextInt(), k = in.nextInt();
            count = 0;
            ArrayList<Integer> list = new ArrayList<>();
            dfs(list, n, k);
            System.out.println(count);
        }
        in.close();
    }

    public static void dfs(ArrayList<Integer> tmpList, int n, int k) {
        if(tmpList.size() == n){
            count = (count + 1) % 1000000007;
            return;
        }
        if(tmpList.size() > 0) {
            int prev = tmpList.get(tmpList.size()-1);
            for(int i=1; i<=k; i++) {
                if(prev <= i || prev % i != 0){
                    tmpList.add(i);
                    dfs(tmpList, n, k);
                    tmpList.remove(tmpList.size()-1);
                }
            }
        } else {
            for(int i=1; i<=k; i++) {
                tmpList.add(i);
                dfs(tmpList, n, k);
                tmpList.remove(tmpList.size()-1);
            }
        }
    }
}
