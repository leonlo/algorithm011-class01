/*
 * @lc app=leetcode.cn id=120 lang=java
 *
 * [120] 三角形最小路径和
 *
 * https://leetcode-cn.com/problems/triangle/description/
 *
 * algorithms
 * Medium (65.00%)
 * Likes:    554
 * Dislikes: 0
 * Total Accepted:    97.1K
 * Total Submissions: 145.6K
 * Testcase Example:  '[[2],[3,4],[6,5,7],[4,1,8,3]]'
 *
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 *
 * 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
 *
 *
 *
 * 例如，给定三角形：
 *
 * [
 * ⁠    [2],
 * ⁠   [3,4],
 * ⁠  [6,5,7],
 * ⁠ [4,1,8,3]
 * ]
 *
 *
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 *
 *
 *
 * 说明：
 *
 * 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
 *
 */

import java.util.List;

class Solution {
    /**
     * DP Solution
     * @param triangle
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] dp = new int[triangle.size() + 1];
        for (int i = triangle.size() - 1; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }


    /**
     * recursion solution
     * @param triangle
     * @return
     */
    private int row;

    public int minimumTotal1(List<List<Integer>> triangle) {
        row = triangle.size();
        return recursion(0, 0, triangle);
    }

    private int recursion(int level, int c, List<List<Integer>> triangle) {
        if (level == row - 1) {
            return triangle.get(level).get(c);
        }
        int left = recursion(level + 1, c, triangle);
        int right = recursion(level + 1, c + 1, triangle);
        return Math.min(left, right) + triangle.get(level).get(c);
    }


    /**
     * memorized recursion solution
     */
    private Integer[][] memo;

    public int minimumTotal2(List<List<Integer>> triangle) {
        row = triangle.size();
        memo = new Integer[row][row];
        return memorizedRecursion(0, 0, triangle);
    }

    private int memorizedRecursion(int level, int c, List<List<Integer>> triangle) {
        if (memo[level][c] != null) {
            return memo[level][c];
        }
        if (level == row - 1) {
            return memo[level][c] = triangle.get(level).get(c);
        }
        int left = memorizedRecursion(level + 1, c, triangle);
        int right = memorizedRecursion(level + 1, c + 1, triangle);
        return memo[level][c] = Math.min(left, right) + triangle.get(level).get(c);
    }
}