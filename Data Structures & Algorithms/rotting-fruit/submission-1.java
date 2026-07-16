class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int minutes = 0;

        // Clean directional arrays instead of 4 separate if-blocks
        int[] dRow = {-1, 0, 1, 0};
        int[] dCol = {0, 1, 0, -1};

        while (true) {
            boolean infectedAny = false;
            
            // Minute 0 looks for 2, Minute 1 looks for 3, Minute 2 looks for 4...
            int currentRottenValue = 2 + minutes; 

            for (int r = 0; r < rows; r++) {
                for (int c = 0; c < cols; c++) {
                    // Process ONLY the oranges that rotted in this exact minute flight
                    if (grid[r][c] == currentRottenValue) {
                        
                        for (int d = 0; d < 4; d++) {
                            int nRow = r + dRow[d];
                            int nCol = c + dCol[d];

                            // If a neighbor is fresh (1), mark it with the NEXT minute's stamp
                            if (nRow >= 0 && nRow < rows && nCol >= 0 && nCol < cols && grid[nRow][nCol] == 1) {
                                grid[nRow][nCol] = currentRottenValue + 1;
                                infectedAny = true;
                            }
                        }
                    }
                }
            }

            // If an entire sweep across the matrix infects absolutely nothing, we are done
            if (!infectedAny) {
                break;
            }
            minutes++;
        }

        // One final flat check to see if any isolated fresh oranges were left stranded
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1) {
                    return -1;
                }
            }
        }

        return minutes;
    }
}