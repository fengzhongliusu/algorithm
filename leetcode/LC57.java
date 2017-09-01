package leetcode;
import java.util.*;


public class LC57 {

public class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}

    /**
     * 有序的interval(start升序)，插入一个新的interval.
     */
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> rs = new ArrayList<>();
        if(intervals == null || intervals.size() < 1) return Arrays.asList(new Interval[] {newInterval});

        // merged 标记newInterval是否已经被加入rs，包括直接加入或者merged后加入.
        int i = 0, merged = 0;
        for(; i<intervals.size(); i++) {
            if(newInterval.end < intervals.get(i).start) {
                if(merged == 0){
                    rs.add(newInterval);
                    merged = 1;
                }
                break;
            } else if(intervals.get(i).end < newInterval.start) {
                rs.add(intervals.get(i));
            } else {
                if(merged == 1) newInterval = rs.get(rs.size()-1);
                newInterval.start = Math.min(newInterval.start, intervals.get(i).start);
                newInterval.end = Math.max(newInterval.end, intervals.get(i).end);
                if(merged == 1) rs.set(rs.size()-1, newInterval);
                else rs.add(newInterval);
                merged = 1;
            }
        }
        // newInterval的start大于所有interval的end.
        if(merged == 0) rs.add(newInterval);
        // newInterval的end小于一部分interval的start.
        for(; i<intervals.size(); i++) rs.add(intervals.get(i));
        return rs;
    }

    /**
     * 简洁版, merged后的newInterval先不用插入rs中，继续与之后的interval比较，省去了上述方法中的merged标记.
     */
    public List<Interval> insert2(List<Interval> intervals, Interval newInterval) {
        List<Interval> rs = new ArrayList<>();
        for(Interval e :  intervals) {
            if(newInterval == null || e.end < newInterval.start)
                rs.add(e);
            else if(newInterval.end < e.start) {
                rs.add(newInterval);
                rs.add(e);
                newInterval = null;
            } else {
                newInterval.start = Math.min(newInterval.start, e.start);
                newInterval.end = Math.max(newInterval.end, e.end);
            }
        }
        if(newInterval != null) rs.add(newInterval);
        return rs;
    }

}
