class Solution {

    public TreeNode deleteNode(TreeNode root, int key) {

        if (root == null) return null;

        if (root.val == key) {
            if (root.left == null) return root.right; // ✅ handle null left case

            TreeNode t = root.left;
            while (t.right != null) t = t.right; // ✅ go to rightmost of left (in-order predecessor)
            t.right = root.right;
            return root.left;
        }

        TreeNode temp = root;

        while (temp != null) {

            if (temp.left != null && temp.left.val == key) {
                TreeNode nodeToDelete = temp.left;

                if (nodeToDelete.left == null) {
                    temp.left = nodeToDelete.right;
                    break;
                }

                TreeNode t = nodeToDelete.left;
                while (t.right != null) t = t.right;
                t.right = nodeToDelete.right;
                temp.left = nodeToDelete.left;
                break;
            }

            else if (temp.right != null && temp.right.val == key) {
                TreeNode nodeToDelete = temp.right;

                if (nodeToDelete.left == null) {
                    temp.right = nodeToDelete.right;
                    break;
                }

                TreeNode t = nodeToDelete.left;
                while (t.right != null) t = t.right;
                t.right = nodeToDelete.right;
                temp.right = nodeToDelete.left;
                break;
            }

            if (key < temp.val) temp = temp.left;
            else temp = temp.right;
        }

        return root;
    }
}
