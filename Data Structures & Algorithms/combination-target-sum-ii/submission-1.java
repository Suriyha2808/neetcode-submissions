class Solution {
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        Arrays.sort(candidates);
        List<List<Integer>> ans =new ArrayList<>();
        generate(0,candidates,target,ans,new ArrayList<>());
        return ans;
        
    }

    public void generate(int index,int[] nums,int target,List<List<Integer>> ans,List<Integer> curr)
    {
        if(target==0)
        {
            ans.add(new ArrayList<>(curr));
            return;
        }
        if(target<0)
        {
            return;
        }

        for(int i=index;i<nums.length;i++)
        {
            if(i>index && nums[i]==nums[i-1])
            {
                continue;
            }
            curr.add(nums[i]);
            generate(i+1,nums,target-nums[i],ans,curr);                curr.remove(curr.size() -1);
         
        }
        return ;
    }
}
