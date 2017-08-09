package leetcode;
import java.util.*;

/**
 * author: cshuo
 * date: 2017/5/4
 * version: 1.0
 * description: 找所有子集, 回溯.
 */
public class Subsets {
    public static void main(String[] args) {
        int []nums = {1,2,2};
        System.out.println(subsets(nums));
        List<Integer> l = new ArrayList<>();
        l.add(2);
        l.add(1);
        l.add(2);
        l.add(2);
        l.remove(new Integer(2));
        System.out.println(l);
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> rs = new ArrayList<>();
        addSubset(rs, new ArrayList<>(), nums, 0);
        return rs;
    }

    public static void addSubset(List<List<Integer>> result, List<Integer> set, int[] nums, int start){
        result.add(new ArrayList<>(set));
        for(int i=start; i<nums.length; i++){
            set.add(nums[i]);
            addSubset(result, set, nums, i+1);
            set.remove(set.size()-1);
        }
    }

}
