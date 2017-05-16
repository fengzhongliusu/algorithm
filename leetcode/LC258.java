package leetcode;

/**
 * author: cshuo
 * date: 2017/4/14
 * version: 1.0
 * description:
 */
public class LC258 {
    public static int addDigits(int num) {
        int sum, tmp;
        while(num >= 10){
            sum = num;
            tmp = 0;
            while(sum > 0){
                tmp += sum % 10;
                sum /= 10;
            }
            num = tmp;
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(addDigits(10));
    }
}
