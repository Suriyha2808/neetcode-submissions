class Solution {
    public int maxProduct(int[] nums) {

        if(nums.length==1)
        {
            return nums[0];
        }
        int max=nums[0];
        int min=nums[0];
        int ans=-99999;
        int max1;
        int min1;

        for(int i=1;i<nums.length;i++)
        {
            max1=Math.max(max*nums[i],min*nums[i]);
            min1=Math.min(max*nums[i],min*nums[i]);
            max=Math.max(nums[i],max1);
            min=Math.min(nums[i],min1);

            ans=Math.max(ans,max);


        }

        return ans;
        
    }
}
