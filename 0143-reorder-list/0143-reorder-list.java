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
    public void reorderList(ListNode head) 
    {
      if(head==null || head.next==null || head.next.next==null)
      {
          return;
      } 

      // finding the middle to partion the list in two

      ListNode fast = head;
      ListNode slow =head;

      while(fast!=null && fast.next!=null)
      {
         slow = slow.next;
         fast = fast.next.next;
      }

      ListNode secondHead = slow.next; // seconfList head
      slow.next=null;
      ListNode curr = secondHead;
      ListNode prev=null;
      while(curr!=null)
      {
          ListNode nextNode = curr.next;
          curr.next = prev;
          prev =curr;
          curr= nextNode; // reversed 
      }

      // adding element in the list

      ListNode t1 = head;
      ListNode t2 = prev;

      while(t2!=null)
      {
          ListNode m1  =   t1.next;
          ListNode m2  =   t2.next;
          t1.next = t2;
          t2.next= m1;
          t1=m1;
          t2=m2;   
      }

    }
}