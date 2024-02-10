package q98;

import common.TreeNode;

// O(n)
// O(h), h = tree height
public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        return dfs(root, null, null);
    }

    private boolean dfs(TreeNode root, Integer min, Integer max) {
        // Base case
        if (root == null) return true;
        // Conquer
        if ((min != null && root.val <= min) || (max != null && root.val >= max)) return false;
        // Divide and conquer
        return dfs(root.left, min, root.val) && dfs(root.right, root.val, max);
    }
}