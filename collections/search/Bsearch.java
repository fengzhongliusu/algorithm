package algs;

/**
 * Created by cshuo on 2017/8/1
 */
public class Bsearch {

    public static void main(String[] args) {
        int []arrs = {1,2,3,4,4,6,9,10};
        System.out.println(findLastLessOrEqual(arrs, 5));
        System.out.println(findK(arrs, 3));
        System.out.println(findFirstK(arrs, 4));
        System.out.println(findLastK(arrs, 4));
    }

    /**
     * 经典二分法，有序数组找指定数字
     * @param array
     * @param k
     * @return
     */
    public static int findK(int[] array, int k){
        int l = 0, r = array.length-1, mid;
        while(l <= r){
            mid = l + (r-l)/2;
            if(array[mid] > k){
                r = mid-1;
            } else if(array[mid] < k) {
                l = mid+1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * 对于重复的k, 找到第一个k的位置
     * @param arr
     * @param k
     * @return
     */
    public static int findFirstK(int[] arr, int k){
        int l = 0, r = arr.length - 1, mid;
        while(l <= r){
            mid = l + (r - l) / 2;
            if(arr[mid] > k)
                r = mid - 1;
            else if(arr[mid] < k)
                l = mid + 1;
            else if(mid > 0 && arr[mid-1] == k)
                r = mid - 1;
            else
                return mid;
        }
        return -1;
    }

    /**
     * 对于重复的k, 找到最后一个k的位置
     * @param arr
     * @param k
     * @return
     */
    public static int findLastK(int[] arr, int k){
        int l = 0, r = arr.length - 1, mid;
        while(l <= r){
            mid = (r - l) / 2 + l;
            if(arr[mid] > k)
                r = mid - 1;
            else if(arr[mid] < k)
                l = mid + 1;
            else if(mid < arr.length -1 && arr[mid+1] == k)
                l = mid + 1;
            else
                return mid;
        }
        return -1;
    }

    /**找第一个大于或等于给定数字的位置.
     */
    public static int findFirstGreaterOrEqual(int[] nums, int target) {
        int l=0, r=nums.length, mid;
        while(l<r) {
            mid = (r-l)/2+l;
            if(nums[mid] < target) l=mid+1;
            // nums[i] == target时，结果可能是Mid, nums[i] > target时，也有可能是mid.
            // 保证了一直有mid<high, 直到l=r
            else r = mid;
        }
        return l;
    }
}
