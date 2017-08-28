package exam;

/**
 * Created by cshuo on 2017/8/16
 * 在一个单峰数组中找一个数字的下表, 元素都不相同.
 */
public class AliInterview {
    public static void main(String[] args) {
        int[] a = new int[]{0,1,2,3,20,16,15,14,13,12,11};
        System.out.println(findNumIndex(a, 12));
    }

    public static int findNumIndex(int[] a, int num) {
        if(a == null || a.length < 1) return -1;
        int l = 0, r = a.length - 1, mid = l + (r-l)/2;
        while(true) {
            if(r - l > 1) {
                if((a[mid]-a[mid-1]) * (a[mid]-a[mid+1]) > 0) break;
                else {
                    if(a[mid] < a[mid-1]) r = mid - 1;
                    else l = mid + 1;
                }
            } else {
                mid = a[l] > a[r] ? l : r;
                break;
            }
            mid = l + (r-l)/2;
        }
        int index1 = binSearch(a, 0, mid, num, 0);
        if(index1 != -1) return index1;
        int index2 = binSearch(a, mid+1, a.length-1, num,1);
        return index2;
    }

    public static int binSearch(int[] a, int l, int r, int num, int order) {
        int mid;
        while(l <= r) {
            mid = l + (r-l)/2;
            if(a[mid] == num) return mid;
            else if(a[mid] > num) {
                if(order == 0) r = mid - 1;
                else l = mid + 1;
            } else {
                if(order == 0) l = mid + 1;
                else r = mid - 1;
            }
        }
        return -1;
    }
}
