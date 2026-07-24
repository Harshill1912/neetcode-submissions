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
    public int good(TreeNode root,int min){
        if(root==null){
            return 0;
        }
        int count=0;
        if(root.val>=min){
            count++;
            min=root.val;
        }
         count+=good(root.left,min);
         count+=good(root.right,min);

         return count;
    }
    public int goodNodes(TreeNode root) {
        return good(root,Integer.MIN_VALUE);
    }
}
