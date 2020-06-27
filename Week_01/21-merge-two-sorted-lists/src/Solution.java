/**
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 */
class Solution {
    /**
     * 递归方案
     * 终止条件为链表已合并完毕， 即l1或l2为空。
     * 递归方式为，取l1与l2中较小头结点，为合并结果的头结点，头结点的next指向其余结点的合并结果。
     *
     * @param l1 1st sorted list
     * @param l2 2nd sorted list
     * @return merged sorted list
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }


    //TODO 暂时还未完全理解
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode prev = new ListNode(-1);
        ListNode curr = prev;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        curr.next = l1 != null ? l1 : l2;
        return prev.next;
    }

    public static void main(String[] args) {
        ListNode l1 = ListNode.arrayToList(new int[] { 1, 2, 5, 6, 8, 9 });
        ListNode l2 = ListNode.arrayToList(new int[] { 0, 3, 4, 7, 8, 10 });

        ListNode ml = new Solution().mergeTwoLists(l1, l2);
        // 0 -> 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 8 -> 9 -> 10 -> null
        System.out.println(ml.description());
    }
}
