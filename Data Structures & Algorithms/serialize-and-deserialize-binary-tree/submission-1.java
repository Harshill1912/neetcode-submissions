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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "null";
        StringBuilder str=new StringBuilder();
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        str.append(root.val).append(",");

        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                TreeNode curr=q.poll();

                if(curr.left != null){
                    q.offer(curr.left);
                    str.append(curr.left.val);
                    str.append(",");
                }else{
                    str.append("null");
                    str.append(",");
                }

                if(curr.right != null){
                    q.offer(curr.right);
                    str.append(curr.right.val);
                    str.append(",");
                }else{
                    str.append("null");
                    str.append(",");
                }
            }
        }

        return str.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
 if (data.equals("null")) return null;

        String[] parts = data.split(",");
        Queue<TreeNode> q = new LinkedList<>();

        TreeNode root = new TreeNode(Integer.parseInt(parts[0]));
        q.offer(root);

        int i = 0; // Index in parts
        while (!q.isEmpty()) {
            TreeNode temp = q.poll();

            int lf = 2 * i + 1;
            int rh = 2 * i + 2;
    
            if (lf < parts.length) {
                if (!parts[lf].equals("null")) {
                    TreeNode leftNode = new TreeNode(Integer.parseInt(parts[lf]));
                    temp.left = leftNode;
                    q.offer(leftNode);
                }
            }


            if (rh < parts.length) {
                if (!parts[rh].equals("null")) {
                    TreeNode rightNode = new TreeNode(Integer.parseInt(parts[rh]));
                    temp.right = rightNode;
                    q.offer(rightNode);
                }
            }

            i++;
        }

        return root;
        
    }
}
