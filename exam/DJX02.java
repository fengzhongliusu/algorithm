package exam;

/**
 * author: cshuo
 * date: 2017/5/7
 * version: 1.0
 * description:
 */
import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DJX02{
    private static HashMap<Character, String> map;

    public static void main(String[] args){
        map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String dic = sc.nextLine();
            String[] parts = dic.trim().split("\\s+");
            String nums = sc.nextLine();

            String res = "";
            int resLCS = Integer.MIN_VALUE;
            for (String s : parts){
                int tmp = LCS(nums, s);
                if (tmp > resLCS){
                    res = s;
                    resLCS = tmp;
                }
            }
            System.out.println(res);
        }
    }

    public static int LCS(String nums, String s){

        int [][] dp = new int[nums.length() + 1][s.length() + 1];


        for (int i = 0; i < nums.length(); i++)
        {
            for (int j = 0; j < s.length(); j++)
            {
                if (map.get(nums.charAt(i)).contains(String.valueOf(s.charAt(j)).toLowerCase()))
                {
                    dp[i+1][j+1] = dp[i][j] + 1;
                }
                else
                {
                    dp[i+1][j+1] = Math.max(dp[i][j+1], dp[i+1][j]);
                }
            }
        }
        return dp[nums.length()][s.length()];
    }
}

