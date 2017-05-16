package exam;

/**
 * author: cshuo
 * date: 2017/5/7
 * version: 1.0
 * description:
 */
import java.util.ArrayList;

import java.util.Scanner;

public class TC02{
    static Character[] key2 = { 'a', 'b', 'c' };
    static Character[] key3 = { 'd', 'e', 'f' };
    static Character[] key4 = { 'g', 'h', 'i' };
    static Character[] key5 = { 'j', 'k', 'l' };
    static Character[] key6 = { 'm', 'n', 'o' };
    static Character[] key7 = { 'p', 'q', 'r', 's' };
    static Character[] key8 = { 't', 'u', 'v' };
    static Character[] key9 = { 'w', 'x', 'y', 'z' };

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String line = input.nextLine();
        String numbers = input.nextLine();
        String[] words = line.split(" ");
        for(int i=0;i<words.length;i++){
            words[i]=words[i].toLowerCase();
        }

        char[] nums = numbers.toCharArray();

        ArrayList<String> list = new ArrayList<>();
        list.add("");

        for (int i = 0; i < nums.length; i++) {
            switch (nums[i]) {
                case '2':
                    list = addChar(list, key2);
                    break;
                case '3':
                    list = addChar(list, key3);
                    break;
                case '4':
                    list = addChar(list, key4);
                    break;
                case '5':
                    list = addChar(list, key5);
                    break;
                case '8':
                    list = addChar(list, key6);
                    break;
                case '6':
                    list = addChar(list, key7);
                    break;
                case '7':
                    list = addChar(list, key8);
                    break;
                case '9':
                    list = addChar(list, key9);
                    break;
                default:
            }
        }

        int max=0;
        String maxWord=words[0];
        for(String word:words){
            for(String want:list){
                int len=compute(word.toCharArray(), want.toCharArray());
                if(len>max){
                    max=len;
                    maxWord=word;
                }
            }
        }

        System.out.println(maxWord);
    }

    private static ArrayList<String> addChar(ArrayList<String> list, Character[] keys) {
        ArrayList<String> nArrayList = new ArrayList<>();
        for (String s1 : list) {
            for (char key : keys) {
                nArrayList.add(s1 + key);
            }
        }
        return nArrayList;
    }

    public static int compute(char[] str1, char[] str2) {
        int substringLength1 = str1.length;
        int substringLength2 = str2.length;

        // 构造二维数组记录子问题A[i]和B[j]的LCS的长度
        int[][] opt = new int[substringLength1 + 1][substringLength2 + 1];

        // 从后向前，动态规划计算所有子问题。也可从前到后。
        for (int i = substringLength1 - 1; i >= 0; i--) {
            for (int j = substringLength2 - 1; j >= 0; j--) {
                if (str1[i] == str2[j])
                    opt[i][j] = opt[i + 1][j + 1] + 1;// 状态转移方程
                else
                    opt[i][j] = Math.max(opt[i + 1][j], opt[i][j + 1]);// 状态转移方程
            }
        }
//      System.out.println("substring1:" + new String(str1));
//      System.out.println("substring2:" + new String(str2));
//      System.out.print("LCS:");

        int i = 0, j = 0;
        while (i < substringLength1 && j < substringLength2) {
            if (str1[i] == str2[j]) {
                //System.out.print(str1[i]);
                i++;
                j++;
            } else if (opt[i + 1][j] >= opt[i][j + 1])
                i++;
            else
                j++;
        }
        //System.out.println();
        return opt[0][0];
    }

}

