class Solution {
    
    public int max = Integer.MIN_VALUE;

    public int cal(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftGain = Math.max(0, cal(root.left));
        int rightGain = Math.max(0, cal(root.right));

        int priceNewPath = root.val + leftGain + rightGain;

        max = Math.max(max, priceNewPath);

        return root.val + Math.max(leftGain, rightGain);
    }

    public int maxPathSum(TreeNode root) {
        cal(root);
        return max;
    }
}