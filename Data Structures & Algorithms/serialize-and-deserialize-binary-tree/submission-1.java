

public class Codec {

    
    public String serialize(TreeNode root) {
        if (root == null) return "";
        
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            
            if (curr == null) {
                sb.append("null,");
                continue;
            }
            
            sb.append(curr.val).append(",");
            queue.add(curr.left);
            queue.add(curr.right);
        }
        
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        // Handle empty tree base case cleanly
        if (data == null || data.isEmpty()) {
            return null;
        }

        // 1. Split the string by commas into an array of values
        String[] values = data.split(",");
        
        // 2. Create the root node from the first element
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        
        // 3. Use a queue to rebuild row-by-row
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        // Use a pointer to track our position in the values array
        int i = 1; 
        
        while (!queue.isEmpty() && i < values.length) {
            TreeNode parent = queue.poll();
            
            // Handle the Left Child
            if (!values[i].equals("null")) {
                TreeNode leftChild = new TreeNode(Integer.parseInt(values[i]));
                parent.left = leftChild;
                queue.add(leftChild); // Add to queue to process its children later
            }
            i++; // Move to next value string
            
            // Handle the Right Child (make sure we haven't run out of elements)
            if (i < values.length && !values[i].equals("null")) {
                TreeNode rightChild = new TreeNode(Integer.parseInt(values[i]));
                parent.right = rightChild;
                queue.add(rightChild); // Add to queue to process its children later
            }
            i++; // Move to next value string
        }
        
        return root;
    }
}