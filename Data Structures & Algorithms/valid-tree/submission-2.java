class Solution {
    public boolean validTree(int n, int[][] edges) {
    
        if(edges.length>n-1)
        {
            return false;
        }

        List<List<Integer>> list = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        int l=1;
        boolean[] visit = new boolean[n];
        Arrays.fill(visit,false);
        visit[0]=true;
        queue.add(0);
        
        for (int i = 0; i < n; i++) 
        {
            list.add(new ArrayList<>());
        }


        for(int i=0;i<edges.length;i++)
        {
            
            list.get(edges[i][0]).add(edges[i][1]);
            list.get(edges[i][1]).add(edges[i][0]);

        }
        

        while(!queue.isEmpty())
        {
            int k=queue.poll();
            System.out.println(list.get(k));
            for(int n1 : list.get(k))
            {
                if(!visit[n1])
                {
                    visit[n1]=true;
                    queue.add(n1);
                    l++;
                }
            }
        }

        if(l==n)
        {
            return true;
        }

        return false;

        
        



    }
}
