package leetcode;

/**
 * find the abscent number
 */
public class FindNum {
    public static int find(int[] nums, int bg, int end){
        if(bg == end - 1)
            if(bg + 1 == nums[bg])
                return bg + 2;
            else
                return 1;

        int mid = (bg + end) / 2;
        if(nums[mid] > mid + 1)
            return find(nums, bg, mid);
        else
            return find(nums, mid, end);
    }

    public static void main(String[] args) {
        int [] nums = {2,3};
        System.out.println(FindNum.find(nums, 0, 1));
    }
}
