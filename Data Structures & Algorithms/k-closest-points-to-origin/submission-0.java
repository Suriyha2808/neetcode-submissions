class Solution {
    public int[][] kClosest(int[][] points, int k) {

        PriorityQueue<int[]> maxheap= new PriorityQueue<>((b,a)->Integer.compare((a[0]*a[0] + a[1]*a[1]),(b[0]*b[0]+b[1]*b[1])));
        int[][] ans = new int[k][2];
        for(int[] n : points)
        {
            int y = n[0]*n[0] + n[1]*n[1];
            maxheap.add(n);
            if(maxheap.size()>k)
            {
                maxheap.poll();
            }
        }

        while(maxheap.size()>0)
        {
            ans[k-maxheap.size()]=maxheap.poll();
        }

        return ans;

    }
}
