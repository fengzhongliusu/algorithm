package hiho;

import java.util.*;

/**
 * author: cshuo
 * date: 2017/3/23
 * version: 1.0
 * description:
 */
public class Net201601 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()){
            Map<Long, Long> glist= new TreeMap<>();
            int numTest;
            long fScore, avg, total_need, now_score;
            long score, cost;
            long min_cost;

            numTest = sc.nextInt();
            fScore = sc.nextLong();
            avg = sc.nextLong();
            now_score = 0;
            min_cost = 0;

            total_need = (long)numTest * avg;

            for(int i = 0; i<numTest; i++){
                score = sc.nextLong();
                cost = sc.nextLong();
                now_score += score;
                if(!glist.containsKey(cost))
                    glist.put(cost, fScore-score);
                else
                    glist.put(cost, glist.get(cost) + fScore - score);
            }

            long can_add;
            for(Map.Entry entry: glist.entrySet()){
                can_add = (long) entry.getValue();
                if(now_score + can_add >= total_need){
                    min_cost += (total_need - now_score) * (long)entry.getKey();
                    break;
                } else {
                    now_score += can_add;
                    min_cost += can_add * (long)entry.getKey();
                }
            }
            System.out.println(min_cost);
        }
        sc.close();
    }

}
