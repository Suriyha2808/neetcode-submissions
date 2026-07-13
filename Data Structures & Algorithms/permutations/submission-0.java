class Solution {
    public List<List<Integer>> permute(int[] nums) {
        
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        generate(nums,ans,visited,new ArrayList<>());
        return ans;
    }
    public void generate(int[] nums,List<List<Integer>> ans,boolean[] visited,List<Integer> curr)
    {
        if(curr.size() ==  nums.length)
        {
            ans.add(new ArrayList<>(curr));
        }

        for(int i=0;i<nums.length;i++)
        {
            if(visited[i])
            {
                continue;
            }
            visited[i]=true;
            curr.add(nums[i]);
            generate(nums,ans,visited,curr);
            visited[i]=false;
            curr.remove(curr.size() - 1);
        }
        return;
    }
}
