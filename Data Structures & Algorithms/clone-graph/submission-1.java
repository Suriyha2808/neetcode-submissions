/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {

        if(node==null)
        {
            return null;
        }

        Queue<Node> queue = new LinkedList<>();
        HashMap<Node,Node> map = new HashMap<>();

        
        Node root = new Node();
        map.put(node,root);
        root.val=node.val;
        queue.add(node);

        while(!queue.isEmpty())
        {
            node = queue.poll(); 

            for(Node n : node.neighbors)
            {
                if(!map.containsKey(n))
                {
                    Node neigh = new Node();
                    neigh.val=n.val;
                    map.put(n,neigh);
                    queue.add(n);
                }
                map.get(node).neighbors.add(map.get(n));
            }

        }

        return root;

    }
}
