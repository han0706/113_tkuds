import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) {
        this.val = val;
    }
}

public class TreeReconstruction {

    public static TreeNode buildTreePreIn(int[] preorder, int[] inorder) {
        Map<Integer, Integer> idxMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            idxMap.put(inorder[i], i);
        }
        return buildPreIn(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, idxMap);
    }

    private static TreeNode buildPreIn(int[] preorder, int preStart, int preEnd,
                                       int[] inorder, int inStart, int inEnd,
                                       Map<Integer, Integer> idxMap) {
        if (preStart > preEnd || inStart > inEnd) return null;
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);
        int inRootIdx = idxMap.get(rootVal);
        int leftSize = inRootIdx - inStart;
        root.left = buildPreIn(preorder, preStart + 1, preStart + leftSize,
                              inorder, inStart, inRootIdx - 1, idxMap);
        root.right = buildPreIn(preorder, preStart + leftSize + 1, preEnd,
                               inorder, inRootIdx + 1, inEnd, idxMap);
        return root;
    }

    public static TreeNode buildTreePostIn(int[] postorder, int[] inorder) {
        Map<Integer, Integer> idxMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            idxMap.put(inorder[i], i);
        }
        return buildPostIn(postorder, 0, postorder.length - 1,
                           inorder, 0, inorder.length - 1, idxMap);
    }

    private static TreeNode buildPostIn(int[] postorder, int postStart, int postEnd,
                                        int[] inorder, int inStart, int inEnd,
                                        Map<Integer, Integer> idxMap) {
        if (postStart > postEnd || inStart > inEnd) return null;
        int rootVal = postorder[postEnd];
        TreeNode root = new TreeNode(rootVal);
        int inRootIdx = idxMap.get(rootVal);
        int leftSize = inRootIdx - inStart;
        root.left = buildPostIn(postorder, postStart, postStart + leftSize -1,
                               inorder, inStart, inRootIdx - 1, idxMap);
        root.right = buildPostIn(postorder, postStart + leftSize, postEnd - 1,
                                inorder, inRootIdx + 1, inEnd, idxMap);
        return root;
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        int[] postorder = {9,15,7,20,3};

        TreeNode root1 = buildTreePreIn(preorder, inorder);
        TreeNode root2 = buildTreePostIn(postorder, inorder);

        System.out.println(isSameTree(root1, root2));
    }
}
