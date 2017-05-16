package leetcode;

import java.util.Stack;

/**
 * author: cshuo
 * date: 2017/5/4
 * version: 1.0
 * description: 汉诺塔实现, 基于栈, 递归实现
 */
public class HanoiTower {
    private Stack<Integer> st;
    private int index;

    public static void main(String[] args) {
        HanoiTower t1 = new HanoiTower(1);
        HanoiTower t2 = new HanoiTower(2);
        HanoiTower t3 = new HanoiTower(3);

        for(int i=3; i>0; i--) t1.add(i);

        t1.moveDisks(3, t3, t2);
        t1.printTower();
        t3.printTower();
    }

    public HanoiTower(int index){
        st = new Stack<>();
        this.index = index;
    }

    public int getIndex(){
        return this.index;
    }

    public void printTower(){
        System.out.print("Tower_"+getIndex() + ": ");
        while(!st.isEmpty()){
            System.out.print(st.pop() + " ");
        }
        System.out.println();
    }

    public void add(int d){
        if(!st.isEmpty() && st.peek() <= d){
            System.out.println("Operation not permitted...");
            return;
        }
        st.add(d);
    }

    public void moveTo(HanoiTower t){
        if(st.isEmpty()) {
            System.out.println("EmptyTower...Operation not permitted...");
            return;
        }
        int val = st.pop();
        t.add(val);
        System.out.println("Move " + val + " From " + getIndex() + " to " + t.getIndex());
    }

    public void moveDisks(int n, HanoiTower dest, HanoiTower buf){
        if(n<1) return;
        moveDisks(n-1, buf, dest);
        moveTo(dest);
        buf.moveDisks(n-1, dest, this);
    }

}
