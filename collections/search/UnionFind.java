package collections.search;

/**
 * Created by cshuo on 2017/8/11
 * 基于树的并查集实现.
 */
public class UnionFind {
    int[] prev;

    /**
     * 初始时，每个节点都是一个单独的树.
     */
    public void init(int n) {
        prev = new int[n];
        for(int i=0; i<n;i++) prev[i] = i;
    }

    /**
     * 找到x的根节点，同时对根节点到x的路径进行压缩.
     */
    public int find(int x) {
        int r = x;
        //找到根节点
        while(r != prev[r]) r = prev[r];

        // 路径的压缩. 将路径上中间节点的父节点直接改成跟节点.
        int i=x;
        while(i != r) {
            int tmp = prev[i];
            prev[i] = r;
            i = tmp;
        }
        return r;
    }

    /**
     * 合并两个树.
     */
    public void union(int x, int y) {
        x = find(x);
        y = find(y);
        if(x != y) prev[x] = y;
    }

    /**
     * 判断两个元素是否属于同一个集合.
     */
    public boolean same(int x, int y) {
        return find(x) == find(y);
    }
}
