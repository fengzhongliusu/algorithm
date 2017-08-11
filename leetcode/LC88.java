package leetcode;

/**
 * Created by cshuo on 2017/8/11
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 * Note:
 You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
 The number of elements initialized in nums1 and nums2 are m and n respectively.
 */
public class LC88 {
    /**
     * 从后至前，若nums2所有元素先定好位置，剩余的nums1元素无需再动.
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i1 = m-1, i2 = n-1, t = m+n-1;
        while(i2 >= 0) nums1[t--] = i1>=0 && nums1[i1] >= nums2[i2] ? nums1[i1--]:nums2[i2--];
    }
}
