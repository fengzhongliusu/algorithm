package exam;

import java.util.*;

/**
 * author: cshuo
 * date: 2017/5/18
 * version: 1.0
 * description: 编译器函数依赖问题, 存在循环依赖
 */
public class HWD01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            int row = in.nextInt();
            HashMap<String, ArrayList<String>> map = new HashMap<>();
            Set<String> dealed = new HashSet<>();
            Set<String> linked = new HashSet<>();
            String a, b;
            for(int i=0; i<row*2; i+=2){
                a = in.next();
                b = in.next();
                if(map.get(a) == null){
                    map.put(a, new ArrayList<String>());
                }
                map.get(a).add(b);
            }

            Stack<String> st = new Stack<>();
            st.push("main");
            dealed.add("main");
            String tmp;
            while(!st.isEmpty()){
                tmp = st.pop();
                ArrayList<String> linked_func = map.get(tmp);
                if(linked_func == null) continue;
                linked.addAll(linked_func);
                for(String ele: linked_func){
                    if(!dealed.contains(ele)) st.add(ele);
                }
                dealed.add(tmp);
            }
            System.out.println(linked.size() + 1);
        }
        in.close();
    }
}
