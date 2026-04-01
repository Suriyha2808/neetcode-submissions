class Solution {
    public boolean isValidSudoku(char[][] board) {


        
        
        char c;
        for(int i=0 ; i<9 ; i++)
        {
            ArrayList<Character> num = new ArrayList<>();

            for(int k = 0; k < 9; k++) 
            {  
                num.add((char)('1'+k));
            }
            for(int j=0;j<9 ;j++)
            {
                c=board [i][j];
                if(num.contains(c) || c=='.')
                {
                    num.remove(Character.valueOf(c));
                    continue;
                }
                else
                {
                    return false;
                }
            }
        }
        for(int i=0 ; i<9 ; i++)
        {
            ArrayList<Character> num = new ArrayList<>();

            for(int k = 0; k < 9; k++) 
            {  
                num.add((char)('1'+k));
            }
            for(int j=0;j<9 ;j++)
            {
                c=board [j][i];
                if(num.contains(c) || c=='.')
                {
                    num.remove(Character.valueOf(c));
                    continue;
                }
                else
                {
                    return false;
                }
            }
        }

        // Check 3x3 boxes
    for(int row = 0; row < 9; row += 3) {
        for(int col = 0; col < 9; col += 3) 
        {

            ArrayList<Character> num = new ArrayList<>();

            for(int k = 0; k < 9; k++) 
            {
                num.add((char)('1' + k));
            }

        
         for(int i = row; i < row + 3; i++) {
            for(int j = col; j < col + 3; j++) {

                c = board[i][j];

                if(c == '.') continue;

                if(num.contains(c)) {
                    num.remove(Character.valueOf(c));
                } else {
                    return false;
                }
            }
        }
    }
}


        return true;

    }
}