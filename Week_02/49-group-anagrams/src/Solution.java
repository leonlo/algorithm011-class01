import java.util.*;

/**
 * https://leetcode-cn.com/problems/group-anagrams
 */
public class Solution {
    /**
     * 排序数组分类
     * K -> sorted string , V -> original string list
     *
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) {
            return new ArrayList<>();
        }
        Map<String, ArrayList<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);
        }
        return new ArrayList(map.values());
    }

    public static void main(String[] args) {
        String[] s = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> res = new Solution().groupAnagrams(s);
        for (List<String> ls : res) {
            System.out.println(ls);
        }
    }
}
