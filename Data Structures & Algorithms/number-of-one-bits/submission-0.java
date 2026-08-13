class Solution {
    public int hammingWeight(int n) {

        int result=1;
        int count=0;

        for(int i=1;i<=32;i++)
        {
            if((result & n )> 0)
            {
                count++;
            }
            result=result<<1;
        }

        return count;
        
    }
}
