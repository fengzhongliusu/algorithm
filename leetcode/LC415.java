package leetcode;

/**
 * author: cshuo
 * date: 2017/4/14
 * version: 1.0
 * description: 大数相加
 */
public class LC415 {
    public static String addStrings(String num1, String num2) {
        int i = num1.length() - 1, j = num2.length() - 1, carry = 0, sum;
        StringBuilder rs = new StringBuilder();
        while(i >= 0 || j >=0){
            sum = carry;
            if(i >=0) sum += num1.charAt(i--) - '0';
            if(j >=0) sum += num2.charAt(j--) - '0';
            rs.append(sum % 10);
            carry = sum / 10;
        }
        if(carry == 1) rs.append(1);
        return rs.reverse().toString();
    }


    /**
     * @param a
     * @param b
     * @return for practicing.
     */
    public static String exer(String a, String b){
        return "";
    }

    public static void main(String[] args) {
        System.out.println(exer("12382928328392389", "89999999999999999"));
        long a1 = 12382928328392389l;
        long a2 = 89999999999999999l;
        System.out.println(a1+a2);
    }
}
