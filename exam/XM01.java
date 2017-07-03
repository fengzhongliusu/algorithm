package exam;

/**
 * author: cshuo
 * date: 2017/6/5
 * version: 1.0
 * description:
 */
import java.util.*;

public class XM01{
    public static void main(String[] args) {
        int m = 10;
        int n = 9;
        int[][] tasks = {
                {1,1},
                {1,1},
                {1,1},
                {2,3},
                {1,1},
                {10,9}
        };
        System.out.println(getMaxNum(m, n, tasks));
    }
    public static int getMaxNum(int m, int n, int[][] tasks){
        int[] indexs = new int[tasks.length];
        for(int i=0; i<indexs.length; i++)
            indexs[i] = i;

        int maxNum = 0;
        List<List<Integer>> sets = subsets(indexs);
        for(List<Integer> indexList: sets){
            if(checkOk(m, n, tasks, indexList)==0 && indexList.size() > maxNum)
                maxNum = indexList.size();
        }
        return maxNum;
    }

    public static int checkOk(int m, int n, int[][] tasks, List<Integer> indexs){
        int sumNet=0, sumDisk=0;
        for(Integer i: indexs){
            sumNet += tasks[i][0];
            if(sumNet > m){
                return -1;
            }
            sumDisk += tasks[i][1];
            if(sumDisk > n){
                return -1;
            }
        }
        return 0;
    }

    public static List<List<Integer>> subsets(int[] indexs){
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<Integer>(), indexs, 0);
        return list;
    }

    public static void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int begin){
        list.add(new ArrayList<>(tempList));
        for(int i=begin; i<nums.length; i++){
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i+1);
            tempList.remove(tempList.size() - 1);
        }
    }
}
