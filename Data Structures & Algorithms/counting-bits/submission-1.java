class Solution {
    public int[] countBits(int n) {

        int a=0;
        int[] ans = new int[n+1];

        for(int i=n;i>=0;i--)
        {
            a=n-i;
            int count=0;
            while(a!=0)
            {
                a=a&(a-1);
                count++;
            }

            ans[n-i]=count;
        }
        return ans;
    }
}
