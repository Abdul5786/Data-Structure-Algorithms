/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) 
    {
        PriorityQueue<ListNode> pq= new PriorityQueue<>((a,b)->a.val-b.val);

        for(ListNode list:lists)
        {
            if(list!=null)
            {
                 pq.offer(list);
            }
           
        }

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        while(!pq.isEmpty())
        {

            ListNode min = pq.poll();

            curr.next=min;
            curr=curr.next;

            if(min.next!=null)
            {
                pq.offer(min.next);
            }
        }

        return dummy.next;
    }
}