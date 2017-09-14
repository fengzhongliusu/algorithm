package leetcode;

public class LC69 {
    /**
     * 求根sqrt, 牛顿迭代法, f(x) = x^2 - a, 在每一点(x_1, f(x_1))上的斜率都是2*x_1, 且易见该点切线与x轴的交点(x_1+a/x1)/2
     * 比x1更接近sqrt(x_1), 所以经过几轮迭代就可迅速收敛，
     */
    public int mySqrt(int x) {
        long root = x;
        while(root*root > x) root = (root + x/root) >> 1;
        return (int)root;
    }
}
