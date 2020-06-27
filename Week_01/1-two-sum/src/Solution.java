import java.util.Arrays;
import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/two-sum/
 *
 * @author leonluo
 */
class Solution {
    /**
     * 双指针无意义用法
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        int left = 0, right = len - 1;
        while (left < right) {
            if (nums[left] + nums[right] == target) {
                return new int[]{left, right};
            } else {
                right--;
                if (left >= right) {
                    left++;
                    right = len - 1;
                }
            }
        }
        return new int[0];
    }

    /**
     * 暴力法
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum1(int[] nums, int target) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (target == nums[i] + nums[j]) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }


    /**
     * 哈希表空间换时间
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum2(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < len; i++) {
            int val = target - nums[i];
            if (map.containsKey(val) && map.get(val) != i) {
                return new int[]{i, map.get(val)};
            }
        }
        return new int[0];
    }

    public static void main(String[] args) {
        Solution obj = new Solution();
        int[] res = obj.twoSum(new int[]{3, 2, 4}, 6);
        System.out.println(Arrays.toString(res));


        int[] case1 = new int[]{0, 4, 3, 0};
        int[] case1Res = obj.twoSum1(case1, 0);
        System.out.println(Arrays.toString(case1Res));
    }
}
