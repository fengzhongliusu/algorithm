package leetcode;

/**
 TAG: Binary search.

 * Created by cshuo on 2017/8/1
 * We are playing the Guess Game. The game is as follows:

 I pick a number from 1 to n. You have to guess which number I picked.

 Every time you guess wrong, I'll tell you whether the number is higher or lower.

 You call a pre-defined API guess(int num) which returns 3 possible results (-1, 1, or 0):

 -1 : My number is lower
 1 : My number is higher
 0 : Congrats! You got it!

  The guess API is defined in the parent class GuessGame.
 int guess(int num);
 */
public class LC374 {
    public int guessNumber(int n) {
        int l=0, r=n, mid, rs;
        while(l <= r) {
            mid = (r-l)/2+l;
            rs = guess(mid);
            if(rs == 0) return mid;
            else if(rs == -1) r = mid-1;
            else l = mid+1;
        }
        return -1;
    }
    public int guess(int num) { return 1;}
}
