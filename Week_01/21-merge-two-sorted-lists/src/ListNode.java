class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    ListNode(int x, ListNode next) {
        val = x;
        this.next = next;
    }

    public static ListNode add(ListNode node, int val) {
        ListNode temp = new ListNode(val, null);
        if (node == null) {
            return temp;
        } else {
            ListNode ptr = node;
            while (ptr.next != null) {
                ptr = ptr.next;
            }
            ptr.next = temp;
        }
        return node;
    }

    public static ListNode arrayToList(int[] nodes) {
        ListNode node = null;
        for (int i = 0; i < nodes.length; i++) {
            node = add(node, nodes[i]);
        }
        return node;
    }

    public String description() {
        return showDescRecursively(val, next, "");
    }

    private String showDescRecursively(int val, ListNode next, String res) {
        res = String.format("%s%d -> ", res, val);
        if (next == null) {
            res = String.format("%s%s", res, null);
            return res;
        }
        return showDescRecursively(next.val, next.next, res);
    }

    public static void main(String[] args) {
        // test array to linked list
        ListNode node = ListNode.arrayToList(new int[] { 1, 2, 3, 4, 5, 9});
        // 1 -> 2 -> 3 -> 4 -> 5 -> 9 -> null
        System.out.println(node.description());
    }
}
