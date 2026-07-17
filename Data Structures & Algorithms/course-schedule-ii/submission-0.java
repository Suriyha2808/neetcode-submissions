class Solution {
    public int[] findOrder(int numCourses, int[][] pre) {

        int[] num = new int[numCourses];
        Arrays.fill(num,0);
        int finishes=0;
        Queue<Integer> queue = new LinkedList<>();
        int[] ans = new int[numCourses];

            
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
                ans[finishes]=i;
                System.out.println(ans);
                finishes++;

            }
        }
        while(!queue.isEmpty())
        {
            int k=queue.poll();
            for(int n : arr.get(k))
            {
                num[n]--;
                if(num[n]==0)
                {
                    queue.add(n);
                    ans[finishes]=n;
                    System.out.println(ans);
                    finishes++;
                }
            }
            
        }
        
        if(finishes==numCourses)
        {
            System.out.println(ans);
            return ans;
        }
        return new int[0];

    }
}
