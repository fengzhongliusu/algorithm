package leetcode;
import java.util.*;


/**
 * Given a collection of intervals, merge all overlapping intervals.
 For example,
 Given [1,3],[2,6],[8,10],[15,18],
 return [1,6],[8,10],[15,18].
 */
public class LC56 {

    class Interval {
        int start;
        int end;
        Interval(int s, int e) { start = s; end = e; }
    }

    /**
     * 先根据Interval的开头排序，然后遍历merge即可.
     */
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> rs = new ArrayList<>();
        if(intervals == null || intervals.size() < 1) return rs;
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });

        int idx = 0;
        for(int i=0; i<intervals.size(); i++) {
            Interval tmp = intervals.get(i);
            if(rs.size() == 0) rs.add(tmp);
            else {
                if(tmp.start > rs.get(idx).end) {
                    rs.add(tmp);
                    ++idx;
                } else {
                    rs.set(idx, new Interval(Math.min(tmp.start, rs.get(idx).start), Math.max(tmp.end, rs.get(idx).end)));
                }
            }
        }
        return rs;
    }
}
