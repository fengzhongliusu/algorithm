package sword;

/**
 * Created by cshuo on 2017/7/24
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 */
public class RegularMatch {
    /**
     * @param str
     * 动态规划，递推公式如下；
     * dp[i][j]: dp[i-1][j-1]   if s[l] == p[m] || p[m] == '.'
     *           dp[i-1][j] || dp[i][j-2]   if p[m] == '*' && (p[m-1] == s[l] || p[m-1] == '.')
     *           dp[i][j-2]  if p[m] == '*' && p[m-1] != s[l]
     */
    public boolean match(char[] str, char[] pattern) {
        boolean [][] dp = new boolean[str.length+1][pattern.length+1];
        dp[0][0] = true;
        for(int j=1; j<pattern.length+1; j++)
            if(pattern[j-1] == '*')
                dp[0][j] = dp[0][j-2];

        for(int i=1; i<str.length+1; i++) {
            for(int j=1; j<pattern.length+1; j++) {
                if(pattern[j-1] == '.' || str[i-1] == pattern[j-1])
                    dp[i][j] = dp[i-1][j-1];
                else if(pattern[j-1] == '*' && (pattern[j-2] == str[i-1] || pattern[j-2] == '.'))
                    dp[i][j] = dp[i-1][j] || dp[i][j-2];
                else if(pattern[j-1] == '*' && pattern[j-2] != str[i-1])
                    dp[i][j] = dp[i][j-2];
            }
        }
        return dp[str.length][pattern.length];
    }
}
