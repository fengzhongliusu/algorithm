package exer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * author: cshuo
 * date: 2017/4/7
 * version: 1.0
 * description:
 */
public class CustomSort {
    static class Node {
        String name;
        int degree;
        public Node(String name, int degree){
            this.name = name;
            this.degree = degree;
        }
    }

    public static void main(String[] args) {
        ArrayList<Node> list = new ArrayList<Node>();
        Node n1 = new Node("a", 5);
        Node n2 = new Node("b", 2);
        Node n3 = new Node("c", 3);
        list.add(n1);
        list.add(n2);
        list.add(n3);

        Collections.sort(list, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.degree - o2.degree;
            }
        });

        for(Node ele: list){
            System.out.println(ele.name + " " + ele.degree);
        }
    }
}
