import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/
 */
public class Solution {
    /**
     * Recursion solution !!!
     */
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }
        recursion(root, 0);
        return res;
    }

    private void recursion(Node node, int level) {
        if (res.size() <= level) {
            res.add(new ArrayList<>());
        }
        res.get(level).add(node.val);
        for (Node c : node.children) {
            recursion(c, level + 1);
        }
    }
}
