package exam;


import java.util.*;

/**
 * author: cshuo
 * date: 2017/4/27
 * version: 1.0
 * description:
 */
public class BD02 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int total = in.nextInt();
            HashMap<String, List<int[]>> ps = new HashMap<>();
            ps.put("R", new ArrayList<int[]>());
            ps.put("G", new ArrayList<int[]>());
            ps.put("B", new ArrayList<int[]>());
            String color;
            int[] nodes;
            for(int i=0; i<total; i++){
                nodes = new int[3];
                color = in.next();
                nodes[0] = in.nextInt();
                nodes[1] = in.nextInt();
                nodes[2] = in.nextInt();
                ps.get(color).add(nodes);
            }
            double maxarea = 0;
            maxarea = Math.max(maxArea(ps.get("R")), maxarea);
            maxarea = Math.max(maxArea(ps.get("G")), maxarea);
            maxarea = Math.max(maxArea(ps.get("B")), maxarea);
            maxarea = Math.max(maxArea(ps.get("R"), ps.get("G"), ps.get("B")), maxarea);
            System.out.println(String.format("%06f", maxarea));
        }
    }

    public static double calArea(int[] a, int[] b, int[] c){
        double[] side = new double[3];
        side[0] = Math.sqrt(Math.pow(a[0]-b[0],2) + Math.pow(a[1]-b[1], 2) + Math.pow(a[2]-b[2], 2));
        side[1] = Math.sqrt(Math.pow(a[0]-c[0],2) + Math.pow(a[1]-c[1], 2) + Math.pow(a[2]-c[2], 2));
        side[2] = Math.sqrt(Math.pow(c[0]-b[0],2) + Math.pow(c[1]-b[1], 2) + Math.pow(c[2]-b[2], 2));

        double p = (side[0] + side[1] + side[2]) / 2;
        return Math.sqrt(p*(p-side[0])*(p-side[1])*(p-side[2]));
    }

    public static double maxArea(List<int[]> points){
        double rs = 0;
        for(int i=0; i<points.size(); i++){
            for(int j=i+1; j<points.size(); j++){
                for(int k=j+1; k<points.size(); k++)
                    rs = Math.max(rs, calArea(points.get(i), points.get(j), points.get(k)));
            }
        }
        return rs;
    }

    public static double maxArea(List<int[]>set1, List<int[]>set2, List<int[]>set3){
        double rs= 0;
        for(int i=0; i<set1.size(); i++){
            for(int j=0; j<set2.size(); j++)
                for(int k=0; k<set3.size(); k++)
                    rs = Math.max(rs, calArea(set1.get(i), set2.get(j), set3.get(k)));
        }
        return rs;
    }
}
