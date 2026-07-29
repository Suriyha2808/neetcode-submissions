class Solution {
    public int[][] merge(int[][] intervals) {
        
        List<int[]> list = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int[] curr = new int[]{intervals[0][0],intervals[0][1]};


        for(int[] n : intervals)
        {
            for(int j : n){
                System.out.println(j);
            }
        }

        for(int i=1 ; i<intervals.length ; i++)
        {
            if(curr[1]<intervals[i][0])
            {
                list.add(new int[]{curr[0],curr[1]});
                curr[0]=intervals[i][0];
                curr[1]=intervals[i][1];
            }

            else
            {
                curr[0]=Math.min(curr[0],intervals[i][0]);
                curr[1]=Math.max(curr[1],intervals[i][1]);
            }
        }
        
        list.add(new int[]{curr[0],curr[1]});

        return list.toArray(new int[list.size()][]);
    }
}
