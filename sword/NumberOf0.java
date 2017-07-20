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
        System.out.println(countOne(0x80000000));
    }
    public static int countZero(int num){
        int count;
        for(count=0; num!=0; num>>=1){
            count += 1-(num&1);
        }
        return count;
    }

    /**
     * 每次通过和减一后的值相与来消除最右的1.
     */
    public static int countOne(int num) {
        int count = 0;
        while(num != 0) {
            count += 1;
            num = num & (num - 1);
        }
        return count;
    }
}
