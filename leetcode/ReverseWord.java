package leetcode;


/**
 * Created by cshuo on 2017/3/16
 */
public class ReverseWord {
    public String reverseWords(String s){
        String[] words = s.split(" +");
        StringBuilder st = new StringBuilder();
        for(int j=words.length-1; j>=0; j--){
            st.append(words[j] + " ");
        }
        return st.toString().trim();
    }

    public static void main(String[] args) {
        String s = "the sky is blue";
        ReverseWord rw = new ReverseWord();
        System.out.println(rw.reverseWords(s));
    }
}
