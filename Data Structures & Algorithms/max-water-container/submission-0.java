class Solution {
    public int maxArea(int[] heights) {
        
        int max=0;
        System.out.println(heights.length);

        for(int i=0;i<heights.length-1;i++)
        {
            for(int j=i+1;j<heights.length;j++)
            {
                int area=0;
                if(heights[j]>=heights[i])
                {
                    area=heights[i]*(j-i);
                }
                else if(heights[j]<=heights[i])
                {
                    area=heights[j]*(j-i);
                }

                System.out.println(i + " " + j + " " + area);
                if(area>max)
                {
                    max=area;
                }
            }
        }
        return max;
    }
}
