package exam;

import java.net.ServerSocket;
import java.util.Scanner;

/**
 * author: cshuo
 * date: 2017/3/31
 * version: 1.0
 * description:
 */
public class MS01 {
    private static int N;
    private static int P, Q;
    private static double sum;

    static class Node{
        int get_sign;
        int prob;
        int get_num;
        Node left;
        Node right;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int p,q,n;
        p = sc.nextInt();
        q = sc.nextInt();
        n = sc.nextInt();
        double[] records = new double[101];
        for (int i = 1; i <= n; i++) {
            for (int k = 100; k >= 0; k--) {
                records[k] = 1 + k * 0.01 * records[p/(1 << (n-i))] + (1-k * 0.01) * records[Math.min(k+q, 100)];
            }

        }
        System.out.println(records[p]);

//        P = sc.nextInt();
//        Q = sc.nextInt();
//        N = sc.nextInt();
//        sum = 0;
//        Node root = new Node();
//        root.get_sign = -1;
//        root.prob = 0;
//        root.get_num = 0;
//        constructT(root, 0);
//        iterateT(root, 1.0, 0);
//        System.out.println(sum);
    }

    public static void constructT(Node node, int high){
        if(node.get_num == N) return;

        int childGetP;
        if(node.get_sign == -1){
            childGetP = P;
        }
        else if(node.get_sign == 1){
            childGetP = (int)Math.floor(node.prob / Math.pow(2, high));
//            System.out.println("high: " + high + " ; prob : " + childGetP);
        }
        else{
            childGetP = node.prob + Q > 100 ? 100:node.prob+Q;
        }

        if(childGetP > 0){
            Node left = new Node();
            node.left = left;
            left.get_sign = 1;
            left.prob = childGetP;
            left.get_num = node.get_num + 1;
//            System.out.println("construct left: " + left.prob + " high : " + high + " Num: " + node.get_num);
            constructT(left, high+1);
        }

        if(childGetP < 100){
            Node right = new Node();
            node.right = right;
            right.get_sign = 0;
            right.prob = 100 - childGetP;
            right.get_num = node.get_num;
            constructT(right, high+1);
        }
    }

    public static void iterateT(Node node, double tmp, int high){
        if(node == null) return;

        if(node.left == null && node.right == null){
            if(node.get_sign != -1)
                tmp *= (node.prob / 100.0);
            sum += high * tmp;
//            System.out.println(high + "*" + tmp);
            return;
        }

        if(node.get_sign != -1){
            tmp *= (node.prob/100.0);
        }

        iterateT(node.left, tmp, high+1);
        iterateT(node.right, tmp, high+1);
    }
}
