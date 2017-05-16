package exam;
import java.util.*;

/**
 * author: cshuo
 * date: 2017/4/27
 * version: 1.0
 * description:
 */
public class BD03 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int n = in.nextInt();
            int k = in.nextInt();
            int[] nums = new int[n];
            int countLess, sum=0;
            for(int i=0; i<n; i++){
                nums[i] = i + 1;
            }
            List<List<Integer>> l = permute(nums);
            Integer[] tmp;
            for(List<Integer> el: l){
                countLess = 0;
                tmp = el.toArray(new Integer[el.size()]);
                for(int i=0; i<tmp.length-1; i++){
                    if(tmp[i] < tmp[i+1]) countLess++;
                }
                if(countLess == k) sum ++;
            }
            System.out.println(sum);
        }
    }
    public static List<List<Integer>> permute(int[] num) {
        LinkedList<List<Integer>> res = new LinkedList<List<Integer>>();
        res.add(new ArrayList<Integer>());
        for (int n : num) {
            int size = res.size();
            for (; size > 0; size--) {
                List<Integer> r = res.pollFirst();
                for (int i = 0; i <= r.size(); i++) {
                    List<Integer> t = new ArrayList<Integer>(r);
                    t.add(i, n);
                    res.add(t);
                }
            }
        }
        return res;
    }
}
