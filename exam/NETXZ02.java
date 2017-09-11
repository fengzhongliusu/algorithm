package exam;
import java.util.*;

/**
 * Created by cshuo on 2017/9/9
 */
public class NETXZ02 {
    static boolean isOk = false;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            int cases = in.nextInt();
            for(int i=0; i<cases; i++) {
                isOk = false;
                int len = in.nextInt();
                int[] nums = new int[len];
                for(int j=0; j<len; j++) nums[j] = in.nextInt();
                permuteDup(nums);
//                permuteUnique(nums);
//                permuteDup1(nums);
                if(isOk) System.out.println("Yes");
                else System.out.println("No");
                judge(nums)
                ;
            }
        }
        in.close();
    }


    public static void judge(int[] nums) {
        int mod4=0, mod2=0;
        for(int i=0; i<nums.length; i++) {
            if(nums[i] % 4 == 0) mod4++;
            else if(nums[i] % 2 == 0) mod2++;
        }
        System.out.println(mod4*2 >= nums.length-mod2 ? "Yes" : "No");
    }

    public static void permuteDup1(int[] nums) {
        if(nums == null || nums.length < 1) return;
        Arrays.sort(nums);
        Integer[] list = new Integer[nums.length];
        for(int i=0; i<nums.length; i++) list[i] = nums[i];
        int goon;
        while(true) {
            if(isOk) break;
            if(valid(list)) isOk = true;
            nextPermutation(list);
            goon = 0;
            for(int i=0; i<list.length-1; i++) {
                if(list[i] > list[i+1]) {goon = 1; break;}
            }
            if(goon == 0) break;
        }
    }

    public static void nextPermutation(Integer[] nums) {
        if(nums == null || nums.length < 1) return;
        int i, j;
        for(i=nums.length-1; i>0; i--) {
            if(nums[i-1]<nums[i]) break;
        }
        for(j=nums.length-1; j>=i; j--)
            if(i>0 && nums[j] > nums[i-1]) break;
        if(i>0) swap(nums, j, i-1);
        for(int l=i, r=nums.length-1; l<=r; l++, r--) swap(nums, l, r);
    }

    public static void swap(Integer[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }



    public static void permuteDup(int[] nums) {
        Arrays.sort(nums);
        permutate(nums, 0);
    }

    private static void permutate(int[] nums, int start) {
        if(isOk) return;
        if (start == nums.length) {
            if(valid(nums)) isOk = true;
            return;
        }
        for (int i = start; i < nums.length; i++) {
            if (i != start && nums[start] == nums[i]) continue;
            int tmp = nums[start];
            nums[start] = nums[i];
            nums[i] = tmp;
            permutate(Arrays.copyOf(nums, nums.length), start+1);
        }
    }
//
    public static void permuteUnique(int[] nums) {
        if(nums==null || nums.length==0) return;
        boolean[] used = new boolean[nums.length];
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, used, list);
    }

    public static void dfs(int[] nums, boolean[] used, List<Integer> list){
        if(isOk) return;
        if(list.size()==nums.length){
            if(valid(list)) isOk = true;
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(used[i]) continue;
            if(i>0 &&nums[i-1]==nums[i] && !used[i-1]) continue;
            used[i]=true;
            list.add(nums[i]);
            dfs(nums,used,list);
            used[i]=false;
            list.remove(list.size()-1);
        }
    }

    private static boolean valid(List<Integer> list) {
        for(int i=0; i<list.size()-1; i++) {
            if(list.get(i) * list.get(i+1) % 4 != 0) return false;
        }
        return true;
    }

    private static boolean valid(Integer[] nums) {
        for(int i=0; i<nums.length-1; i++) {
            long l = nums[i], r = nums[i+1];
            if((l*r)% 4 != 0) return false;
        }
        return true;
    }

    private static boolean valid(int[] nums) {
        long l, r;
        for(int i=0; i<nums.length-1; i++) {
            l = nums[i];
            r = nums[i+1];
            if((l*r) % 4 != 0) return false;
        }
        return true;
    }
}

