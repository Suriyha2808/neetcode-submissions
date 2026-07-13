class Solution {
    public boolean exist(char[][] board, String word) {
        
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                if(check(i,j,0,board,word))
                {
                    return true;
                }
            }
        }
        return false;
        
    }

    public boolean check(int i,int j,int index,char[][] board,String word)
    {
        if(index==word.length())
        {
            return true;
        }
        if(i>=0 && j>=0 && i<board.length && j<board[0].length && board[i][j]==word.charAt(index))
        {
                char temp=board[i][j];
                board[i][j]='*';
                
                if(check(i,j+1,index+1,board,word))
                {
                    return true;
                }
                if(check(i,j-1,index+1,board,word))
                {
                    return true;
                }
                if(check(i+1,j,index+1,board,word))
                {
                    return true;
                }
                if(check(i-1,j,index+1,board,word))
                {
                    return true;
                }
                board[i][j]=temp;
            
        }
        
        return false;
    }
}
