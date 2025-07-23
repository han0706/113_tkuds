import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) {
        this.val = val;
    }
}

public class TreePathProblems {

    public static List<List<Integer>> allPaths(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(root, new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(TreeNode node, List<Integer> path, List<List<Integer>> result) {
        if (node == null) return;
        path.add(node.val);
        if (node.left == null && node.right == null) {
            result.add(new ArrayList<>(path));
        } else {
            backtrack(node.left, path, result);
            backtrack(node.right, path, result);
        }
        path.remove(path.size() - 1);
    }

    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        if (root.left == null && root.right == null) return root.val == targetSum;
        return hasPathSum(root.left, targetSum - root.val) ||
               hasPathSum(root.right, targetSum - root.val);
    }

    public static int maxPathSum(TreeNode root) {
        return maxPath(root);
    }

    private static int maxPath(TreeNode node) {
        if (node == null) return Integer.MIN_VALUE;
        if (node.left == null && node.right == null) return node.val;
        int left = maxPath(node.left);
        int right = maxPath(node.right);
        return node.val + Math.max(left, right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);

        List<List<Integer>> paths = allPaths(root);
        for (List<Integer> p : paths) {
            System.out.println(p);
        }

        System.out.println(hasPathSum(root, 22));
        System.out.println(maxPathSum(root));
    }
}
