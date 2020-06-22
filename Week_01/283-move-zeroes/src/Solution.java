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

    void moveZeroes2(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int lastNonZeroIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[lastNonZeroIndex++] = nums[i];
            }
        }

        for (int i = lastNonZeroIndex; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    public static void main(String[] args) {
        int[] c = new int[] {0, 0, 0 , 1, 3, 6, 0, 1, 0};
        Solution solution = new Solution();
        solution.moveZeroes(c);
        System.out.println(Arrays.toString(c));

        int[] c1 = new int[] {0, 0 ,1, 0, 6, 0, 0, 0, 3};
        new Solution().moveZeroes2(c1);
        System.out.println(Arrays.toString(c1));
    }

}
