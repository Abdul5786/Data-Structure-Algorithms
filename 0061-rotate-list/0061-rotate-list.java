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
    public ListNode rotateRight(ListNode head, int k) 
    {
        // edge case

        if(head==null || k==0)
        {
            return head;
        }

        // len calculate krenge

        ListNode curr= head;
        int len=1;

      while(curr.next!=null)
      {
         curr =curr.next;
         len++;
      }

       k = k%len;

       if(k==0) return head;

       curr.next=head;  // cycle created 
       curr=head;

       for(int i=1;i<len-k;i++)
       {
         curr = curr.next;
       }

       head = curr.next;
       curr.next=null;

       return head;
    }
}