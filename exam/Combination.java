package exam;

/**
 * author: cshuo
 * date: 2017/4/7
 * version: 1.0
 * description:
 */
import java.awt.*;
import java.util.*;
import java.util.List;


public class Combination {

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<Integer>(), nums, 0, 2);
        return list;
    }

    private static void backtrack(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start, int k){
        list.add(new ArrayList<>(tempList));
        if(tempList.size() == k) return;
        for(int i = start; i < nums.length; i++){
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1, k);
            tempList.remove(tempList.size() - 1);
        }
    }

    public static void main(String args[]){
        int chs[] = {1,2,3,4};
        List<List<Integer>> total = subsets(chs);
        System.out.println(total);
    }
}
