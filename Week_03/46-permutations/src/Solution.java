import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    /**
     * backtrack template
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), nums);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> temp, int [] nums){
        if (temp.size() == nums.length) {
            list.add(new ArrayList<>(temp));
        } else {
            for (int num : nums) {
                if (temp.contains(num)) {
                    continue;
                }
                temp.add(num);
                backtrack(list, temp, nums);
                temp.remove(temp.size() - 1);
            }
        }
    }


    public static void main(String[] args) {
        List<List<Integer>> res = new Solution().permute(new int[] { 1, 2, 3, 4});
        for (List<Integer> i:
                res) {
            System.out.println(i);
        }
    }
}
