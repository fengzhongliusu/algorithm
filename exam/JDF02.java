package exam;

/**
 * author: cshuo
 * date: 2017/4/7
 * version: 1.0
 * description:
 */
import java.util.*;

public class JDF02 {

    public static void main(String[] args) {
        Integer[] a = new Integer[]{1,2,3,4};
        List<List<Integer>> total = new ArrayList<>();
        List<Integer> l = Arrays.asList(a);
        List<Integer> target = new ArrayList<>();

        genPL(3, 0, l, target, total);
        System.out.println(total);
    }

    public static void genPL(int m, int count, List<Integer> l, List<Integer> t, List<List<Integer>> total){
        if(count == m){
            total.add(t);
            return;
        }

        List<Integer> copyL;
        List<Integer> copyT;

        for(int i=0; i<l.size(); i++){
            copyL = new ArrayList<Integer>(l);
            copyT = new ArrayList<Integer>(t);
            copyT.add(copyL.get(i));
            copyL.remove(i);
            genPL(m, ++count, copyL, copyT, total);
        }
    }
}
