class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) {
        this.val = val;
    }
}

public class TreeComparison {

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) return false;
        if (isSameTree(root, subRoot)) return true;
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public static TreeNode maxCommonSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) return null;
        if (isSameTree(root1, root2)) return root1;

        TreeNode left = maxCommonSubtree(root1.left, root2.left);
        TreeNode right = maxCommonSubtree(root1.right, root2.right);

        if (left != null) return left;
        if (right != null) return right;
        return null;
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);

        System.out.println(isSameTree(root1, root1));
        System.out.println(isSubtree(root1, root2));

        TreeNode common = maxCommonSubtree(root1, root2);
        if (common != null) {
            System.out.println("最大公共子樹根節點值: " + common.val);
        } else {
            System.out.println("無公共子樹");
        }
    }
}
