import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) {
        this.val = val;
    }
}

public class TreeDistance {

    public static int distanceBetweenNodes(TreeNode root, int val1, int val2) {
        TreeNode lca = lowestCommonAncestor(root, val1, val2);
        if (lca == null) return -1;
        return distanceFromNode(lca, val1, 0) + distanceFromNode(lca, val2, 0);
    }

    private static TreeNode lowestCommonAncestor(TreeNode root, int val1, int val2) {
        if (root == null) return null;
        if (root.val == val1 || root.val == val2) return root;
        TreeNode left = lowestCommonAncestor(root.left, val1, val2);
        TreeNode right = lowestCommonAncestor(root.right, val1, val2);
        if (left != null && right != null) return root;
        return left != null ? left : right;
    }

    private static int distanceFromNode(TreeNode root, int val, int dist) {
        if (root == null) return -1;
        if (root.val == val) return dist;
        int leftDist = distanceFromNode(root.left, val, dist + 1);
        if (leftDist != -1) return leftDist;
        return distanceFromNode(root.right, val, dist + 1);
    }

    public static int diameter(TreeNode root) {
        int[] max = new int[1];
        heightAndDiameter(root, max);
        return max[0];
    }

    private static int heightAndDiameter(TreeNode node, int[] max) {
        if (node == null) return 0;
        int left = heightAndDiameter(node.left, max);
        int right = heightAndDiameter(node.right, max);
        max[0] = Math.max(max[0], left + right);
        return 1 + Math.max(left, right);
    }

    public static List<Integer> nodesAtDistance(TreeNode root, int dist) {
        List<Integer> result = new ArrayList<>();
        collectNodesAtDistance(root, dist, result);
        return result;
    }

    private static void collectNodesAtDistance(TreeNode node, int dist, List<Integer> result) {
        if (node == null) return;
        if (dist == 0) {
            result.add(node.val);
            return;
        }
        collectNodesAtDistance(node.left, dist -1, result);
        collectNodesAtDistance(node.right, dist -1, result);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        System.out.println(distanceBetweenNodes(root, 4, 6)); // 4
        System.out.println(diameter(root)); // 4
        System.out.println(nodesAtDistance(root, 2)); // [4,5,6]
    }
}
