import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) {
        this.val = val;
    }
}

public class BSTConversion {

    public static TreeNode bstToDoublyList(TreeNode root) {
        if (root == null) return null;
        List<TreeNode> nodes = new ArrayList<>();
        inOrder(root, nodes);
        for (int i = 0; i < nodes.size(); i++) {
            TreeNode curr = nodes.get(i);
            TreeNode prev = i > 0 ? nodes.get(i - 1) : null;
            TreeNode next = i < nodes.size() - 1 ? nodes.get(i + 1) : null;
            curr.left = prev;
            curr.right = next;
        }
        return nodes.get(0);
    }

    private static void inOrder(TreeNode node, List<TreeNode> nodes) {
        if (node == null) return;
        inOrder(node.left, nodes);
        nodes.add(node);
        inOrder(node.right, nodes);
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        return buildBST(nums, 0, nums.length -1);
    }

    private static TreeNode buildBST(int[] nums, int left, int right) {
        if (left > right) return null;
        int mid = left + (right - left)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildBST(nums, left, mid -1);
        root.right = buildBST(nums, mid + 1, right);
        return root;
    }

    public static void convertBST(TreeNode root) {
        convert(root, new int[]{0});
    }

    private static void convert(TreeNode node, int[] sum) {
        if (node == null) return;
        convert(node.right, sum);
        sum[0] += node.val;
        node.val = sum[0];
        convert(node.left, sum);
    }

    public static void printDoublyList(TreeNode head) {
        TreeNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.right;
        }
        System.out.println();
    }

    public static void inorderPrint(TreeNode root) {
        if (root == null) return;
        inorderPrint(root.left);
        System.out.print(root.val + " ");
        inorderPrint(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);

        TreeNode head = bstToDoublyList(root);
        printDoublyList(head);

        int[] sortedArr = {1,2,3,4,5,6,7};
        TreeNode balancedBST = sortedArrayToBST(sortedArr);
        inorderPrint(balancedBST);
        System.out.println();

        convertBST(root);
        inorderPrint(root);
        System.out.println();
    }
}
