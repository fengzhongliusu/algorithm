package leetcode;
import java.util.*;

/**
 * Created by cshuo on 2017/8/12
 *
 * There are a total of n courses you have to take, labeled from 0 to n - 1.
 Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
 Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

 For example:
 2, [[1,0]]
 There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.

 2, [[1,0],[0,1]]
 There are a total of 2 courses to take. To take course 1 you should have finished course 0,
 and to take course 0 you should also have finished course 1. So it is impossible.

 * 思路: 拓扑排序.
 * 过程：首先建立邻接表，每个节点记录其邻接节点以及入度, 使用一个栈记录入度为0的节点，每次从栈中弹出入度为0的节点，并将其邻接节点的入度减一，
 * 同时判断减一后是否为0，若为0，则压入栈中。记录入栈的节点总数，若为节点总数，则说明拓扑排序涵盖了所有节点，即不存在环，课程安排合理。
 */

public class LC207 {

    class Node {
        int in;
        List<Integer> adj = new ArrayList<>();
    }

    public boolean canFinish(int numCourses, int[][] prete) {
        if(prete == null || prete.length < 1) return true;
        // 初始化邻接表.
        Node[] nodes = new Node[numCourses];
        for(int i=0; i<prete.length; i++) {
            int label = prete[i][0], adj = prete[i][1];
            if(nodes[label] == null) nodes[label] = new Node();
            if(nodes[adj] == null) nodes[adj] = new Node();
            nodes[adj].in++;
            nodes[label].adj.add(adj);
        }
        // 逐个去除入度为0的节点.
        Stack<Node> leads = new Stack<>();
        int counts=0;
        for(Node e: nodes) {
            if(e == null) counts++;      // 依赖表中没出现的课程.
            else if(e.in == 0) leads.push(e);
        }
        while(!leads.isEmpty()) {
            Node tmp = leads.pop();
            counts++;
            for(int e: tmp.adj) {
                if(--nodes[e].in == 0) leads.push(nodes[e]);
            }
        }
        return counts >= numCourses;
    }
}
