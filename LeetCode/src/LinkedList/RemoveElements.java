package LinkedList;

public class RemoveElements {
    public ListNode removeElements(ListNode head, int val)
    {
        if(head == null)
            return null;

        ListNode preStart = new ListNode();
        preStart.next = head;
        ListNode iterator = preStart;
        ListNode banIterator = preStart;
        while(iterator!=null)
        {
            while(iterator.next !=null && iterator.next.val == val)
            {
                iterator = iterator.next;
            }
            banIterator.next = iterator.next;
            banIterator = banIterator.next;
            iterator = iterator.next;
        }

        return preStart.next;
    }
}
