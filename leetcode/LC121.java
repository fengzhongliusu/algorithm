package leetcode;

public class LC121 {
    /**
     * 股票一次交易最大收益计算
     * O(n), 记录已经遍历过元素的最小值，跟当前元素进行比较即可.
     * @param prices
     */
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length < 1) return 0;
        int minIndex = prices[0], max = 0;
        for(int i=1; i<prices.length; i++) {
            if(prices[i] < minIndex) {
                minIndex = prices[i];
            } else {
                int gain = prices[i]-minIndex;
                max =  gain > max ? gain : max;
            }
        }
        return max;
    }
}
