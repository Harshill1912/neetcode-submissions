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
    static int max;
    public static int helper(TreeNode root,int sum){
        if(root == null) return 0;

        int lh=Math.max(helper(root.left,sum),0);
        int rh=Math.max(helper(root.right,sum),0);

        max=Math.max(max,lh+rh+root.val);

        return Math.max(lh,rh)+root.val;
    }
    public int maxPathSum(TreeNode root) {
        max=Integer.MIN_VALUE;

         helper(root,0);

         return max;
    }
}
