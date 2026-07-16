class Solution {
    public int orangesRotting(int[][] grid) {

        int fresh=0;
        int count=0;
        int ans=0;
        
        List<int[]> rotten = new ArrayList<>();


        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==1)
                {
                    fresh++;
                }
                if(grid[i][j]==2)
                {
                    rotten.add(new int[]{i, j});
                }
            }
        }
        while(fresh!=0)
        {
                ans++;
                int k = rotten.size();
                for(int i=0;i<k;i++)
                {
                    int[] r = rotten.get(i);
                    count = count + change(r[0],r[1],grid,rotten);
                    System.out.println(r);
                }
                if(count>0)
                {
                    fresh=fresh-count;
                }
                else
                {
                    return -1;
                }
                count=0;
            
        }
        return ans;

    }

    public int change(int i,int j,int[][] grid,List<int[]> rotten)
    {
        int count=0;
        if( i>0 && grid[i-1][j]==1 )
        {
            grid[i-1][j]=2;
            rotten.add(new int[]{i-1,j});
            count++;
        } 
        if(i<grid.length-1 && grid[i+1][j]==1  )
        {
            grid[i+1][j]=2;
            rotten.add(new int[]{i+1,j});
            count++;
        } 
        if(j>0 && grid[i][j-1]==1  )
        {
            grid[i][j-1]=2;
            rotten.add(new int[]{i,j-1});
            count++;
        } 
        if(  j<grid[0].length-1 && grid[i][j+1]==1)
        {
            grid[i][j+1]=2;
            rotten.add(new int[]{i,j+1});
            count++;
        }        

        return count;
    }
    
}
