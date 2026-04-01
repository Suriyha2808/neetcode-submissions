class Solution {
    public int maxArea(int[] heights) {
        int maxArea = 0;
        int i = 0;
        int j = heights.length - 1;

        while (i < j) {
            
            int h = Math.min(heights[i], heights[j]);
            
            maxArea = Math.max(maxArea, (j - i) * h);

            if (heights[i] < heights[j]) {
                i++;
            } else {
                j--;
            }
        }
        return maxArea;
    }
}