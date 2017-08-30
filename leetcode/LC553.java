package leetcode;

/**
 * Given a list of positive integers, the adjacent integers will perform the float division. For example, [2,3,4] -> 2 / 3 / 4.

 However, you can add any number of parenthesis at any position to change the priority of operations. You should find out how to add parenthesis to get the maximum result, and return the corresponding expression in string format. Your expression should NOT contain redundant parenthesis.

 Example:
 Input: [1000,100,10,2]
 Output: "1000/(100/10/2)"
 Explanation:
 1000/(100/10/2) = 1000/((100/10)/2) = 200
 However, the bold parenthesis in "1000/((100/10)/2)" are redundant,
 since they don't influence the operation priority. So you should return "1000/(100/10/2)".

 Other cases:
 1000/(100/10)/2 = 50
 1000/(100/(10/2)) = 50
 1000/100/10/2 = 0.5
 1000/100/(10/2) = 2
 */
public class LC553 {
    /**
     * 没意思，对于长度大于2的数组，直接从第二个元素开始加一个括号到最后即可.
     */
    public String optimalDivision(int[] nums) {
        if(nums == null || nums.length < 1) return "";

        String rs = "";
        if(nums.length < 3) {
            for(int e: nums) rs += "/" + e;
            return rs.substring(1);
        }

        for(int i=0; i<nums.length; i++) {
            if(i==1) rs += "/(" + nums[i];
            else if(i == nums.length-1) rs += "/" + nums[i] + ")";
            else rs += "/" + nums[i];
        }
        return rs.substring(1);
    }
}
