class Solution {
    public int jump(int[] nums) {


        if(nums.length==1)
        {
            return 0;
        }

        int farthest=0;
        int count=0;
        int curr=0;

        for(int i=0;i<nums.length-1;i++)
        {
        
            farthest=Math.max(farthest,nums[i]+i);

            if(curr==i)
            {
                count++;
                curr=farthest;
            }
        }

        return count;

        
    }
}
