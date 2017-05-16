package exam;

import java.util.*;

/**
 * author: cshuo
 * date: 2017/4/27
 * version: 1.0
 * description:
 */
public class BD01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int total = in.nextInt();
            Set<Integer> st = new TreeSet<>();
            for(int i=0; i<total; i++){
                st.add(in.nextInt());
            }
            if(st.size() < 3)
                System.out.println(-1);
            else{
                Iterator<Integer> itr = st.iterator();
                int val;
                for(int i=0; itr.hasNext(); i++){
                    val = itr.next();
                    if(i==2){
                        System.out.println(val);
                    }
                }
            }

        }
    }
}
