import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/valid-anagram/
 */
public class Solution {

    /**
     * stupid solution
     * time complexity O(nlogn)
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram0(String s, String t) {
        char[] sa = s.toCharArray();
        char[] ta = t.toCharArray();
        Arrays.sort(sa);
        Arrays.sort(ta);
        return Arrays.equals(sa, ta);
    }

    /**
     * hash table solution 1
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] chars = new int[26];
        for (int i = 0; i < s.length(); i++) {
            chars[s.charAt(i) - 'a']++;
            chars[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (chars[i] != 0) {
                return false;
            }
        }
        return true;
    }


    /**
     * hash table solution 2
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram1(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] chars = new int[26];
        for (int i = 0; i < s.length(); i++) {
            chars[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            if (--chars[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        boolean isAnagram = new Solution().isAnagram1("anagram", "nagaram");
        System.out.println(isAnagram);
    }
}
