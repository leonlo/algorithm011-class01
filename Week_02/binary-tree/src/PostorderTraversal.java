import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/binary-tree-postorder-traversal/
 */
public class PostorderTraversal {
    /**
     * Recursion solution
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        recursion(root, res);
        return res;
    }

    private void recursion(TreeNode node, List<Integer> res) {
        if (node != null) {
            if (node.left != null) {
                recursion(node.left, res);
            }
            if (node.right != null) {
                recursion(node.right, res);
            }
            res.add(node.val);
        }
    }

    /**
     * Stack solution
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        TreeNode last = null;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.peek();
            if (curr.right == null || curr.right == last) {
                res.add(curr.val);
                stack.pop();
                last = curr;
                curr = null;
            } else {
                curr = curr.right;
            }
        }
        return res;
    }
}
