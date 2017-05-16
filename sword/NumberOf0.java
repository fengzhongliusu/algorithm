package sword;

/**
 * author: cshuo
 * date: 2017/5/1
 * version: 1.0
 * description:
 */
public class NumberOf0 {
    public static void main(String[] args) {
        System.out.println(countZero(8));
    }
    public static int countZero(int num){
        int count;
        for(count=0; num!=0; num>>=1){
            count += 1-(num&1);
        }
        return count;
    }
}
