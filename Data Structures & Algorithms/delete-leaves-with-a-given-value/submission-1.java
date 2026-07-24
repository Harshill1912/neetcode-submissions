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
    public static boolean isLeaf(TreeNode root){
        return root.left == null && root.right == null;
    }
    public static TreeNode helper(TreeNode root,int target){
        if(root==null) return null;
        

        TreeNode node=root;
        node.left=helper(root.left,target);
        node.right=helper(root.right,target);

        if(isLeaf(root) && root.val==target){
            return null;
        }

        return node;
    }
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        TreeNode tree=null;

       return  helper(root,target);
    }
}