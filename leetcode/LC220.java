package leetcode;

/**
 * Created by cshuo on 2017/9/10
 */
public class LC220 {
    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        boolean rs = false;
        k = Math.min(k, nums.length-1);
        for(int i=0; i<nums.length-1; i++)
            for(int j=i+1; j <= Math.min(i+k, nums.length-1); j++) {
                if(abs(nums[i], nums[j]) <= t) rs = true;
            }
        return rs;
    }

    public static long abs(long a, long b){
        return a >= b ? a-b : b-a;
    }

    public static void main(String[] args) {
        int[] arrs = new int[] {-1, 2147483647};
        System.out.println(containsNearbyAlmostDuplicate(arrs, 1, 2147483647));
    }
}
