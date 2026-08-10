class Solution {
    public boolean hasDuplicate(int[] nums) {

        Set<Integer> sern = new HashSet<>();
       
        for(int n : nums)
        {
            if(!sern.add(n))
            {
                return true;
            }
        }
        return false;
        
    }
}