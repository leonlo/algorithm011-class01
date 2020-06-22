import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/move-zeroes/
 *
 * @author leon
 */
public class Solution {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (i != index) {
                    nums[index] = nums[i];
                    nums[i] = 0;
                }
                index++;
            }
        }
    }

    public static void main(String[] args) {
        int[] c = new int[] {0, 0, 0 ,1 ,3, 6, 0, 1, 0};
        new Solution().moveZeroes(c);
        System.out.println(Arrays.toString(c));

    }

}
