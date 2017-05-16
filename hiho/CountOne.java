package hiho;

/**
 * 统计一个数字对应二进制形式中1的个数
 * 思路: num & (num-1) 总是能将最后一个1消除.
 */
public class CountOne {
    public static int count_bin_one(int num){
        int count = 0;
        while(num != 0){
            count += 1;
            num = num & (num -1);
        }
        return count;
    }

    public static void main(String[] args) {
        int a = -1;
        System.out.println(CountOne.count_bin_one(a));
    }
}
