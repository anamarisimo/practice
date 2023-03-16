package LinkedList;

public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null) {
            slow = slow.next;

            if (fast.next == null)
                return false;

            fast = fast.next.next;

            if (slow.equals(fast))
                return true;
        }


        return false;
    }
}
