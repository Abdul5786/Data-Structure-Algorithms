class Solution {
    public void deleteNode(ListNode node) {
        // Step 1: Copy the value of the next node into the current node
        node.val = node.next.val;

        // Step 2: Make the current node point to the next-to-next node
        node.next = node.next.next;
    }
}