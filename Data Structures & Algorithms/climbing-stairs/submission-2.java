class Solution {
    public int climbStairs(int n) {

        if(n==1)
        {
            return 1;
        }
        if(n==2)
        {
            return 2;
        }
        int i=1;
        int j=2;
        int ans=0;
        for(int k=3;k<=n;k++)
        {
            ans=i+j;
            i=j;
            j=ans;;
        }

        return ans;
        
    }
}
