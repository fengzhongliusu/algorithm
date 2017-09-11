package exam;

import java.util.*;

/**
 * Created by cshuo on 2017/9/9
 */

public class NETXZ01 {
    static class Node {
        boolean visited;
        int no;
        List<Node> child;
        public Node(int no) {
            this.no = no;
            this.child = new ArrayList<>();
        }
    }
    static int maxLen = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            maxLen = 0;
            int n = in.nextInt();
            int l = in.nextInt();
            Node[] city = new Node[n];
            for(int i=0; i<n; i++){
                city[i] = new Node(i);
            }
            for(int i=0; i<n-1; i++) {
                int tmp = in.nextInt();
                city[tmp].child.add(city[i+1]);
                city[i+1].child.add(city[tmp]);
            }
            city[0].visited = true;
            getMax(city[0], l, 0, 0);
            System.out.println(maxLen+1);
        }
        in.close();
    }

    public static void getMax(Node root, int l, int depth, int num) {
        if(depth == l) {
            maxLen = Math.max(maxLen, num);
            return;
        }
        for(int i=0; i<root.child.size(); i++) {
            if(root.child.get(i).visited) {
                getMax(root.child.get(i), l, depth+1, num);
            } else {
                root.child.get(i).visited = true;
                getMax(root.child.get(i), l, depth+1, num+1);
                root.child.get(i).visited = false;
            }
        }
    }
}
