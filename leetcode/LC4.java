package leetcode;

/**
 * Created by cshuo on 2017/8/22
 *
 * 两个有序数组找中位数.
 * O(lg(m+n)), k为要找数的下表，每次分别在两个数组中取出第k/2个数字(数组长不够，则取最后一个)进行比较，分别为l1[k/2]和l2[k/2]；
 * 如果l1[k/2]小于l2[k/2]，则可以肯定的是第k个数肯定不在l1中的k/2之前，可以将l1的前k/2个数字排除，在l1的k/2+1和l2中找第k-k/2个数,
 * 其他情况同理，所以复杂度是O(lg(m+n));
 */
public class LC4 {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2};
        int[] nums2 = new int[]{4,6,8};
        System.out.println(helper1(nums1, nums2, 3));
        System.out.println(median(nums2, nums1));
    }

    public static double median(int[] nums1, int[] nums2) {
        int l1 = nums1.length, l2 = nums2.length;
//        return (helper(nums1, nums2, 0,0, (l1+l2+1)/2) + helper(nums1, nums2, 0, 0, (l1+l2+2)/2))/2.0;
        return (helper1(nums1, nums2, (l1+l2+1)/2) + helper1(nums1, nums2, (l1+l2+2)/2)) / 2.0;
    }

    /**
     * 递归写法. 尾递归.
     */
    public static int helper(int[] nums1, int[] nums2, int idx1, int idx2, int halfLen) {
        if(idx1 >= nums1.length) return nums2[idx2+halfLen-1];
        if(idx2 >= nums2.length) return nums1[idx1+halfLen-1];
        if(halfLen == 1) return Math.min(nums1[idx1], nums2[idx2]);

        int mid1, mid2;
        mid1 = nums1.length - idx1 >= halfLen/2 ? idx1+halfLen/2-1 : nums1.length-1;
        mid2 = nums2.length - idx2 >= halfLen/2 ? idx2+halfLen/2-1 : nums2.length-1;
        if(nums1[mid1] <= nums2[mid2]) return helper(nums1, nums2, mid1+1, idx2, halfLen - (mid1-idx1+1));
        else return helper(nums1, nums2, idx1, mid2+1, halfLen-(mid2-idx2+1));
    }

    /**
     * 迭代写法.
     */
    public static int helper1(int[] nums1, int[] nums2, int halfLen) {
        int idx1 = 0, idx2 = 0, mid1, mid2;
        while(idx1 < nums1.length && idx2 < nums2.length && halfLen > 1) {
            mid1 = nums1.length - idx1 >= halfLen/2 ? idx1+halfLen/2-1 : nums1.length-1;
            mid2 = nums2.length - idx2 >= halfLen/2 ? idx2+halfLen/2-1 : nums2.length-1;
            if(nums1[mid1] <= nums2[mid2]) {
                halfLen -= mid1 - idx1 + 1;
                idx1 = mid1 + 1;
            } else {
                halfLen -= mid2 - idx2 + 1;
                idx2 = mid2 + 1;
            }
        }
        if(idx1 >= nums1.length) return nums2[idx2+halfLen-1];
        if(idx2 >= nums2.length) return nums1[idx1+halfLen-1];
        return Math.min(nums1[idx1], nums2[idx2]);
    }
}
