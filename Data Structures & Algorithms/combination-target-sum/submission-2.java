class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        int sum=0;
        generate(0,nums,target,sum,ans,new ArrayList<>());
        return ans;
    }

    public void generate(int index,int[] nums,int target,int sum,List<List<Integer>> ans,List<Integer> curr)
    {
        if(sum==target)
        {
            ans.add(new ArrayList<>(curr));
            return;
        }
        if(sum>target)
        {
            return;
        }

        for(int i=index;i<nums.length;i++)
        {
            
            curr.add(nums[i]);
            generate(i,nums,target,sum+nums[i],ans,curr);
            curr.remove(curr.size() -1);
        }
        return ;
    }
}
