package leetcode;
import java.util.*;

/**
 * author: cshuo
 * date: 2017/4/21
 * version: 1.0
 * description: 递归回溯, 找一个集合的所有子集.
 */
public class Subset {

    public static void main(String[] args) {
        int[] nums = {2,1,3};
        List<List<Integer>> rs = subsets(nums);
        System.out.println(rs);
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
    }

    private static void backtrack(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start){
        list.add(new ArrayList<>(tempList));
        for(int i = start; i < nums.length; i++){
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
}
