package exam;

import java.util.*;

/**
 * author: cshuo
 * date: 2017/5/27
 * version: 1.0
 * description:
 */
public class IND04 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N;
        long T;
        int[] rs;
        int[] a;
        int sign = 0;
        while(in.hasNext()){
            N = in.nextInt();
            T = in.nextLong();
            rs = new int[N];
            a = new int[N];
            System.out.println(N + " " + T);

            List<List<Integer>> boxes = new ArrayList<>();
            List<List<Integer>> alter = new ArrayList<>();
            List<List<Integer>> temp;

            for(int i=0; i<N; i++){
                a[i] = in.nextInt()-1;
                ArrayList tmp = new ArrayList<Integer>();
                tmp.add(i);
                boxes.add(tmp);
                alter.add(new ArrayList<Integer>());
            }

            for(long i=0; i<T; i++){
                if(i>0) {
                    temp = boxes;
                    boxes = alter;
                    alter = temp;
                }
                for(int j=0; j<boxes.size(); j++){
                    List<Integer> tmp = boxes.get(j);
                    if(tmp.size() > 0){
                        alter.get(a[j]).addAll(tmp);
                        boxes.get(j).clear();
                    }
                }
            }

            for(int i=0; i<alter.size(); i++){
                for(int ele: alter.get(i)){
                    rs[ele] = i+1;
                }
            }

            for(int ele: rs){
                System.out.println(ele);
            }
        }
        in.close();
    }


}
