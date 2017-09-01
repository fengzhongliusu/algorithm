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
        int[] nums = {1,1,2,2};
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

    /**
     * 思路: 模拟排列组合数学归纳法的地推过程，n-1个元素到n个元素，可以选择插入的位置有n个
     * 模拟过程从包含一个元素的List开始逐个插入后面的元素，最终得到结果.
     */
    public static List<List<Integer>> permutate2(int[] nums) {
        List<List<Integer>> rs = new ArrayList<>();
        if(nums == null || nums.length < 1) return rs;
        Queue<List<Integer>> q = new LinkedList<>();
        q.add(Arrays.asList(new Integer[] {nums[0]}));
        int idx = 1;
        while(!q.isEmpty()) {
            List<Integer> tmp = q.poll();
            if(tmp.size() > idx) ++idx;

            if(tmp.size() == nums.length) {
                rs.add(tmp);
                continue;
            }
            for(int i=0; i<=tmp.size(); i++) {
                List<Integer> newList = new ArrayList<>(tmp);
                newList.add(i, nums[idx]);
                q.offer(newList);
            }
        }
        return rs;
    }
}
