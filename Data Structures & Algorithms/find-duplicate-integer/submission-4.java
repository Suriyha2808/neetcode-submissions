
class Solution {
    public int findDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            // Step 1: Get the absolute value FIRST, then find the index
            int index = Math.abs(nums[i]) - 1;
            
            // Step 2: Check if the "house" at this index is already marked
            if (nums[index] < 0) {
                return Math.abs(nums[i]); // Return the positive version of the number
            }
            
            // Step 3: Mark the "house" as visited
            nums[index] *= -1;
        }
        return -1;
    }
}