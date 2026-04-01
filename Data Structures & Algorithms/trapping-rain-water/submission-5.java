class Solution {
    public int trap(int[] height) {
        int area = 0;
        int i = 0;
        
        while (i < height.length - 1) {
            int x = 0;
            int j = i + 1;
            int maxIdx = j; // Track the highest wall seen so far

            // Search for a wall >= height[i]
            while (j < height.length && height[j] < height[i]) {
                if (height[j] > height[maxIdx]) {
                    maxIdx = j; // Update the "best second-choice" wall
                }
                j++;
            }

            // CASE: We hit the end without finding a taller wall (like [4, 2, 3])
            if (j == height.length) {
                // Use the highest wall we DID find as the new boundary
                j = maxIdx;
                int boundaryHeight = height[j];
                
                // Recalculate 'x' (sum of bars) up to this new boundary
                x = 0;
                for (int k = i + 1; k < j; k++) {
                    x += height[k];
                }
                
                area += (boundaryHeight * (j - i - 1) - x);
            } 
            // CASE: We found a taller or equal wall
            else {
                for (int k = i + 1; k < j; k++) {
                    x += height[k];
                }
                area += (height[i] * (j - i - 1) - x);
            }
            
            i = j; // Move 'i' to the wall we just used as a boundary
        }
        return area;
    }
}