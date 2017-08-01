package leetcode;

/**
 * Created by cshuo on 2017/8/1
 * Find the first bad version. (all products after the first bad version are also bad versions)
 */
public class LC278 {
    public static void main(String[] args) {
    }
    /* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */
    public static int firstBadVersion(int n) {
        int l=0, r=n, mid;
        while(l <= r) {
            mid = (r-l)/2 + l;
            if(isBadVersion(mid))
                if(mid == 1 || mid > 1 && !isBadVersion(mid-1)) return mid;
                else r = mid -1;
            else l = mid + 1;
        }
        return -1;
    }

    public static boolean isBadVersion(int num) {return false;}
}
