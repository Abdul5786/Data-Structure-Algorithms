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
    public ListNode reverseBetween(ListNode head, int left, int right) 
    {
          
          //

         if(head == null)
          return null;

         // create a dummy node

         ListNode dummy = new ListNode(0);
         dummy.next = head;

         ListNode prev = dummy ;

         // move prev node to the left
         for(int i=1;i<left;i++)
         {
             prev = prev.next;
         }

         // now start reversing
               
               ListNode curr = prev.next ;

               for(int i=0;i<right-left;i++)
               {

                 ListNode temp = curr.next;
                 curr.next = temp.next;
                 temp.next = prev.next;
                 prev.next =temp;

               }

               return dummy.next;
    }
}