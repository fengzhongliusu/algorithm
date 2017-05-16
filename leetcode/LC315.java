package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Count of Smaller Numbers After Self
 * You are given an integer array nums and you have to return a new counts array. The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].

 Example:

 Given nums = [5, 2, 6, 1]

 To the right of 5 there are 2 smaller elements (2 and 1).
 To the right of 2 there is only 1 smaller element (1).
 To the right of 6 there is 1 smaller element (1).
 To the right of 1 there is 0 smaller element.
 Return the array [2, 1, 1, 0].
 *
 */
public class LC315 {
    public static List<Integer> countSmaller(int[] nums){
        List<Integer> lst = new ArrayList<Integer>();
        int sum;
        for(int i = 0; i < nums.length - 1; i++){
            sum = 0;
            for(int j=i+1; j<nums.length; j++){
                if(nums[j] < nums[i]) sum += 1;
            }
            lst.add(sum);
        }
        if(nums.length > 0) lst.add(0);
        return lst;
    }

    public static void main(String[] args) {
        int []arr = new int[]{5,2,6,1};
        List<Integer> rt = LC315.countSmaller(arr);
        for(int l: rt)
            System.out.print(l + " ");
    }
}
