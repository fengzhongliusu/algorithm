package sword;

/**
 * author: cshuo
 * date: 2017/5/1
 * version: 1.0
 * description: 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 */
public class MinNumInRotateArray {
    public static void main(String[] args) {
        int[] arr = {2,2,2,2,2,1,2};
        System.out.println(findMin(arr));
        System.out.println(findMin2(arr));
    }

    public static int findMin(int[] array){
        if(array.length < 1) return 0;
        int l = 0, r = array.length-1, mid = l;
        while(array[l] >= array[r]){
            if(l == r -1){
                mid = r;
                break;
            }
            mid = (r-l)/2 + l;
            if(array[mid] == array[l] && array[mid] == array[r])
                return minOfArr(array, l, r);
            else if(array[mid] >= array[l]){
                l = mid;
            } else {
                r = mid;
            }
        }
        return array[mid];
    }

    public static int minOfArr(int[] arr, int l, int r){
        int min = Integer.MAX_VALUE;
        for(int e: arr){
            if(e < min) min = e;
        }
        return min;
    }

    public static int findMin2(int[] arr){
        if(arr.length < 1) return 0;
        int low=0, hi=arr.length-1, mid;
        while(low < hi){
            mid = (hi-low)/2 + low;
            if(arr[mid] > arr[hi]) low = mid + 1;
            else if(arr[mid] == arr[hi]) hi--;
            else  hi = mid;
        }
        return arr[low];
    }
}
