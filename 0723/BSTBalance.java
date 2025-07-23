class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) {
        this.val = val;
    }
}

public class BSTBalance {

    public static boolean isBalanced(TreeNode root) {
        return checkHeight(root) != -1;
    }

    private static int checkHeight(TreeNode node) {
        if (node == null) return 0;
        int leftHeight = checkHeight(node.left);
        if (leftHeight == -1) return -1;
        int rightHeight = checkHeight(node.right);
        if (rightHeight == -1) return -1;
        if (Math.abs(leftHeight - rightHeight) > 1) return -1;
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static int balanceFactor(TreeNode node) {
        if (node == null) return 0;
        return height(node.left) - height(node.right);
    }

    private static int height(TreeNode node) {
        if (node == null) return 0;
        return 1 + Math.max(height(node.left), height(node.right));
    }

    public static TreeNode mostUnbalancedNode(TreeNode root) {
        if (root == null) return null;
        TreeNode[] res = new TreeNode[1];
        int[] maxDiff = {0};
        helper(root, res, maxDiff);
        return res[0];
    }

    private static int helper(TreeNode node, TreeNode[] res, int[] maxDiff) {
        if (node == null) return 0;
        int leftH = helper(node.left, res, maxDiff);
        int rightH = helper(node.right, res, maxDiff);
        int diff = Math.abs(leftH - rightH);
        if (diff > maxDiff[0]) {
            maxDiff[0] = diff;
            res[0] = node;
        }
        return 1 + Math.max(leftH, rightH);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);

        System.out.println(isBalanced(root));
        System.out.println(balanceFactor(root));
        TreeNode unbalanced = mostUnbalancedNode(root);
        if (unbalanced != null) {
            System.out.println("最不平衡節點值: " + unbalanced.val);
        }
    }
}
