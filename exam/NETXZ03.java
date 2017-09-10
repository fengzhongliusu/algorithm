package exam;
import java.util.*;

/**
 * Created by cshuo on 2017/9/9
 */
public class NETXZ03 {
    static int max;
    static int count;
    static String str;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            str = in.next();
            max = 0;
            count = 0;
            int pairs = str.length() / 2;
            traverse("", 0, 0, pairs);
//            generateParenthesis(pairs);
            System.out.println(count);
        }
        in.close();
    }

    public static void traverse(String s, int lnum, int rnum, int n){
        if(lnum == n && rnum == n){
            if(s.equals(str)) return;
            int cs = lcSubseq(s, str);
            if(cs > max) {
                max = cs;
                count = 1;
            } else if(cs == max) {
                count += 1;
            }
            return;
        }
        if(lnum < n){
            traverse(s+'(', lnum+1, rnum, n);
        }
        if(rnum < lnum){
            traverse(s+')', lnum, rnum+1, n);
        }
    }

//    public static void generateParenthesis(int n)
//    {
//        List<List<String>> lists = new ArrayList<>();
//        lists.add(Collections.singletonList(""));
//
//        for (int i = 1; i <= n; ++i)
//        {
//            final List<String> list = new ArrayList<>();
//
//            for (int j = 0; j < i; ++j)
//            {
//                for (final String first : lists.get(j))
//                {
//                    for (final String second : lists.get(i - 1 - j))
//                    {
//                        list.add("(" + first + ")" + second);
//                    }
//                }
//            }
//
//            lists.add(list);
//        }
//
//        for(String s: lists.get(lists.size()-1)) {
//            if(s.equals(str)) continue;
//            int cs = lcSubseq(s, str);
//            if(cs > max) {
//                max = cs;
//                count = 1;
//            } else if(cs == max) count++;
//        }
//    }

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
}
