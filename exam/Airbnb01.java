package exam;

import java.util.*;

public class Airbnb01 {
    public static void main(String[] args) {
        int[] nums = new int[] {2,1,1,2,1};
        socialGraphs(nums);
    }

    public static void socialGraphs(int[] counts) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0; i<counts.length; i++) {
            if(!map.containsKey(counts[i])) map.put(counts[i], new ArrayList<>());
            map.get(counts[i]).add(i);
        }
        List<ArrayList<Integer>> rs = new ArrayList<>();
        for(Map.Entry<Integer, List<Integer>> entry: map.entrySet()) {
            int num = entry.getValue().size() / entry.getKey();
            int start = 0;
            for(int i=0; i<num; i++) {
                ArrayList<Integer> row = new ArrayList<>();
                for(int j=0;j<entry.getKey(); j++){
                    row.add(entry.getValue().get(j+start));
                }
                rs.add(row);
                start += entry.getKey();
            }
        }
        Collections.sort(rs, ((o1, o2) -> o1.get(0) - o2.get(0)));
        for(ArrayList<Integer> e : rs) {
            for(int n : e) System.out.print(n + " ");
            System.out.println();
        }
    }
}
