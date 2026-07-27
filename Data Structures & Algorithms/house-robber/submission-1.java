class Solution {
    public int rob(int[] nums) {

        int prev1=0;
        int prev2=0;

        for(int i=0;i<nums.length;i++)
        {
            nums[i]=Math.max(nums[i]+prev2,prev1);
            prev2=prev1;
            prev1=nums[i];
            
        }

        return Math.max(prev1,prev2);
        
    }
}
