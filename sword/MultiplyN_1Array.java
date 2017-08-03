package sword;

/**
 * Created by cshuo on 2017/8/2
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。
 * 不能使用除法。
 */
public class MultiplyN_1Array {
    public static void main(String[] args) {
    }

    /**
     * 将每一个B[i]的求解分成两个部分，0...i, 和i+1...N-1;
     * 每一部分使用类似前缀积的形式求出即可，复杂度O(N);
     */
    public int[] multiply(int[] A) {
        if(A == null) return null;
        int[] B = new int[A.length];
        int tmp = 1;
        for(int i=0; i<A.length; tmp *= A[i++])
            B[i] = tmp;
        tmp = 1;
        for(int i=A.length-1; i>=0; tmp *= A[i--])
            B[i] *= tmp;
        return B;
    }
}
