import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        generateRecursively(0, 0, n, "", res);
        return res;
    }

    private void generateRecursively(int left, int right, int n, String current, List<String> result) {
        if (left == n && right == n) {
            result.add(current);
            return;
        }
        if (left < n) {
            generateRecursively(left + 1, right, n, current + "(", result);
        }
        if (right < left) {
            generateRecursively(left, right + 1, n, current + ")", result);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().generateParenthesis(3));
    }
}
