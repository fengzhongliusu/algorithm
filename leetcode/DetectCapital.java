package leetcode;

/**
 * Created by cshuo on 2017/7/25
 * Given a word, you need to judge whether the usage of capitals in it is right or not.

 We define the usage of capitals in a word to be right when one of the following cases holds:

 All letters in this word are capitals, like "USA".
 All letters in this word are not capitals, like "leetcode".
 Only the first letter in this word is capital if it has more than one letter, like "Google".
 Otherwise, we define that this word doesn't use capitals in a right way.

 Example 1:
 Input: "USA"
 Output: True
 */
public class DetectCapital {
    public boolean detectCapitalUse(String word) {
        if(word == null || word.length() < 1) return true;
        int count = 0;
        for(int i=0; i<word.length(); i++)
            if(word.charAt(i) <= 'Z') count++;
        return count == word.length() || count == 0 || (count == 1 && word.charAt(0) <= 'Z');
    }
}
