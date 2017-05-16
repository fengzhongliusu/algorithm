package leetcode;

/**
 * author: cshuo
 * date: 2017/5/4
 * version: 1.0
 * description: 找到第一个丢失的正数,{2,1,0}返回3; {3,4,-1,1}返回2;
 */
public class FirstMissPositive {
    public static void main(String[] args) {
        int[] nums = {2,1,3};
        System.out.println(findFirst(nums));
    }

    public static void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    public static int findFirst(int []nums){
        for(int i=0; i<nums.length;){
            // nums[i]正确位置应该是下表nums[i]-1; 将i和nums[i]-1两个位置元素交换.
            if (nums[i]>0 && nums[i]<nums.length+1 && nums[i] != nums[nums[i]-1])
                swap(nums, i, nums[i]-1);
            else i++;
        }
        for(int i=0; i<nums.length; i++){
            if(nums[i] != i+1)
                return i+1;
        }
        return nums.length+1;
    }
}