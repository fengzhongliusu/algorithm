package exam;

public class NETX003 {
    public static void main(String[] args) {
    }

    public static int firstGreaterOrEqual(int[] nums, int target) {
        int l=0, r=nums.length, mid;
        while(l < r) {
            mid = (r-l)/2 + l;
            if(target <= nums[mid]) r = mid;
            else l = mid + 1;
        }
        return r;
    }
}
