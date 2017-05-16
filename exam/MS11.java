package exam;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * author: cshuo
 * date: 2017/3/31
 * version: 1.0
 * description:
 */
public class MS11 {
    private static int N;
    private static int P, Q;
    private static double sum;

    static class Node{
        int get_sign;
        int prob;
        int get_num;
        double totalP;
        Node left;
        Node right;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        P = sc.nextInt();
        Q = sc.nextInt();
        N = sc.nextInt();
        sum = 0;
        Node root = new Node();
        root.get_sign = -1;
        root.prob = 0;
        root.totalP = 1;
        root.get_num = 0;
        constructT(root, 0);
        DecimalFormat df = new DecimalFormat("#.##");
        System.out.println(df.format(sum));
    }

    public static void constructT(Node node, int high){
        if(node.get_num == N){
            sum += node.totalP * high;
            return;
        }

        int childGetP;
        double l_totalp, r_totalp;
        if(node.get_sign == -1){
            childGetP = P;
        }
        else if(node.get_sign == 1){
            childGetP = (int)Math.floor(node.prob / Math.pow(2, high));
        }
        else{
            childGetP = node.prob + Q > 100 ? 100:node.prob+Q;
        }

        l_totalp = (childGetP / 100.0) * (node.totalP);
        r_totalp = ((100-childGetP) / 100.0) * (node.totalP);

        if(childGetP > 0){
            Node left = new Node();
            node.left = left;
            left.get_sign = 1;
            left.prob = childGetP;
            left.get_num = node.get_num + 1;
            left.totalP = l_totalp;
            constructT(left, high+1);
        }

        if(childGetP < 100){
            Node right = new Node();
            node.right = right;
            right.get_sign = 0;
            right.prob = 100 - childGetP;
            right.get_num = node.get_num;
            right.totalP = r_totalp;
            constructT(right, high+1);
        }
    }
}
