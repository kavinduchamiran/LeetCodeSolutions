package Easy.MaximumDepthOfBinaryTree;


import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

class TreeNode {
    int val;
    int depth;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();

//        TreeNode root = new TreeNode(3);
//        root.left = new TreeNode(9);
//        TreeNode l12 = new TreeNode(20);
//        root.right = l12;
//        l12.left = new TreeNode(15);
//        l12.right = new TreeNode(7);

        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.left.left = new TreeNode(5);
        root.left.left.right = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(-1);
        root.right.left.right = new TreeNode(6);
        root.right.right.right = new TreeNode(8);

        System.out.println(s.maxDepth(root));

    }


    // based on recursive DFS
    // fastest solution
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;

        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    // based on BFS
    // a bit slow
    public int maxDepth2(TreeNode root) {
        // BFS works by going level by level in a tree.
        // we can use a queue to add and consume all nodes in a single level
        Queue<TreeNode> queue = new ArrayDeque<>();

        // we start with the root node
        queue.add(root);

        int levels = 0;

        while (!queue.isEmpty()) {
            // how many nodes are currently in this level?
            int len = queue.size();
            for (int k = 0; k < len; k++) {
                // we get the leftmost node, and add all its children to the right end of the list
                // we do that k times where k is the count of nodes in this level
                TreeNode node = queue.remove();

                if (node.left != null)
                    queue.add(node.left);

                if (node.right != null)
                    queue.add(node.right);
            }

            // after we went through all nodes in a level, we increase the level by 1
            levels++;
        }

        return levels;
    }


    // 3rd solution using iterative DFS.
    // requires a new property in TreeNode to keep track of the depth.
    public int maxDepth3(TreeNode root) {
        if (root == null)
            return 0;

        int maxDepth = 0;

        Stack<TreeNode> stack = new Stack<>();
        root.depth = 1;
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();

            if (node != null) {
                maxDepth = Math.max(maxDepth, node.depth);

                if (node.left != null) {
                    node.left.depth = node.depth + 1;
                    stack.push(node.left);
                }

                if (node.right != null) {
                    node.right.depth = node.depth + 1;
                    stack.push(node.right);
                }
            }
        }

        return maxDepth;
    }
}
