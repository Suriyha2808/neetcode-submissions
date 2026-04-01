class Solution {
    public int largestRectangleArea(int[] heights) {

        Deque<Integer> que = new ArrayDeque<>();
        int max=heights[0];
        int cur_height;
        int n=heights.length;
        for(int i=0;i<=n;i++)
        {
            cur_height = (i==n) ? 0 : heights[i];
            while(!que.isEmpty() && cur_height < heights[que.peek()])
            {
                int height = heights[que.pop()];
                int width = (que.isEmpty()) ? i : i-que.peek()-1;
                max=Math.max(max,height*width);
                
            }
            que.push(i);
            
        }
        return max;


          
        
    }
}
