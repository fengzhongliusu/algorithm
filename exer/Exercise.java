package exer;

import com.sun.tools.corba.se.idl.StringGen;

import java.util.*;

/**
 * author: cshuo
 * date: 2017/6/15
 * version: 1.0
 * description:
 */
class Node {
    int val;
    Node next;
    public Node(int val) {this.val = val;}
}

public class Exercise {
    public static void main(String[] args) {
        Node[] nodes = new Node[3];
        nodes[0] = new Node(1);
        if(nodes[1] == null) System.out.println("ok");
        if(nodes[0] == null) System.out.println(", too");
        nodes[0].val ++;
        System.out.println(nodes[0].val);
    }
}
