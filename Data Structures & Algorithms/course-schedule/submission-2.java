class Solution {
    public boolean canFinish(int numCourses, int[][] pre) {

        int[] num = new int[numCourses];
        Arrays.fill(num,0);
        int finishes=0;
        Queue<Integer> queue = new LinkedList<>();

            
        List<List<Integer>> arr = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) 
        {
            arr.add(new ArrayList<>());
        }

        for(int i=0;i<pre.length;i++)
        {
            num[pre[i][0]]++;
            arr.get(pre[i][1]).add(pre[i][0]);
            
        }
        
        for(int i=0;i<num.length;i++)
        {
            if(num[i]==0)
            {
                
                queue.add(i);
                finishes++;

            }
        }
        while(!queue.isEmpty())
        {
            int k=queue.poll();
            for(int i=0;i<pre.length;i++)
            {
                if(pre[i][1]==k)
                {
                    num[pre[i][0]]--;
                    if(num[pre[i][0]]==0)
                    {
                        queue.add(pre[i][0]);
                        finishes++;
                    }
                }
            }
        }
        
        if(finishes==numCourses)
        {
            return true;
        }
        return false;

    }
}
