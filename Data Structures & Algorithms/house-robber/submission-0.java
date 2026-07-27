class Solution {
    public int rob(int[] nums) {

        int max0=0;
        int max1=0;

        for(int i=0;i<nums.length;i++)
        {
            if(i%2==0)
            {
                nums[i]=Math.max(nums[i]+max0,max1);
                max0=nums[i];
            }
            if(i%2!=0)
            {
                nums[i]=Math.max(nums[i]+max1,max0);
                max1=nums[i];
            }
        }

        return Math.max(max0,max1);
        
    }
}
