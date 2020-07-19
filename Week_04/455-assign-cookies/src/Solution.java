import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/assign-cookies/
 */
public class Solution {
    public int findContentChildren(int[] g, int[] s) {
        if (g == null || s == null) {
            return 0;
        }
        Arrays.sort(g);
        Arrays.sort(s);
        int gi = 0, si = 0;
        while (gi < g.length && si < s.length) {
            if (g[gi] <= s[si]) {
                gi++;
            }
            si++;
        }
        return gi;
    }

    public static void main(String[] args) {
        int res = new Solution().findContentChildren(new int[] {1, 2}, new int[] {1, 2, 5});
        System.out.println(res);
    }
}
