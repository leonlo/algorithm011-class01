/**
 * Given a non-empty array of digits representing a non-negative integer, plus one to the integer.
 *
 * The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.
 *
 * You may assume the integer does not contain any leading zero, except the number 0 itself.
 *
 * https://leetcode-cn.com/problems/plus-one/
 *
 * @author leon
 */
class Solution {
    /**
     * 思路：
     * 从尾开始遍历，
     * 1. 末尾如果不为9，直接+1返回。
     * 2. 末尾如果为9，末尾9 -> 0，指针前移，循环1. 2. 最后将原数组扩容，最高位置1。
     */
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        for (int j = len - 1; j >= 0; j--) {
            if (digits[j] == 9) {
                digits[j] = 0;
            } else {
                digits[j]++;
                return digits;
            }
        }
        int[] res = new int[digits.length + 1];
        res[0] = 1;
        return res;
    }

    public static void main(String[] args) {
        int[] res = new Solution().plusOne([1, 2, 3, 4, 5]);

    }
}