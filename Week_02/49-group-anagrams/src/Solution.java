import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    /**
     * stupid++ solution
     *
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        List<char[]> sorted_chars_list = new ArrayList<>();
        for (String str :
                strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            sorted_chars_list.add(chars);
            System.out.println(chars);
        }

        int diffIndex = 0;
        for (int i = 1; i < sorted_chars_list.size(); i++) {
            if (Arrays.equals(sorted_chars_list.get(i), sorted_chars_list.get(diffIndex))) {

            }
        }
        return null;
    }

    public static void main(String[] args) {
        String[] s = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> res = new Solution().groupAnagrams(s);
//        for (List<String> ls : res) {
//            System.out.println(ls);
//        }
    }
}
