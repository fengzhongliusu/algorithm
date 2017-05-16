package leetcode;

/**
 * Created by cshuo on 2017/3/6.
 */
public class sum_i_j {
    private static int[] sum;
    public static void cal_sumij(int[] a){
        int len = a.length;
        sum = new int[len];
        sum[0] = a[0];
        for(int i=1; i<len; i++){
            sum[i] = sum[i-1] + a[i];
        }
    }
    public static int get_i_j(int i, int j){
        return sum[j] - sum[i-1];
    }

    public static void main(String []args){
        int []a = {1,2,3,4,4,5,7,8,8};
        sum_i_j.cal_sumij(a);
        System.out.println(sum_i_j.get_i_j(1,3));
    }
}
