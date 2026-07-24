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
    static int count;
    public static void helper(TreeNode root,int max1,int max2){
        if(root == null) return;

        if(root.val >= max1){
            max2=max1;
            max1=root.val;
            count++;
        }

        helper(root.left,max1,max2);
        helper(root.right,max1,max2);

        if(root.val == max1){
            max1=max2;
            max2=Integer.MIN_VALUE;
        }
    }
    public int goodNodes(TreeNode root) {
        if(root == null) return 0;
        count=0;

        helper(root,Integer.MIN_VALUE,Integer.MIN_VALUE);

        return count;
    }
}
