/**
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 */
public class Solution {
    /**
     * Stupid recursion solution
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    private TreeNode build(int[] preorder, int preStartIdx, int preEndIdx, int[] inorder, int inStartIdx, int inEndIdx) {
        if (preStartIdx == preEndIdx) {
            return null;
        }
        int rootVal = preorder[preStartIdx];
        TreeNode root = new TreeNode(rootVal);
        int inorderRootIndex = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootVal) {
                inorderRootIndex = i;
                break;
            }
        }
        int inorderLeftCount = inorderRootIndex - inStartIdx;
        root.left = build(preorder, preStartIdx + 1, preStartIdx + inorderLeftCount + 1, inorder, inStartIdx, inorderRootIndex);
        root.right = build(preorder, preStartIdx + inorderLeftCount + 1, preEndIdx, inorder, inorderRootIndex + 1, inEndIdx);
        return root;
    }
}
