package exam;

import java.util.Scanner;

/**
 * author: cshuo
 * date: 2017/5/7
 * version: 1.0
 * description:
 */
public class DD02 {

    private String[] alphabet = {"", "", "abc", "def", "ghi","jkl", "mno", "pqrs", "tuv", "wxyz"};
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String sentence = in.nextLine();
            String num = in.next();
            String[] words = sentence.split("\\s+");
        }
    }

    public int similty(String num, String word){
        String str1 = alphabet[num.charAt(0)-'0'];
        String str2 = alphabet[num.charAt(1)-'0'];
        String str3 = alphabet[num.charAt(2)-'0'];
        for(int i=0; i<str1.length(); i++){
        }
        return 0;
    }

}
