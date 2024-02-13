package q104;

import java.util.LinkedList;
import java.util.Queue;

import common.TreeNode;

public class MaximumDepthOfBinaryTree {
    static class DFS {
        // T(n) = O(n)
        // S(n) = O(h)
        public int maxDepth(TreeNode root) {
            return root == null ? 0 :  Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        }
    }

    static class BFS {
        public int maxDepth(TreeNode root) {
            if (root == null) return 0;
            int depth = 0;
            Queue<TreeNode> queue = new LinkedList<>(); // S(n) = O(n)
            queue.offer(root);
            while (!queue.isEmpty()) { // T(n) = O(n)
                int size = queue.size();
                while (size > 0) {
                    TreeNode node = queue.poll();
                    size--;
                    if (node.left != null) queue.offer(node.left);
                    if (node.right != null) queue.offer(node.right);
                }
                depth++;
            }
            return depth;
        }
    }
}
