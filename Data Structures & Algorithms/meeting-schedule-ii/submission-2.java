/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {

        if(intervals.size()==0)
        {
            return 0;
        }

        Collections.sort(intervals,(a,b) -> Integer.compare(a.start,b.start));

        PriorityQueue<Integer>  queue = new PriorityQueue<>();
        queue.add(intervals.get(0).end);
        int ans=1;

        for(int i=1;i<intervals.size();i++)
        {
            int start = intervals.get(i).start;
            int end = intervals.get(i).end;

            if(start >= queue.peek())
            {
                queue.poll();
                queue.add(end);
                continue;
            }

            if(start<queue.peek())
            {
                queue.add(end);
            }
            ans=Math.max(queue.size(),ans);

        }

        return ans;

    }
}
