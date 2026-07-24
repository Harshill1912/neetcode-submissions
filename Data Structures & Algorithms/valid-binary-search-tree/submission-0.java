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
    public boolean BST(TreeNode root ,int max,int min){
    
    if(root==null){
        return true;
    }
      if(root.val>=max || root.val<=min ){
        return false;
      }
      return BST(root.left,root.val,min) && BST(root.right,max,root.val);
    }
    public boolean isValidBST(TreeNode root) {
        return BST(root,Integer.MAX_VALUE,Integer.MIN_VALUE);
    }
}
