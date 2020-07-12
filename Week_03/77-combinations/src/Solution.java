import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/combinations/
 */
public class Solution {
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        if (k <= 0 || n < k) {
            return res;
        }
        backtrack(n, k, 1, new Stack<>());
        return res;
    }

    private void backtrack(int n, int k, int begin, Stack<Integer> pre) {
        if (pre.size() == k) {
            res.add(new ArrayList<>(pre));
            return;
        }
        for (int i = begin; i <= n; i++) {
            pre.add(i);
            backtrack(n, k, i + 1, pre);
            pre.pop();
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> res = new Solution().combine(4, 2);
        System.out.println(res);
    }
}
