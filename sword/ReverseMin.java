package sword;

/**
 * author: cshuo
 * date: 2017/4/23
 * version: 1.0
 * description:
 */
public class ReverseMin {
    public static void main(String[] args) {
        int[] arr = {1};
        System.out.println(getMin(arr));
    }

    public static int getMin(int[] arr){
        int l = 0, r = arr.length-1, mid = l;
        // l元素小于r元素,有序数组,直接返回第一个元素
        while(arr[l] >= arr[r]){
            if(r-l == 1){
                mid = r;
                break;
            }
            mid = l + (r-l)/2;
            // 无法判断mid处于数组的前半段,还是后半段,顺序查找
            if(arr[mid] == arr[l] && arr[mid] == arr[l])
                return minInOrder(arr, l, r);
            else if(arr[mid] >= arr[l])
                l = mid;
            else
                r = mid;
        }
        return arr[mid];
    }

    public static int minInOrder(int[] arr, int l, int r){
        int min = arr[l];
        for(int i=l; i<=r; i++)
            if(arr[i] < min) min = arr[i];
        return min;
    }
}
