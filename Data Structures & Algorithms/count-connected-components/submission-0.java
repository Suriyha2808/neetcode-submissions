class Solution {
    public int countComponents(int n, int[][] edges) {

        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(new ArrayList<Integer>());
        }

        for(int i=0;i<edges.length;i++)
        {
            list.get(edges[i][0]).add(edges[i][1]);
            list.get(edges[i][1]).add(edges[i][0]);
        }

        boolean[] visit = new boolean[n];
        Arrays.fill(visit,false);

        Queue<Integer> queue = new LinkedList<>();

        int ans=0;

        int k=0;

        while(k<n)
        {
            if(!visit[k])
            {
                queue.add(k);
                visit[k]=true;
                ans++;
            }

            while(!queue.isEmpty())
            {
                int l=queue.poll();
                for(int n1 : list.get(l))
                {
                    if(!visit[n1])
                    {
                        queue.add(n1);
                        visit[n1]=true;
                    }
                }
                
            }

            
            k++;
        }

        return ans;
    }
}
