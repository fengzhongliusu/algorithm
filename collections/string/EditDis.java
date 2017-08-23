package collections.string;

/**
 * Created by cshuo on 2017/8/13
 * Given two strings str1 and str2 and below operations that can performed on str1.
 * Find minimum number of edits (operations) required to convert ‘str1’ into ‘str2’.
 *
 Insert
 Remove
 Replace
 All of the above operations are of equal cost.
 */
public class EditDis {
    static int[][] dp;

    public static void main(String[] args) {
        String s1 = "dinitrophenylhydrazine", s2 = "benzalphenylhydrazone";
        System.out.println(minDistance(s1, s2));
    }

    /**
     * dp[i][j]: 长度为i和j的前缀子串.
     * 递推公式: dp[i][j] = dp[i-1][j-1]     //s1[i] == s2[j-1]
     *                   = min(
     *                     dp[i-1][j],      // 删除s1[i]
     *                     dp[i][j-1],      // 增加
     *                     dp[i-1][j-1]     // 替换
     *                     )
     */
    public int minDis(String word1, String word2) {
        if(word1 == null || word2 == null) return -1;
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m+1][n+1];
        for(int i=0; i<=m; i++)
            for(int j=0; j<=n; j++) {
                if(i == 0 || j == 0) dp[i][j] = i + j;
                else if(word1.charAt(i-1) == word2.charAt(j-1)) dp[i][j] = dp[i-1][j-1];
                else dp[i][j] = 1 + Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]);
            }
        return dp[m][n];
    }

    // 递归方法，复杂度指数级别.
    public static int minDistance(String word1, String word2) {
        if(word1 == null || word2 == null) return -1;
        dp = new int[word1.length()+1][word2.length()+1];
        for(int i=0; i<=word1.length(); i++)
            for(int j=0; j<=word2.length(); j++)
                dp[i][j] = -1;
        return helper(word1, word2, word1.length(), word2.length());
    }
    public static int helper(String s1, String s2, int l1, int l2) {
        System.out.println(l1 + ", " + l2);
        if(l1 == 0 || l2 == 0){
            dp[l1][l2] = l1 + l2;
            return l1 + l2;
        }
        if(s1.charAt(l1-1) == s2.charAt(l2-1)){
            return dp[l1-1][l2-1]<0 ? helper(s1, s2, l1-1, l2-1) : dp[l1-1][l2-1];
        }
        else {
            int add = dp[l1][l2-1]<0 ? helper(s1, s2, l1, l2-1) : dp[l1][l2-1];
            int remove = dp[l1-1][l2]<0 ? helper(s1, s2, l1-1, l2) : dp[l1-1][l2];
            int replace = dp[l1-1][l2-1]<0 ? helper(s1, s2, l1-1, l2-1) : dp[l1-1][l2-1];
            return 1 + Math.min(Math.min(add, remove), replace);
        }
    }
}

