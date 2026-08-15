class Solution {
    public int getSum(int a, int b) {

        int carry=0;
        int ans=0;

        for(int i=0 ;i<32;i++)
        {
            if(((1<<i) & a ) !=0 && ((1<<i) & b) !=0)
            {
                if(carry==1)
                {
                    ans=ans | (1<<i);
                    carry=1;
                }
                else
                {
                    carry=1;
                }
            }

            else if(((1<<i) & a ) !=0 || ((1<<i) & b) !=0)
            {
                if(carry==1)
                {
                    carry=1;
                }
                else
                {
                    ans=ans | (1<<i);
                    carry=0;
                }
            }

            else
            {
                if(carry==1)
                {
                    ans=ans | (1<<i);
                    carry=0;
                }
    
            }
        }

        return ans;
        
    }
}
