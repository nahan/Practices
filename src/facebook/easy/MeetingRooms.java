package facebook.easy;

import java.util.Arrays;

// https://leetcode.com/problems/meeting-rooms/

// 252

public class MeetingRooms {

    public boolean canAttendMeetings(Interval[] intervals) {
        if (intervals == null || intervals.length < 2) {
            return true;
        }
        Arrays.sort(intervals, (A, B) -> A.start - B.start);
        Interval pre = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (pre.end > intervals[i].start) {
                return false;
            }
            pre = intervals[i];
        }
        return true;
    }
    
}
