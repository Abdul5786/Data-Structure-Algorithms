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
        // step 1 first create min heap 

       PriorityQueue<ListNode> pq =  new PriorityQueue<>((a,b)->a.val-b.val);


       // now put all first elements of list or head node into queue

       for(ListNode node :lists)
       {
         if(node!=null)
         {
            pq.offer(node);
         }
       }

       // creat a dummy node taaki result bnana esay ho 

       ListNode dummy =  new ListNode(-1);
       ListNode curr =dummy;

       // jab tak heap khaali nhi hota

       while(!pq.isEmpty())
       {
         ListNode min = pq.poll();
         curr.next=min;
         curr=curr.next;

         // if node exist then put into the heap

         if(min.next!=null)
         {
            pq.offer(min.next);
         }
       }

       return dummy.next;
    }
}