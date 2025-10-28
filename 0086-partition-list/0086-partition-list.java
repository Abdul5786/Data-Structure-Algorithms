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
    public ListNode partition(ListNode head, int x) 
    {
        ListNode smaller = new ListNode(0);
       ListNode larger = new ListNode(0);


        ListNode smallPointer = smaller;

        ListNode largePointer = larger;


        while(head!=null)
        {

            if(head.val<x)
            {
                smallPointer.next = head;
                smallPointer = smallPointer.next;
            }

            else
            {

                largePointer.next = head;
                largePointer = largePointer.next;
            }

            head = head.next;
        }

        smallPointer.next = larger.next;
        largePointer.next=null;


        return smaller.next;

    }
}