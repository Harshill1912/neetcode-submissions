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
    public int maxPath(TreeNode root,int[] maxvalue){
        if(root==null){
            return 0;
        }
        int leftsum=Math.max(0,maxPath(root.left,maxvalue));
        int rightsum=Math.max(0,maxPath(root.right,maxvalue));

        maxvalue[0]=Math.max(maxvalue[0],(root.val+leftsum+rightsum));
      
      return Math.max(leftsum,rightsum)+root.val;

    }
    public int maxPathSum(TreeNode root) {
       if(root==null){
            return 0;
        }
        int[] maxvalue=new int[1];
        maxvalue[0]=Integer.MIN_VALUE;

        maxPath(root,maxvalue);
        return maxvalue[0];
    }
}
