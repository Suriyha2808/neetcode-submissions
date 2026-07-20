class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            
            if (hasPath(u, v, graph, n)) {
                return edge;
            }
            
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        
        return new int[0];
    }
    
    private boolean hasPath(int start, int target, List<List<Integer>> graph, int n) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visit = new boolean[n + 1];
        
        queue.add(start);
        visit[start] = true;
        
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            
            if (curr == target) {
                return true;
            }
            
            for (int neighbor : graph.get(curr)) {
                if (!visit[neighbor]) {
                    visit[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
        
        return false;
    }
}