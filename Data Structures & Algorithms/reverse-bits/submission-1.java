class Solution {
    public int reverseBits(int ans) {

        int n=0;

        for(int i=31;i>=0;i--)
        {
            if((ans & (1<<(31-i)))!=0)
            {
                n= n | (1<<i);
            }
        }

        return n;
        
    }
}
