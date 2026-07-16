class Solution {
    
    public int maxAreaOfIsland(int[][] grid) {
        
        int max=0;
        if(grid.length==0)
        {
            return 0;
        }

        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==1)
                {
                    max=Math.max(max,gen(i,j,grid,0));
                }
            }
        }

        return max;
    }

    public int gen(int i,int j,int[][] grid,int curr)
    {
        if(i<0 || i>=grid.length || j<0 || j>= grid[0].length)
        {
            return curr;
        }
        if(grid[i][j]==1)
        {
            
            grid[i][j]=0;
            return 1+ gen(i+1,j,grid,curr)
                    +gen(i-1,j,grid,curr)
                    +gen(i,j+1,grid,curr)
                    +gen(i,j-1,grid,curr);
        }
        return curr;
 
    }
}
