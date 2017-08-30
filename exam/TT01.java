package exam;

import java.util.*;

public class TT01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while(in.hasNext()) {
            int cases = in.nextInt();
            int[][] points = new int[cases][2];
            for(int i=0; i<cases; i++) {
                points[i][0] = in.nextInt();
                points[i][1] = in.nextInt();
            }

            Arrays.sort(points, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0] - o2[0];
                }
            });

            int yMax = cases - 1;
            List<Integer> rs = new ArrayList<>();
            for(int i=cases-2; i>=0; i--) {
                if(points[i][1] > points[yMax][1]){
                    rs.add(0, i);
                    yMax = i;
                }
            }
            for(int e: rs)
                System.out.println(points[e][0] + " " + points[e][1]);
            System.out.println(points[cases-1][0] + " " + points[cases-1][1]);

        }
        in.close();
    }
}
