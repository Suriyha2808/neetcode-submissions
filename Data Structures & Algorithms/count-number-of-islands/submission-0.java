class Solution {
    public int numIslands(char[][] grid) {
        // Edge case: if the grid is empty, there are no islands
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int count = 0; // Fix: Initialized to 0
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') { // Fix: Used == instead of .equals()
                    count++;
                    fill(i, j, grid);
                }
            }
        }
        return count;
    }

    public void fill(int i, int j, char[][] grid) {
        // Fix: Base case checks all boundaries and whether the cell is water ('0')
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != '1') {
            return;
        }

        // Sink the land so we don't visit it again
        grid[i][j] = '0';

        // Recurse cleanly in all 4 directions
        fill(i + 1, j, grid); // Down
        fill(i - 1, j, grid); // Up
        fill(i, j + 1, grid); // Right
        fill(i, j - 1, grid); // Left
    }
}