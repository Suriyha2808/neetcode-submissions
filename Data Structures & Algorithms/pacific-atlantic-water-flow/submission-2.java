

class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> ans = new ArrayList<>();
        
        if (heights == null || heights.length == 0 || heights[0].length == 0) {
            return ans;
        }

        int rows = heights.length;
        int cols = heights[0].length;

        // Reachability maps to track which cells can flow to each ocean
        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];

        // Step 1: Flood inland from the Horizontal Borders
        for (int c = 0; c < cols; c++) {
            // Top row touches Pacific
            floodUphill(0, c, heights, pacific, heights[0][c]);
            // Bottom row touches Atlantic
            floodUphill(rows - 1, c, heights, atlantic, heights[rows - 1][c]);
        }

        // Step 2: Flood inland from the Vertical Borders
        for (int r = 0; r < rows; r++) {
            // Left column touches Pacific
            floodUphill(r, 0, heights, pacific, heights[r][0]);
            // Right column touches Atlantic
            floodUphill(r, cols - 1, heights, atlantic, heights[r][cols - 1]);
        }

        // Step 3: Find where both flood maps intersect
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (pacific[r][c] && atlantic[r][c]) {
                    ans.add(Arrays.asList(r, c));
                }
            }
        }

        return ans;
    }

    private void floodUphill(int r, int c, int[][] heights, boolean[][] oceanMap, int previousHeight) {
        // Base Case 1: Out of bounds check
        if (r < 0 || r >= heights.length || c < 0 || c >= heights[0].length) {
            return;
        }

        // Base Case 2: Stop if water cannot flow uphill (neighbor must be >= current)
        if (heights[r][c] < previousHeight) {
            return;
        }

        // Base Case 3: Skip if this cell has already been flooded by this ocean pass
        if (oceanMap[r][c]) {
            return;
        }

        // Mark this cell as reachable from the target ocean
        oceanMap[r][c] = true;

        // Cascade the flood to all 4 adjacent directions
        floodUphill(r - 1, c, heights, oceanMap, heights[r][c]); // Up
        floodUphill(r + 1, c, heights, oceanMap, heights[r][c]); // Down
        floodUphill(r, c - 1, heights, oceanMap, heights[r][c]); // Left
        floodUphill(r, c + 1, heights, oceanMap, heights[r][c]); // Right
    }
}