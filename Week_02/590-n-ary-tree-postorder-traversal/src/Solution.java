import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal
 */
public class Solution {
    /**
     * Recursion solution
     */
    private List<Integer> res = new ArrayList<>();

    public List<Integer> postorder(Node root) {
        for (Node node : root.children) {
            postorder(node);
        }
        res.add(root.val);
        return res;
    }
}
