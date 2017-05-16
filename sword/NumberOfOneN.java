package sword;

/**
 * author: cshuo
 * date: 2017/5/7
 * version: 1.0
 * description:
 */
public class NumberOfOneN {
    public static void main(String[] args) {
        System.out.println(countOne(10));
    }

    /**
     * @param n
     * @return
     * 解释详见: http://www.cnblogs.com/jy02414216/archive/2011/03/09/1977724.html
     */
    public static int countOne(int n){
        int count=0, itr=1, hi, p, low;
        while(n/itr != 0){
            hi = n/itr/10;
            p = n/itr%10;
            low = n - n/itr*itr;
            if(p > 1)
                count += (hi+1)*itr;
            else if(p == 1)
                count += hi*itr + low+1;
            else
                count += hi*itr;
            itr *= 10;
        }
        return count;
    }
}
