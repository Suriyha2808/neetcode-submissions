
class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;
        
        // Direction vectors for moving: Down, Up, Right, Left
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        
        Queue<Integer> queue = new LinkedList<>();
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    grid[i][j] = '0'; // Mark as visited immediately
                    
                    // Flatten 2D coordinates into a single integer to save memory
                    queue.offer(i * cols + j);
                    
                    while (!queue.isEmpty()) {
                        int id = queue.poll();
                        int r = id / cols;
                        int c = id % cols;
                        
                        for (int[] dir : directions) {
                            int nr = r + dir[0];
                            int nc = c + dir[1];
                            
                            // Validate boundaries and check if it's land
                            if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && grid[nr][nc] == '1') {
                                grid[nr][nc] = '0'; // Sink it BEFORE adding to queue to avoid duplicate processing
                                queue.offer(nr * cols + nc);
                            }
                        }
                    }
                }
            }
        }
        
        return count;
    }
}