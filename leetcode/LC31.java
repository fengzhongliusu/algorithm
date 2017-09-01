package leetcode;

public class LC31 {
    public static void nextPermutation(Integer[] nums) {
        if(nums == null || nums.length < 1) return;


        int i, j;
        // 判断是否存在后缀是递减的.
        for(i=nums.length-1; i>0; i--) {
            if(nums[i-1]<nums[i]) break;
        }

        if(i == nums.length-1) {
            // 不存在递减后缀，直接交换最后两个元素位置.
            if(i>0) swap(nums, i, i-1);
        } else {
            // 存在递减后缀, 交换后缀的前一个元素与后缀中最后一个大于该元素的元素位置，然后reverse后缀. 1,3,2 -> 2,3,1->2,1,3.
            for(j=i; j<nums.length; j++) {
                if(i>0 && nums[j] < nums[i-1]) break;
            }
            if(i>0) swap(nums, j-1, i-1);
            for(int l=i, r=nums.length-1; l<=r; l++, r--) swap(nums, l, r);
        }

        /** 简化.

        if(nums == null || nums.length < 1) return;
        int i, j;
        for(i=nums.length-1; i>0; i--) {
            if(nums[i-1]<nums[i]) break;
        }
        for(j=nums.length-1; j>=i; j--) {
            if(i>0 && nums[j] > nums[i-1]) break;
        }
        if(i>0) swap(nums, j, i-1);
        for(int l=i, r=nums.length-1; l<=r; l++, r--) swap(nums, l, r);

        **/
    }

    public static void swap(Integer[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        Integer[] nums = new Integer[] {1,3,2};
        nextPermutation(nums);
        for (int e: nums)
            System.out.print(e + " ");
    }
}
