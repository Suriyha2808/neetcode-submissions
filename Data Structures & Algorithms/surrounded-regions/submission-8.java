class Solution {
    public void solve(char[][] board) {
        
        for(int i=1;i<board.length-1;i++)
        {
            for(int j=1;j<board[0].length-1;j++)
            {
                if(board[i][j]=='O')
                {
                    boolean[][] visited = new boolean[board.length][board[0].length];
                    if(!check(i,j,board,visited))
                    {
                        board[i][j]='X';
                    }
                }

            }
        }
        
    }

    public boolean check(int i, int j, char[][] board, boolean[][] visited) {
        // 1. Boundary base case: If we successfully hit a border cell that is 'O', we escaped!
        if (i == 0 || j == 0 || i == board.length - 1 || j == board[0].length - 1) {
            return board[i][j] == 'O';
        }

        // 2. Dead-end base cases
        if (board[i][j] == 'X' || visited[i][j]) {
            return false;
        }

        visited[i][j] = true;

        // FIX: Force Java to run ALL four directions by storing them in variables first.
        // This prevents the short-circuit '||' operator from skipping unvisited cells!
        boolean down  = check(i + 1, j, board, visited);
        boolean up    = check(i - 1, j, board, visited);
        boolean right = check(i, j + 1, board, visited);
        boolean left  = check(i, j - 1, board, visited);

        // If any path manages to escape to a border, this entire cluster can escape
        return down || up || right || left;
    }

}
