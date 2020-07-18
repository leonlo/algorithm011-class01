public class Solution {

    /**
     * DFS Solution
     * Time complexity O(HV)
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        int numOfIslands = 0;
        for (int h = 0; h < grid.length; h++) {
            for (int v = 0; v < grid[0].length; v++) {
                if (grid[h][v] == '1') {
                    numOfIslands++;
                    dfs(grid, h, v);
                }
            }
        }
        return numOfIslands;
    }

    private void dfs(char[][] grid, int h, int v) {
        if (h < 0 || v < 0 || h >= grid.length || v >= grid[0].length || grid[h][v] != '1') {
            return;
        }
        grid[h][v] = '0';
        dfs(grid, h + 1, v);
        dfs(grid, h - 1, v);
        dfs(grid, h, v + 1);
        dfs(grid, h, v - 1);
    }
}
