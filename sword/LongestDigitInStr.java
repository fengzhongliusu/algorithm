package sword;

/**
 * Created by cshuo on 2017/8/14
 */
public class LongestDigitInStr {
    public static void main(String[] args) {
        System.out.println(continumax("abcd12345ed125ss123456789"));
    }

    public static int continumax(String str) {
        if(str == null || str.length() < 1) return 0;
        int max = 0, sum = 0;
        for(int i=0; i<str.length(); i++) {
            if(!Character.isDigit(str.charAt(i))) sum = 0;
            else {
                sum += 1;
                if(sum > max) max = sum;
            }
        }
        return max;
    }
}
