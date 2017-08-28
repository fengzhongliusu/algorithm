package collections.search;

/**
 * Created by cshuo on 2017/6/4.
 */
public class BinSearch {
    public static void main(String[] args) {
        int []arrs = {1,2,3,10};
        System.out.println(firstGreaterOrEqual(arrs, -1));
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

    /**
     * 递增数组中，第一个大于或等于target的元素的下表，若都小于target, 则返回数组的长度 nums.length;
     */
    public static int firstGreaterOrEqual(int[] nums, int target) {
        int l=0, r=nums.length, mid;
        while(l < r) {
            mid = (r-l)/2 + l;
            //nums[mid] == target时，结果可能是Mid, nums[mid] > target时，也有可能是mid.
            if(target <= nums[mid]) r = mid;
            else l = mid + 1;
        }
        return r;
    }

    /**
     * 先递增后递减数组找峰值
     */
    public static int maxPoint(int[] A) {
        int m = A.length;
        int begin = 0;
        int end = m - 1;
        int tp = begin + (end - begin) / 2;

        // the condition "tp > 0 && tp < m -1" makes sure that tp is not at the beginning or the end
        while (tp > 0 && tp < m - 1) {
            if (A[tp] > A[tp + 1] && A[tp] > A[tp - 1]) {
                return tp;
            } else if (A[tp] < A[tp + 1]) {
                begin = tp + 1;
            } else {
                end = tp - 1;
            }
            tp = begin + (end - begin) / 2;
        }
        return -1;
    }
}
