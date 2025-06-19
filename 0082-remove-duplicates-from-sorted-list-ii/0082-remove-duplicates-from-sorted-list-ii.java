class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy, curr = head;

        while (curr != null) {
            // Duplicate check
            while (curr.next != null && curr.val == curr.next.val) {
                curr = curr.next;
            }
            if (prev.next == curr) {
                prev = prev.next;
            } else {
                prev.next = curr.next;
            }
            curr = curr.next;
        }
        return dummy.next;
    }
}