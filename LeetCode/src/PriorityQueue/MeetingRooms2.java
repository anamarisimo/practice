package PriorityQueue;

import java.util.*;

public class MeetingRooms2 {
    public int minMeetingRooms(int[][] intervals)
    {
        List<int[]> intervalsOrderedByStart = Arrays.asList(intervals);
        intervalsOrderedByStart.sort(new IntervalComparator());

        PriorityQueue<Integer> roomsAvailableByEnd = new PriorityQueue<>();

        for(int[] interval : intervalsOrderedByStart)
        {
            Integer earliestEndTime = roomsAvailableByEnd.peek();
            if(earliestEndTime!=null && earliestEndTime > interval[0])
                roomsAvailableByEnd.add(interval[1]);
            else
            {
                roomsAvailableByEnd.poll();
                roomsAvailableByEnd.add(interval[1]);
            }
        }
        return roomsAvailableByEnd.size();
    }

}
class IntervalComparator implements Comparator<int[]>
{
    public int compare(int[] interval1, int[] interval2)
    {
        return Integer.compare(interval1[0], interval2[0]);
    }
}
