import java.util.Arrays;

/***
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 */
class Solution {
    /**
     * 快慢指针法
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int i = 0, j = 1;
        while (j < nums.length) {
            if (nums[i] != nums[j]) {
                nums[i + 1] = nums[j];
                i++;
            }
            j++;
        }
        return i + 1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 0, 1, 2, 3, 4, 4, 8, 8, 9};
        int len = new Solution().removeDuplicates(nums);
        System.out.println(len);
        System.out.println(Arrays.toString(nums));
    }
}