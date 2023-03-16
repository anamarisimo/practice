package LinkedList;

public class MiddleLinkedList
{
    public ListNode middleNode(ListNode head)
    {
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null)
        {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
