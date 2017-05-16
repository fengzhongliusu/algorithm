package leetcode;

/**
 * author: cshuo
 * date: 2017/3/23
 * version: 1.0
 * description:
 */
public class LC167 {
    public static int[] twoSum(int[] numbers, int target) {
        int[] rt = new int[2];
        int l=0, r = numbers.length - 1;
        int sum = 0;
        while(true){
            while(l+1<r && numbers[l] == numbers[l+1]) l++;
            System.out.println("l: " + l);
            while(r-1>l && numbers[r] == numbers[r-1]) r--;
            System.out.println("r: " + r);
            sum = numbers[l] + numbers[r];
            if(sum == target){
                rt[0] = l+1;
                rt[1] = r+1;
                break;
            }
            else if(sum > target){
                if(r > l + 1) r--;
            }
            else{
                if(l + 1 < r) l++;
            }
        }
        return rt;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1,2,3,4,4,9,56,90};
        int[] rt = LC167.twoSum(a, 8);
        System.out.println(rt[0] + " " + rt[1]);
    }
}
