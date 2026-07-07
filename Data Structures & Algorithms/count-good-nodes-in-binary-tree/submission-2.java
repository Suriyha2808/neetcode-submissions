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
    int res=0;
    public void count(TreeNode root,int maxi)
    {
        if(root==null)
        {
            return;
        }
        if(root.val >= maxi)
        {
            res++;
            maxi=root.val;
        }

        count(root.left,maxi);
        count(root.right,maxi);
    }
    public int goodNodes(TreeNode root) 
    {
        if(root==null)
        {
            return 0;
        }
        count(root,root.val);
        return res;
    } 

}

