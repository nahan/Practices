package facebook.hard;

import java.util.*;

// https://leetcode.com/problems/insert-interval/

// 57

public class InsertInterval {

    // same solution as Merging Intervals
    // get sorted arrays for both starts and ends
    // keep track the last start index
    // go through the ends array
    // each time once we hit a start larger than current end, form an interval and insert it into result
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new ArrayList<>();
        if (intervals == null || intervals.isEmpty()) {
            result.add(newInterval);
            return result;
        }
        int[] start = new int[intervals.size() + 1];
        int[] end = new int[intervals.size() + 1];
        start[0] = newInterval.start;
        end[0] = newInterval.end;
        for (int i = 0; i < intervals.size(); i++) {
            start[i + 1] = intervals.get(i).start;
            end[i + 1] = intervals.get(i).end;
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int lastStart = 0;
        for (int i = 0; i < end.length; i++) {
            if (i == end.length - 1 || start[i + 1] > end[i]) {
                result.add(new Interval(start[lastStart], end[i]));
                lastStart = i + 1;
            }
        }
        return result;
    }
}
