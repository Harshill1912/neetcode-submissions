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
        List<Integer> list=new ArrayList<>();
        if(root == null) return list;

        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        list.add(root.val);

        while(!q.isEmpty()){
            ArrayList<Integer> temp=new ArrayList<>();
            int size=q.size();

            for(int i=0;i<size;i++){
                TreeNode curr=q.poll();

                if(curr.left!=null){
                    temp.add(curr.left.val);
                    q.offer(curr.left);
                }

                if(curr.right != null){
                    temp.add(curr.right.val);
                    q.offer(curr.right);
                }
            }
           if(temp.size() > 0) list.add(temp.get(temp.size()-1));
        }

        return list;
    }
}
