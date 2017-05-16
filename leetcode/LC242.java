package leetcode;

/**
 * Created by cshuo, 2017/03/02
 */
public class LC242{
    public boolean isAnagram(String s, String t) {
        int [] countSign = new int[26];
        for(int i = 0; i < s.length(); i++){
            countSign[s.charAt(i)-'a'] += 1;
        }
        for(int i=0; i < t.length(); i++){
            countSign[t.charAt(i)-'a'] -= 1;
            if(countSign[t.charAt(i) - 'a'] <0)
                return false;
        }
        return t.length() == s.length();
    }
    public static void main(String[] args){
        LC242 test = new LC242();
        if(test.isAnagram("asdf","fdsa")){
            System.out.println("ok");
        }
    }
}
