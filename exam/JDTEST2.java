package exam;

/**
 * Created by cshuo on 2017/4/7
 */
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JDTEST2{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        JDTEST2 arrange = new JDTEST2();
        List<Character> data = new ArrayList<Character>();
        List<List<Character>> total = new ArrayList<>();

        //输出A(n,n)的全排列
        arrange.arrangeSelect(data, new ArrayList<Character>(), 2, total);
        System.out.println(total);

    }

    public void arrangeSelect(List data, List target, int k, List<List<Character>> total) {
        List copyData;
        List copyTarget;
        if(target.size() == k) {
            total.add(target);
        }

        for(int i=0; i<data.size(); i++) {
            copyData = new ArrayList(data);
            copyTarget = new ArrayList(target);

            copyTarget.add(copyData.get(i));
            copyData.remove(i);

            arrangeSelect(copyData, copyTarget,k, total);
        }
    }
}
