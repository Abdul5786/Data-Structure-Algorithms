class Solution {
    public boolean isPalindrome(ListNode head) 
    {
        if(head==null) return true;

        ListNode slow= head;
        ListNode fast=head;
        ListNode prev= null;

        while(fast!=null && fast.next!=null)
        {
            fast= fast.next.next;
            ListNode nextNode= slow.next;
            slow.next=prev;
            prev=slow;
            slow=nextNode;

        }

        if(fast!=null)
        {
            slow=slow.next;
        }

        while(slow!=null)
        {
            if(prev.val!=slow.val)
            {
                return false;
            }

            prev=prev.next;
            slow=slow.next;
        }
      return true;
    }
}