package sword;

/**
 * Created by cshuo on 2017/8/14
 * n个小朋友报数,从0开始到m-1, 第m-1个出列，下一个继续从0开始新一轮的报数，求出最后一个出列的小朋友的序列号。
 * 使用数组模拟循环, sign[]记录出列的小朋友。
 */
public class LastRemaining {
    public int LastRemaining_Solution(int n, int m) {
        if(n < 1 || m < 1) return -1;
        int[] sign = new int[n];
        int i=-1, count=0, num = 0;
        while(num < n) {
            i = (i+1)% n;
            if(sign[i] == -1) continue;
            if(++count == m) {
                sign[i] = -1;
                count = 0;
                num++;
            }
        }
        return i;
    }
}
