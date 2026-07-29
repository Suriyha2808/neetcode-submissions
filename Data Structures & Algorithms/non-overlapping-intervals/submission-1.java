class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {

        int ans=0;
        Arrays.sort(intervals,(a,b)-> Integer.compare(a[0],b[0]));

        int[] curr = new int[]{intervals[0][0],intervals[0][1]};

        

        for(int i=1;i<intervals.length;i++)
        {
            if(curr[1]<=intervals[i][0])
            {
                curr[0]=intervals[i][0];
                curr[1]=intervals[i][1];
            }


            else
            {
                
                if(curr[1]> intervals[i][1])
                {
                    curr[0]=intervals[i][0];
                    curr[1]=intervals[i][1];                
                }
                ans++;

            }
        }

        return ans;
        
        
    }
}
