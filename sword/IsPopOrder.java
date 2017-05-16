package sword;

import java.util.Stack;

/**
 * author: cshuo
 * date: 2017/5/1
 * version: 1.0
 * description: 栈的压入,弹出序列; 根据弹出序列, 模拟压入
 */
public class IsPopOrder {
    public static void main(String[] args) {
        int[] push = {1,2,3};
        int[] pop = {};
        System.out.println(isPopOrder(push, pop));
    }

    public static boolean isPopOrder(int[] pushA, int[] popA){
        if(pushA.length != popA.length) return false;
        int pushedIndex = 0;
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<popA.length; i++){
            while(pushedIndex < pushA.length && (st.size()<1 || st.peek() != popA[i])){
                st.push(pushA[pushedIndex++]);
            }
            if(st.peek() != popA[i]) return false;
            else st.pop();
        }
        return true;
    }
}
