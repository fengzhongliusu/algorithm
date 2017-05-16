package exer;

import java.util.*;

/**
 * author: cshuo
 * date: 2017/4/18
 * version: 1.0
 * description: 删除List中的一个元素.
 */
public class RmEleOfList {
    public static void main(String[] args) {
        List<Integer> l = new ArrayList<>();
        l.add(1);
        l.add(2);
        l.add(3);
        l.add(4);

        for(int i=0; i<l.size(); i++){
            if(l.get(i).equals(1) || l.get(i).equals(2)){
                l.remove(i);
            }
        }

//        for(String e: l){
//            if(e.equals("1"))
//                l.remove(e);
//        }

//        Iterator<String> itr = l.iterator();
//        while(itr.hasNext()){
//            String tmp = itr.next();
//            if(tmp.equals("1")){
//                itr.remove();
//            }
//        }

        for(int e: l)
            System.out.println(e);
    }
}
