class Solution {
    public int[] productExceptSelf(int[] nums) {

        int arr[] = new int[nums.length];
        int pre=1;
        int pos=1;

        for(int i=0;i<nums.length;i++)
        {

            arr[i]=pre;
            pre*=nums[i];
        }
        
        for(int i=nums.length-1;i>-1;i--)
        {
            arr[i]*=pos;
            pos*=nums[i];
            
            
        }

        return arr;
    }
}