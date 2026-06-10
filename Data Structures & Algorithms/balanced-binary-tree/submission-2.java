/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    
    public boolean isBalanced(TreeNode root) {
        if(root==null)
        {
            return true;
        }
        int left=find_height(root.left);
        int right=find_height(root.right);

        if(Math.abs(left-right)>1)
        {
            return false;
        }
        return isBalanced(root.right) && isBalanced(root.left);
    }
    public  int find_height(TreeNode root)
    {
        if(root==null)
        {
            return 0;
        }
    
        int right=find_height(root.right);
        int left=find_height(root.left);

        
        return Math.max(right,left)+1;
    }
}
