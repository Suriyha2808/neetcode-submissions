class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans= new ArrayList<>();
        generate(nums,0,ans,new ArrayList<>());
        return ans;
    }
    public void generate(int nums[],int index,List<List<Integer>> ans,List<Integer> curr)
    {
        ans.add(new ArrayList<>(curr));
        for(int i=index;i<nums.length;i++)
        {
            if(i>index && nums[i]==nums[i-1])
            {
                continue;
            }
            curr.add(nums[i]);
            generate(nums,i+1,ans,curr);
            curr.remove(curr.size()-1);
        }
        return;
    }
}
