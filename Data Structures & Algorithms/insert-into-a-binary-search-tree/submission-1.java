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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null) return new TreeNode(val);
        TreeNode temp=root;
        TreeNode last=null;

        while(temp != null){
            if(val < temp.val){
                  last=temp;
                temp=temp.left;
            }else{
                  last=temp;
                temp=temp.right;
            }
          
        }

       if(val < last.val){
        last.left=new TreeNode(val);
       }else{
        last.right=new TreeNode(val);
       }

        return root;
    }
}