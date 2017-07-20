package hiho;

import java.util.*;

/**
 * author: cshuo
 * date: 2017/7/19
 * version: 1.0
 * description:
 */
public class MS02 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numCase = in.nextInt();
        int N, R, maxSum, sum;
        int[] ages;
        int[] prices;
        int[] indexs;
        for(int i = 0; i<numCase; i++) {
            N = in.nextInt();
            R = in.nextInt();
            ages = new int[N];
            prices = new int[N];
            indexs = new int[N];
            maxSum = -1;
            sum = 0;

            for(int k=0; k<N; k++){
                indexs[k] = k;
                ages[k] = in.nextInt();
            }
            for(int k=0; k<N; k++) prices[k] = in.nextInt();

            List<List<Integer>> permus = permuteUnique(indexs);
            for(List<Integer> p: permus){
                sum = calSum(p, R, prices, ages);
                if(sum > maxSum) maxSum = sum;
            }
            System.out.println(maxSum);
        }
        in.close();
    }

    public static int calSum(List<Integer> permus, int R, int[] prices, int[] ages) {
        int sum = 0, sign;
        List<Integer> toBuy = new ArrayList<>();

        int left, right;
        for(int i=0; i<permus.size();) {
            sign = 0;
            if(i < R) left = 0;
            else left = i - R;
            for(int j=i-1; j>=left; j--)
                if(ages[permus.get(j)] > ages[permus.get(i)]) sign = -1;

            if(i+R < permus.size()) right = i+R;
            else right = permus.size()-1;
            for(int j=i+1; j<=right; j++)
                if(ages[permus.get(j)] > ages[permus.get(i)]) sign = -1;
            if(sign == 0){
                toBuy.add(permus.get(i));
                i += 3;
            }
            else i++;
        }
        for(int tb: toBuy){
            sum += prices[tb];
        }
        return sum;
    }


    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<Integer>(), nums, new boolean[nums.length]);
        return list;
    }

    private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, boolean [] used){
        if(tempList.size() == nums.length){
            list.add(new ArrayList<>(tempList));
        } else{
            for(int i = 0; i < nums.length; i++){
                // 只有当连续相同字符的前一个被被使用, 当前的这个才能被使用, 避免用同一个字符开始一个新的排列.
                if(used[i] || i > 0 && nums[i] == nums[i-1] && !used[i - 1]) continue;
                used[i] = true;
                tempList.add(nums[i]);
                backtrack(list, tempList, nums, used);
                used[i] = false;
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
