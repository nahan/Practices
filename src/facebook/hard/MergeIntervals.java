package facebook.hard;

import java.util.*;

// https://leetcode.com/problems/merge-intervals/

// 56

public class MergeIntervals {
    
    // 1. return a new list
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<>();
        if (intervals == null || intervals.size() < 2) {
            return intervals;
        }
        Collections.sort(intervals, (A, B) -> A.start - B.start);
        Interval pre = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++) {
            Interval cur = intervals.get(i);
            if (pre.end >= cur.start) {
                pre.start = Math.min(pre.start, cur.end);
                pre.end = Math.max(pre.end, cur.end);
            } else {
                result.add(pre);
                pre = cur;
            }
        }
        result.add(pre);
        return result;
    }
    
    // 2. using iterator, return the given list
    public List<Interval> mergeII(List<Interval> intervals) {
        if (intervals == null || intervals.size() < 2) {
            return intervals;
        }
        Collections.sort(intervals, (A, B) -> A.start - B.start);
        Iterator<Interval> it = intervals.iterator();
        Interval pre = it.next();
        while (it.hasNext()) {
            Interval cur = it.next();
            if (pre.end >= cur.start) {
                pre.end = Math.max(pre.end, cur.end);
                it.remove();
            } else {
                pre = cur;
            }
        }
        return intervals;
    }
    
    // 3. get start array and end array
    // then sort them and compare each start and end
    public List<Interval> mergeIII(List<Interval> intervals) {
        if (intervals == null || intervals.size() < 2) {
            return intervals;
        }
        List<Interval> result = new ArrayList<>();
        int[] start = new int[intervals.size()];
        int[] end = new int[intervals.size()];
        for (int i = 0; i < intervals.size(); i++) {
            start[i] = intervals.get(i).start;
            end[i] = intervals.get(i).end;
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int i = 0;
        int j = 0;
        while (j < end.length) {
            if (j == end.length - 1 || start[j + 1] > end[j]) {
                result.add(new Interval(start[i], end[j]));
                i = j + 1;
            }
            j++;
        }
        return result;
    }
}
