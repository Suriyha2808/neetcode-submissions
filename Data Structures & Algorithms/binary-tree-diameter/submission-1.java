class Solution {
    int max;
    public int diameterOfBinaryTree(TreeNode root) {
        
        find_height(root);
        return max;
    }
    
    
    public int find_height(TreeNode root) {
        if (root == null) {
            return 0; // An empty node adds 0 to the height
        }
        
        
        int left = find_height(root.left);
        int right = find_height(root.right);
        
        max=Math.max(max,left+right);
        
        return Math.max(left, right) + 1;
    }
}