package facebook.medium;

// https://leetcode.com/problems/meeting-rooms-ii/

// 253

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Han on 10/14/16.
 */
public class MeetingRoomsII {

    // 1. brute-force solution
    // a. sort the intervals - O(NlgN)
    // b. go through the intervals and compare one by one - O(N^2)
    // c. do some reduction: boolean[] visited
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null) {
            return 0;
        }
        if (intervals.length < 2) {
            return intervals.length;
        }
        Arrays.sort(intervals, (a, b) -> a.start - b.start);
        boolean[] visited = new boolean[intervals.length];
        int count = 0;
        for (int i = 0; i < intervals.length; i++) {
            if (visited[i]) {
                continue;
            }
            count++;
            int end = intervals[i].end;
            for (int j = i + 1; j < intervals.length; j++) {
                if (visited[j]) {
                    continue;
                }
                if (end <= intervals[j].start) {
                    end = intervals[j].end;
                    visited[j] = true;
                }
            }
        }
        return count;
    }

    // 2. one array for all starts, another array for all ends
    // sort them - O(N)
    // set last end as 0
    // keep tracking the last end index
    // go through the starts array, if start is less than the last end, add 1 to the count
    public int minMeetingRoomsII(Interval[] intervals) {
        if (intervals == null) {
            return 0;
        }
        if (intervals.length < 2) {
            return intervals.length;
        }
        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            start[i] = intervals[i].start;
            end[i] = intervals[i].end;
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int count = 0;
        int lastEnd = 0;
        for (int i = 0; i < intervals.length; i++) {
            if (start[i] < end[lastEnd]) {
                count++;
            } else {
                lastEnd++;
            }
        }
        return count;
    }

    // similar with Merge Intervals
    // the difference is in this solution:
    // we go through the end array,
    // keep tracking the last start index
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() < 2) {
            return  intervals;
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
        int lastStart = 0;
        for (int i = 0; i < end.length; i++) {
            if (i == end.length - 1 || end[i] < start[i + 1]) {
                result.add(new Interval(start[lastStart], end[i]));
                lastStart = i + 1;
            }
        }
        return result;
    }
}
