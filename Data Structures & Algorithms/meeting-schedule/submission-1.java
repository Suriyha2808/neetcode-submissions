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
    public boolean canAttendMeetings(List<Interval> intervals) {

        if (intervals.size() <= 1) {
            return true;
        }

        
        int[][] interva = new int[intervals.size()][2];
        int i=0;

        for(Interval n : intervals)
        {
            interva[i][0]=n.start;
            interva[i][1]=n.end;
            i++;
        }

        Arrays.sort(interva,(a,b)->Integer.compare(a[0],b[0]));

        int end = interva[0][1];

        for(int j=1 ; j<interva.length;j++)
        {
            if(interva[j][0] >= end)
            {
                end=interva[j][1];
                continue;
            }
             return false;
        }

        return true;


    }
}
