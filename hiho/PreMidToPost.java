import java.util.ArrayList;
import java.util.*;

/**
 * author: cshuo
 * date: 2017/3/22
 * version: 1.0
 * description: generate the post order of a binary tree based on the pre-order and mid-order traversing.
 * 想法：递归的找跟节点
 */
public class PreMidToPost {
    public static void getPostOrder(int[] pre, int p_bg, int[] mid, int m_bg, int len, List st){
        if(len < 1) return;
        int root=m_bg;
        while(mid[root] != pre[p_bg]){
            root ++;
        }
        st.add(0, pre[p_bg]);
        getPostOrder(pre, root+1, mid, root+1, len-root+m_bg-1, st);  //right
        getPostOrder(pre, p_bg+1, mid, m_bg, root-m_bg, st);  //left
    }

    public static void main(String[] args) {
        List ls = new ArrayList<Integer>();
        int[] pre = new int[]{1,2,4,3,5,8};
        int[] mid = new int[]{4,2,1,5,3,8};

        PreMidToPost.getPostOrder(pre, 0, mid, 0, pre.length, ls);
        for (Object l : ls) System.out.print(l + " ");
        System.out.println();
    }
}
