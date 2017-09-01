package leetcode;
import java.util.*;

/**
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 For example,
 [1,1,2] have the following unique permutations:
 [
 [1,1,2],
 [1,2,1],
 [2,1,1]
 ]
 */
public class LC47 {
    /**
     *  1. 直接调用next Permutate的解法.
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
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

    public void nextPermutation(Integer[] nums) {
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

    public void swap(Integer[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    /** 2. 基于next permutation思想, 递归解法*/
    public List<List<Integer>> permuteDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Integer[] eles = new Integer[nums.length];
        for(int i=0; i<nums.length; i++) eles[i] = nums[i];
        Arrays.sort(eles);
        permutate(ans, eles, 0);

        return ans;
    }

    private void permutate(List<List<Integer>> ans, Integer[] nums, int start) {
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

    /** 3. 非递归写法 */
    public List<List<Integer>> permuteUnq(int[] ns) {
        List<List<Integer>> rs = new ArrayList<>();
        if(ns == null || ns.length < 1) return rs;

        Arrays.sort(ns);
        Integer[] nums = new Integer[ns.length];
        for(int i=0; i<ns.length; i++) nums[i] = ns[i];

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
}
