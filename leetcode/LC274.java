package leetcode;
import java.util.*;

/**
 * Given an array of citations (each citation is a non-negative integer) of a researcher, write a function to compute the researcher's h-index.
 According to the definition of h-index on Wikipedia: "A scientist has index h if h of his/her N papers have at least h citations each, and the other N − h papers have no more than h citations each."
 For example, given citations = [3, 0, 6, 1, 5], which means the researcher has 5 papers in total and each of them had received 3, 0, 6, 1, 5 citations respectively. Since the researcher has 3 papers with at least 3 citations each and the remaining two with no more than 3 citations each, his h-index is 3.
 Note: If there are several possible values for h, the maximum one is taken as the h-index.

 Credits:
 Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.
 */
public class LC274 {
    /**
     * 时间: O(nlgn), 空间: O(1)
     */
    public static int hIndex(int[] citations) {
        if(citations == null || citations.length < 1) return 0;
        int max = 0, count = 1;
        Arrays.sort(citations);
        for(int i=citations.length-1; i>-1; i--, count++) {
            if(citations[i] >= count) max = Math.max(count, max);
            else break;
        }
        return max;
    }


    /**
     * 时间:O(n), 空间:O(n).
     */
    public int hIndex_2(int[] citations) {
        if(citations == null || citations.length < 1) return 0;
        int len = citations.length;
        int[] count = new int[len+1];
        for(int e: citations)
            if(e > len) count[len]++;
            else count[e]++;
        int ans = 0;
        for(int i=len; i>=0; i--) {
            ans += count[i];
            // 注意：是i个元素至少是i, 其他n-i个元素最多是i, 所以加上大于号.
            if(ans>=i) return i;
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {3, 0, 6, 1, 5};
        System.out.println(hIndex(nums));
    }
}
