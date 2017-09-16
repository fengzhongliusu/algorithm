package leetcode;

import java.util.*;

public class LC127 {
    /**
     * 思路: BFS, 从beginword开始，每次将编辑距离为1的字符串加入队列，同时标记已经被使用（used);
     * 用depth表示当前bfs的层数，trick是遍历每层之前我们都已经知道该层的节点数目(类似层次遍历二叉树), 所以处理一层后就depth++,
     * 处理某一层若发现与目标字符串相等，则返回depth+1, 若队列处理完了，仍没发现目标字符串，则返回0；
     */
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int depth = 0;
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        int[] used = new int[wordList.size()];
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=0; i<size; i++) {
                String s = q.poll();
                if(s.equals(endWord)) return depth + 1;
                else {
                    for(int j=0; j<wordList.size(); j++) {
                        if(used[j] == 0 && distance1(wordList.get(j), s)) {
                            used[j] = 1;
                            q.offer(wordList.get(j));
                        }
                    }
                }
            }
            ++depth;
        }
        return 0;
    }

    /**
     * 判断两个字符串是否编辑距离为1，调用前已经判断两个字符串是不相等的.
     */
    public static boolean distance1(String s1, String s2) {
        int dis = 0;
        for(int i=0; i<s1.length(); i++) {
            if(s1.charAt(i) != s2.charAt(i)) dis++;
            if(dis > 1) return false;
        }
        return true;
    }

    /**
     * 双端BFS
     */
    public static int ladderLen(String beginWord, String endWord, List<String> wordList) {
        int depth = 1;
        if(!wordList.contains(endWord)) return 0;
        boolean used[] = new boolean[wordList.size()];
        Queue<String> src = new LinkedList<>();
        Queue<String> dest = new LinkedList<>();
        src.offer(beginWord);
        dest.offer(endWord);
        while(!src.isEmpty() && !dest.isEmpty()) {
            if(src.size() > dest.size()) {
                Queue<String> tmp = src;
                src = dest;
                dest = tmp;
            }
            int size = src.size();
            Queue<String> tmp = new LinkedList<>();
            for(int i=0; i<size; i++) {
                String s = src.poll();
                for(int j=0; j<wordList.size(); j++) {
                    if(s.equals(wordList.get(j))) continue;
                    if(distance1(s, wordList.get(j))) {
                        if(dest.contains(wordList.get(j))) return depth + 1;
                        if(!used[j]) {
                            tmp.add(wordList.get(j));
                            used[j] = true;
                        }
                    }
                }
            }
            src = tmp;
            ++depth;
        }
        return 0;
    }

    public static void main(String[] args) {
//        System.out.println(ladderLength("hit", "cog", Arrays.asList("hot","dot","dog","lot","log","cog")));
        System.out.println(ladderLen("hit", "cog", Arrays.asList("hot","dot","dog","lot","log")));
    }
}
