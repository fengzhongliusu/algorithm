package leetcode;

/**
 * author: cshuo
 * date: 2017/4/14
 * version: 1.0
 * description:
 */
public class LC67 {
    public static void main(String[] args) {
        System.out.println(LC67.addBinary("1", "111"));

        Integer it = Integer.parseInt("11", 2);
        System.out.println(Integer.toBinaryString(it));
    }

    public static String addBinary(String a, String b) {
        StringBuilder res= new StringBuilder();
        int carry = 0;
        int min_len = Math.min(a.length(), b.length());
        int end_a = a.length()-1, end_b = b.length()-1;
        while(min_len -- > 0){
            if(a.charAt(end_a) == '1' && b.charAt(end_b) == '1'){
                if(carry == 0) res.append(0);
                else res.append(1);
                carry = 1;
            }
            else if (a.charAt(end_a) == '0' && b.charAt(end_b) == '0'){
                if(carry == 0) res.append(0);
                else res.append(1);
                carry = 0;
            } else {
                if(carry == 0) res.append(1);
                else res.append(0);
            }
            end_a--;
            end_b--;
        }
        while(end_a >= 0){
            if(a.charAt(end_a) == '1')
                if(carry == 1) res.append(0);
                else res.append(1);
            else{
                if(carry == 1) res.append(1);
                else res.append(0);
                carry = 0;
            }
            end_a --;
        }
        while(end_b >= 0){
            if(b.charAt(end_b) == '1')
                if(carry == 1) res.append(0);
                else res.append(1);
            else{
                if(carry == 1) res.append(1);
                else res.append(0);
                carry = 0;
            }
            end_b--;
        }
        if(carry == 1) res.append(1);
        return res.reverse().toString();
    }


    /**
     * @param a
     * @param b
     * @return
     * 更精炼...
     */
    public String addBinary2(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() -1, carry = 0;
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (j >= 0) sum += b.charAt(j--) - '0';
            if (i >= 0) sum += a.charAt(i--) - '0';
            sb.append(sum % 2);
            carry = sum / 2;
        }
        if (carry != 0) sb.append(carry);
        return sb.reverse().toString();
    }
}

