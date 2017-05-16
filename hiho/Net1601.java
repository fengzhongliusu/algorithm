package hiho;

import java.util.*;

/**
 * author: cshuo
 * date: 2017/3/23
 * version: 1.0
 * description:
 */
public class Net1601 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()){
            int numTest;
            long fScore, avg, total_need, now_score;
            long min_cost;

            numTest = sc.nextInt();
            fScore = sc.nextLong();

            long [][] glist = new long[numTest][2];
            avg = sc.nextLong();
            now_score = 0;
            min_cost = 0;

            total_need = (long)numTest * avg;

            for(int i = 0; i<numTest; i++){
                glist[i][0] = sc.nextLong();
                glist[i][1] = sc.nextLong();
                now_score += glist[i][0];
            }

            Arrays.sort(glist, new Comparator<long[]>() {
                @Override
                public int compare(long[] o1, long[] o2) {
                    return Long.compare(o1[1], o2[1]);
                }
            });

            for(int i=0; i<numTest && now_score < total_need; i++){
                if(now_score + fScore - glist[i][0] >= total_need){
                    min_cost += (total_need - now_score) * glist[i][1];
                    now_score = total_need;  // break 换成 这个
                } else {
                    now_score += fScore - glist[i][0];
                    min_cost += (fScore - glist[i][0]) * glist[i][1];
                }
            }


            System.out.println(min_cost);
        }
        sc.close();
    }

}
