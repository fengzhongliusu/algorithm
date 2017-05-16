package sword;

import java.util.*;

/**
 * author: cshuo
 * date: 2017/5/16
 * version: 1.0
 * description: 包含重复的元素
 */
public class Permutation {
    public static void main(String[] args) {
        int[] a = {1,2,2};
        System.out.println(permuteUnique(a));
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<Integer>(), nums, new boolean[nums.length]);
        return list;
    }

    private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, boolean [] used){
        if(tempList.size() == nums.length){
            list.add(new ArrayList<>(tempList));
        } else{
            for(int i = 0; i < nums.length; i++){
                // 只有当连续相同字符的前一个被被使用, 当前的这个才能被使用, 避免用同一个字符开始一个新的排列.
                if(used[i] || i > 0 && nums[i] == nums[i-1] && !used[i - 1]) continue;
                used[i] = true;
                tempList.add(nums[i]);
                backtrack(list, tempList, nums, used);
                used[i] = false;
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
