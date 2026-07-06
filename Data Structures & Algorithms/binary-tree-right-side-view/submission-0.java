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
    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        if(root==null)
        {
            return result;
        }
        Queue<TreeNode> line = new LinkedList<>();
        line.add(root);

        while(!line.isEmpty())
        {
            int level = line.size();

            for(int i=0;i<level;i++)
            {
                TreeNode curroot = line.poll();
                if(i==level-1)
                {
                    result.add(curroot.val);
                }

                if(curroot.left!=null)
                {
                    line.add(curroot.left);
                }
                if(curroot.right!=null)
                {
                    line.add(curroot.right);
                }
            }
        }
        return result;
    }
}
