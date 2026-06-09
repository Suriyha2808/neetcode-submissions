class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        // 1. Calculate the longest path that passes through the CURRENT root
        // True height of left side + True height of right side
        int max1 = find_height(root.left) + find_height(root.right);
        
        // 2. Recursively find the max diameter inside the right and left subtrees
        int mr = diameterOfBinaryTree(root.right);
        int ml = diameterOfBinaryTree(root.left);
        
        int max = Math.max(mr, ml);
        return Math.max(max1, max);
    }
    
    // Change name to 'find_height' because we want the maximum single depth
    public int find_height(TreeNode root) {
        if (root == null) {
            return 0; // An empty node adds 0 to the height
        }
        
        // Find the height of each side
        int left = find_height(root.left);
        int right = find_height(root.right);
        
        // CRITICAL FIX: You must take the MAX of the two paths, 
        // not add them together! A node can only pass its tallest branch up.
        return Math.max(left, right) + 1;
    }
}