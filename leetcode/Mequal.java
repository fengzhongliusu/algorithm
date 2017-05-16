package leetcode;

/**
 * This is a test.
 */
public class Mequal {

/** 请完成下面这个函数，实现题目要求的功能 **/
    /**
     * 从数组中选取三个元素剔除，将数组分成四段，每段的和相等，元素均为正整数
     **/
    public  boolean resolve(int[] A) {
        int sum;
        int m_start = 0;
        int second, third, find_sec, find_third;
        int temp;
        while(++m_start < A.length - 5){
            sum = sum_n(A, 0, m_start-1);
            second = m_start +2;
            find_sec = 0;
            while(second < A.length -3){
                temp = sum_n(A, m_start+1, second-1);
                if(temp == sum){
                    find_sec = 1;
                    break;
                } else if(temp > sum){
                    break;
                }
                second += 1;
            }
            if(find_sec == 0){
                continue;
            }

            third = second + 2;
            find_third = 0;
            while(third< A.length -1){
                if(sum_n(A, second+1, third-1) == sum && sum_n(A, third+1, A.length-1) == sum){
                    find_third = 1;
                    break;
                }
                third+= 1;
            }
            if(find_third == 0){
                continue;
            }
            return true;
        }
        return false;
    }

    public int sum_n(int []l, int m, int n){
        int sum = 0;
        for(int i=m; i<n+1; i++){
            sum += l[i];
        }
        return sum;
    }

    public static void main(String []args){
        int[] A = {1,4,6,2,3,9,4,1,5};
        Mequal e = new Mequal();
        System.out.println(e.resolve(A));
    }
}
