package hiho;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


/**
 * netease 电子管
 */
public class Netease01 {
    private static String[] numStr = new String[10];
    private static int sum = 0;

    private static void init(){
        int [][] arrage = {{1,2,3,5,6,7},{3,6},{1,3,4,5,7},{1,3,4,6,7},{2,3,4,6},{1,2,4,6,7},
                {1,2,4,5,6,7},{1,3,6},{1,2,3,4,5,6,7},{1,2,3,4,6,7}};
        for(int i = 0; i< 10; i++){
            numStr[i] = concate(arrage[i]);
        }
    }

    public static boolean containsall(String a, String b){
        for(char e: a.toCharArray()){
            if(b.indexOf(e) < 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args){
        init();
        int numTest, numG, N;
        Scanner in = new Scanner(System.in);
        numTest = in.nextInt();
        String []rows;
        char [] temp_l;

        for(int i=0; i< numTest; i++){
            numG = in.nextInt();
            N = in.nextInt();
            rows = new String[numG];
            in.nextLine();
            for(int j = 0; j<numG; j++){
                temp_l =  in.nextLine().trim().replace(" ", "").toCharArray();
                Arrays.sort(temp_l);
                rows[j] = String.valueOf(temp_l);
            }
            ArrayList arr = availNum(rows);
            numOK(N, numG, arr);
            System.out.println(sum);
            sum = 0;
        }
    }

    public static ArrayList availNum(String []strs){
        ArrayList<ArrayList>  arr = new ArrayList<ArrayList>();
        for(String s: strs){
            ArrayList ele = new ArrayList();
            for(int i = 0; i< 10; i++){
                if(containsall(s, numStr[i])) ele.add(i);
            }
            arr.add(ele);
        }
        return arr;
    }

    public static void numOK(int N, int K, ArrayList<ArrayList> arr){
        if (K <= 0) return;
        int numDigt = String.valueOf(N).length();
        if(K < numDigt){
            int temp = 1;
            for(int i =arr.size()-K; i< arr.size(); i++){
                temp *= arr.get(i).size();
            }
            sum = temp;
            return;
        }
        if (K == numDigt){
            int firstNum = (int)(N / Math.pow(10, numDigt-1));
            for(int i = 0; i < arr.get(arr.size()-K).size(); i++){
                if(firstNum == arr.get(arr.size()-K).get(i)){
                    numOK(N - (int)(firstNum*Math.pow(10, numDigt-1)), K-1, arr);
                } else if(firstNum > (int)(arr.get(arr.size()-K).get(i))){
                    int temp = 1;
                    for(int j=arr.size() - K + 1; j < arr.size(); j++){
                        temp *= arr.get(j).size();
                    }
                    sum += temp;
                } else {
                    continue;
                }
            }
        } else {
            numOK(N, numDigt, arr);
        }
    }

    public static String concate(int[] a){
        Arrays.sort(a);
        StringBuilder sb = new StringBuilder(a[0]);
        for(int i = 0; i < a.length; i++){
            sb.append(String.valueOf(a[i]));
        }
        return sb.toString();
    }
}
