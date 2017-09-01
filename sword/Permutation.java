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
        Integer[] a = {1,1,2,2};
        System.out.println(permuteDup0(a));
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

    /**基于next permutation思想, 递归解法*/
    public static List<List<Integer>> permuteDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Integer[] eles = new Integer[nums.length];
        for(int i=0; i<nums.length; i++) eles[i] = nums[i];
        Arrays.sort(eles);
        permutate(ans, eles, 0);

        return ans;
    }

    private static void permutate(List<List<Integer>> ans, Integer[] nums, int start) {
        if (start == nums.length) {
            ans.add(Arrays.asList(nums));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            if (i != start && nums[start] == nums[i]) continue;
            swap(nums, start, i);    // 对sibling是有影响的.
            permutate(ans, Arrays.copyOf(nums, nums.length), start+1);
        }
    }

    /** 非递归解法*/
    public static List<List<Integer>> permuteDup0(Integer[] nums) {
        List<List<Integer>> rs = new ArrayList<>();
        if(nums == null || nums.length < 1) return rs;

        Stack<Integer[]> st = new Stack<>();
        Stack<Integer> depth = new Stack<>();
        st.push(nums); depth.push(0);

        while(!st.isEmpty()) {
            Integer[] tmp = st.pop();
            int dep = depth.pop();
            if(dep == nums.length) rs.add(Arrays.asList(tmp));
            for(int i=dep; i<nums.length; i++) {
                if(i != dep && tmp[dep] == tmp[i]) continue;
                swap(tmp, dep, i);
                st.push(Arrays.copyOf(tmp, tmp.length));
                depth.push(dep+1);
            }
        }
        return rs;
    }

    /**直接调用permutation的解法*/
    public static List<List<Integer>> permuteDup1(int[] nums) {
        List<List<Integer>> rs= new ArrayList<>();
        if(nums == null || nums.length < 1) return rs;
        Arrays.sort(nums);
        Integer[] list = new Integer[nums.length];
        for(int i=0; i<nums.length; i++) list[i] = nums[i];
        int goon;
        while(true) {
            rs.add(new ArrayList<>(Arrays.asList(list)));
            nextPermutation(list);
            goon = 0;
            for(int i=0; i<list.length-1; i++) {
                if(list[i] > list[i+1]) {goon = 1; break;}
            }
            if(goon == 0) break;
        }
        return rs;
    }

    public static void nextPermutation(Integer[] nums) {
        if(nums == null || nums.length < 1) return;
        int i, j;
        for(i=nums.length-1; i>0; i--) {
            if(nums[i-1]<nums[i]) break;
        }
        for(j=nums.length-1; j>=i; j--)
            if(i>0 && nums[j] > nums[i-1]) break;
        if(i>0) swap(nums, j, i-1);
        for(int l=i, r=nums.length-1; l<=r; l++, r--) swap(nums, l, r);
    }

    public static void swap(Integer[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
