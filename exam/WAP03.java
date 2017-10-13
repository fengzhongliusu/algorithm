package exam;
import java.util.*;

public class WAP03 {
    static class Node {
        int val;
        Node prev;
        Node next;
        public Node(int val) {this.val = val;}
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            ArrayDeque<Integer> q = new ArrayDeque<>();
            ArrayDeque<Integer> mq = new ArrayDeque<>();
            int dir = 1;
            int n = in.nextInt();
            for(int i=0; i<n; i++) {
                String cmd = in.next();
                if(cmd.equals("pop_back")) {
                    if(q.size() == 0) System.out.println("Error");
                    else {
                        if(dir == 1){
                            System.out.println(q.pollLast());
                            mq.pollLast();
                        }
                        else {
                            System.out.println(q.pollFirst());
                            mq.pollFirst();
                        }
                    }
                } else if(cmd.equals("pop_front")) {
                    if(q.size() == 0) System.out.println("Error");
                    else {
                        if(dir == 1) {
                            System.out.println(q.pollFirst());
                            mq.pollFirst();
                        }
                        else {
                            System.out.println(q.pollLast());
                            mq.pollLast();
                        }
                    }
                }
                else if(cmd.equals("reverse")) {
                    if(dir == 1) dir = -1;
                    else dir = 1;
                } else if(cmd.equals("push_front")) {
                    if(dir == 1){
                        int val = in.nextInt();
                        q.addFirst(val);
                        if(mq.size() > 0 && mq.peekFirst() >= val) mq.addFirst(mq.peekFirst());
                        else mq.addFirst(val);
                    }
                    else{
                        int val = in.nextInt();
                        q.addLast(val);
                        if(mq.size() != 0 && mq.peekLast() >= val) mq.addLast(mq.peekLast());
                        else mq.addLast(val);
                    }
                } else if(cmd.equals("push_back")) {
                    if(dir == 1){
                        int val = in.nextInt();
                        q.addLast(val);
                        if(mq.size() != 0 && mq.peekLast() >= val) mq.addLast(mq.peekLast());
                        else mq.addLast(val);
                    }
                    else{
                        int val = in.nextInt();
                        q.addFirst(val);
                        if(mq.size() != 0  && mq.peekFirst() >= val) mq.addFirst(mq.peekFirst());
                        else mq.addFirst(val);
                    }
                } else {
                    if(q.size() == 0) System.out.println("Error");
                    else System.out.println(Math.max(mq.peekFirst(), mq.peekLast()));
                }
            }
        }
        in.close();
    }
}
