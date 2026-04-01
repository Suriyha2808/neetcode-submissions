class Solution {
    public int maxArea(int[] heights) {
        
        int max=0;
        int area=0;
        int i=0;
        int j=heights.length-1;
        while(j>i)
        {
            System.out.println(i + "" + j);
            if(heights[j]<=heights[i])
            {
                area=(j-i)*heights[j];
                j--;
            }
            else if(heights[j]>heights[i])
            {
                area=(j-i)*heights[i];
                i++;
            }
            if(area>max)
            {
                max=area;
            }
        }
        return max;
    }
}
