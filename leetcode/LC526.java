/*
Suppose you have N integers from 1 to N. We define a beautiful arrangement as an array that is constructed by these N numbers successfully if one of the following is true for the ith position (1 ? i ? N) in this array:

The number at the ith position is divisible by i.
i is divisible by the number at the ith position.
Now given N, how many beautiful arrangements can you construct?

Example 1:
Input: 2
Output: 2
*/

public class Solution {
    private int sum = 0;

    public int countArrangement(int N) {
        ArrayList<Integer> nums = new ArrayList<>();
        for(int i=1; i<N+1; i++) nums.add(i);
        dfs(nums, 1);
        return sum;
    }

    /*
    * 回溯，每个位置尝试所有可能的数字
    */
    public void dfs(ArrayList<Integer> tmp, int position){
        // all number well placed.
        if(tmp.size() < 1) sum += 1;

        for(Integer num: tmp) {
            if(num % position == 0 || position % num == 0) {
                ArrayList<Integer> arr = new ArrayList<>(tmp);
                arr.remove(num);
                dfs(arr, position+1);
            }
        }
    }
}


/************** Better space complexity ***************/

public class Solution {
    private int sum = 0;

    public int countArrangement(int N) {
        dfs(N, 1, new int[N+1]);
        return sum;
    }

    /*
    * 同样是回溯，不需要创建中间的list变量，但是每次都要遍历整个数组, 1 ... N.
    */
    public void dfs(int N, int position, int[] used){
        // all number well placed.
        if(position > N) sum += 1;
        for(int i = 1; i< N+1; i++) {
          if(used[i] == 0 && (i % position == 0 || position % i == 0)) {
            used[i] = 1;
            dfs(N, position+1, used);
            used[i] = 0;
          }
        }
    }
}
