package leetcode;
import java.util.*;

/**
 * author: cshuo
 * date: 2017/5/4
 * version: 1.0
 * description: 找所有排列组合, 回溯
 */
public class Permutation {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(permute(nums));
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> rs = new ArrayList<>();
        getAllPermu(rs, new ArrayList<Integer>(), nums);
        return rs;
    }

    public static void getAllPermu(List<List<Integer>> result, List<Integer> permu, int[] nums){
        if(permu.size() == nums.length){
            result.add(new ArrayList<Integer>(permu));
            return;
        }
        for(int e: nums){
            if(!permu.contains(e)){
                permu.add(e);
                getAllPermu(result, permu, nums);
                permu.remove(new Integer(e));
            }
        }
    }
}
