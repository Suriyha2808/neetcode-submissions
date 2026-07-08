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
    public ArrayList<Integer> list=new ArrayList<>();
    public void find(TreeNode root)
    {
        if(root==null)
        {
            return ;
        }
        find(root.left);
        list.add(root.val);
        find(root.right);
    }

    public int kthSmallest(TreeNode root, int k) {
        find(root);
        return list.get(k-1);
    }
}
