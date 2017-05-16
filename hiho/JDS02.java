package hiho;

import java.util.*;

/**
 * author: cshuo
 * date: 2017/4/7
 * version: 1.0
 * description:
 */
public class JDS02 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int total, s;
            TreeMap<String, Integer> bmap = new TreeMap<>(Collections.reverseOrder());
            TreeMap<String, Integer> smap = new TreeMap<>(Collections.reverseOrder());
            total = in.nextInt();
            s = in.nextInt();
            String tmp;
            for(int i=0; i<total; i++){
                tmp = in.next();
                if(tmp.equals("B")){
                    tmp += " " + in.nextInt();
                    if(bmap.containsKey(tmp))
                        bmap.put(tmp, bmap.get(tmp) + in.nextInt());
                    else
                        bmap.put(tmp, in.nextInt());
                } else {
                    tmp += " " + in.nextInt();
                    if(smap.containsKey(tmp))
                        smap.put(tmp, smap.get(tmp) + in.nextInt());
                    else
                        smap.put(tmp, in.nextInt());
                }
            }

            Iterator itr;
            itr = smap.keySet().iterator();
            int j = 0;
            while(j++ < s && itr.hasNext()){
                String key = (String) itr.next();
                System.out.println(key + " " + smap.get(key));
            }

            j = 0;
            itr = bmap.keySet().iterator();
            while(j++ < s && itr.hasNext()){
                String key = (String) itr.next();
                System.out.println(key + " " + bmap.get(key));
            }
        }
    }
}
