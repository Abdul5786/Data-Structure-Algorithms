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
    public ListNode reverseList(ListNode head)   // 1->2 reversing   2-> 1
    {                                            // next , prev , 
       ListNode curr = head;
       ListNode prev=null;

       while(curr!=null)
       {

         ListNode next = curr.next;
         curr.next= prev;   // break the connection
         prev=curr;
         curr=next;
      }

      return prev;
    }

}