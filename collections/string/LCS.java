package collections.string;

/**
 * author: cshuo
 * date: 2017/4/26
 * version: 1.0
 * description: 最长公共子序列, 最长公共子串
 * url: http://www.cnblogs.com/en-heng/p/3963803.html
 */
public class LCS {
    public static void main(String[] args) {
        System.out.println(lcSubseq("", ""));
        System.out.println(lcSubStr("", ""));
    }

    /**
     * 最长公共子序列
     * @param str1
     * @param str2
     * @return
     */
    public static int lcSubseq(String str1, String str2){
        int[][] dp = new int[str1.length()+1][str2.length()+1];
        for(int i=0; i<str1.length(); i++){
            for(int j=0; j<str2.length(); j++){
                if(str1.charAt(i) == str2.charAt(j))
                    dp[i+1][j+1] = dp[i][j] + 1;
                else
                    dp[i+1][j+1] = Math.max(dp[i+1][j], dp[i][j+1]);
            }
        }
        return dp[str1.length()][str2.length()];
    }

    /**
     * 最长公共子串
     * @param str1
     * @param str2
     * @return
     */
    public static int lcSubStr(String str1, String str2){
        int max_len = 0;
        int[][] dp = new int[str1.length()+1][str2.length()+1];
        for(int i=0; i<str1.length(); i++)
            for(int j=0; j<str2.length(); j++){
                if(str1.charAt(i) == str2.charAt(j)){
                    dp[i+1][j+1] = dp[i][j] + 1;
                    max_len = Math.max(dp[i+1][j+1], max_len);
                }
                else
                    dp[i+1][j+1] = 0;
            }
        return max_len;
    }
}
