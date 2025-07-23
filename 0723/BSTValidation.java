import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) {
        this.val = val;
    }
}

public class BSTValidation {

    public static boolean isValidBST(TreeNode root) {
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean isValid(TreeNode node, long min, long max) {
        if (node == null) return true;
        if (node.val <= min || node.val >= max) return false;
        return isValid(node.left, min, node.val) &&
               isValid(node.right, node.val, max);
    }

    public static List<TreeNode> findInvalidNodes(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        findInvalid(root, Long.MIN_VALUE, Long.MAX_VALUE, list);
        return list;
    }

    private static void findInvalid(TreeNode node, long min, long max, List<TreeNode> list) {
        if (node == null) return;
        if (node.val <= min || node.val >= max) {
            list.add(node);
        }
        findInvalid(node.left, min, node.val, list);
        findInvalid(node.right, node.val, max, list);
    }

    public static int countNodesToRemove(TreeNode root) {
        return findInvalidNodes(root).size();
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(12);

        System.out.println(isValidBST(root));
        List<TreeNode> invalidNodes = findInvalidNodes(root);
        for (TreeNode n : invalidNodes) {
            System.out.print(n.val + " ");
        }
        System.out.println();
        System.out.println(countNodesToRemove(root));
    }
}
