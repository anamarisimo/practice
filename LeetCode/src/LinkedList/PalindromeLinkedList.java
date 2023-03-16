package LinkedList;

public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head)
    {
        int listLen = getListLen(head);
        if(listLen == 1)
            return true;
        ListNode leftPointer = head;
        ListNode rightPointer = movePointerToSecondHalfStart(head, listLen);


        rightPointer = reverseListInSecondHalf(rightPointer, listLen);

        for(int i = 0; i< listLen / 2; i++)
        {
            if(leftPointer.val !=rightPointer.val)
                return false;
            leftPointer = leftPointer.next;
            rightPointer = rightPointer.next;
        }

        return true;
    }

    private ListNode reverseListInSecondHalf(ListNode rightPointer, int listLen)
    {
        ListNode prev = rightPointer;
        ListNode current = rightPointer.next;

        if(current == null)
            return prev;
        ListNode next  = current.next;

        if(next == null)
        {
            current.next = prev;
            return current;
        }

        while(next!=null)
        {
            current.next = prev;
            prev = current;
            current = next;
            next = next.next;
        }

        current.next = prev;
        return current;
    }

    private ListNode movePointerToSecondHalfStart(ListNode startPointer, int listSize)
    {
        int position = getRightPointerMinPosition(listSize);

        for(int i=0; i<position; i++)
        {
            startPointer = startPointer.next;
        }
        return startPointer;
    }

    private int getLeftPointerMaxPosition(int listLen)
    {
        if(listLen == 1)
            return 0;
        return listLen / 2 - 1;
    }
    private int getRightPointerMinPosition(int listLen)
    {
        return listLen % 2 == 0 ? listLen / 2 : listLen / 2 + 1;
    }


    private int getListLen(ListNode node)
    {
        int res = 0;
        while(node != null)
        {
            res++;
            node = node.next;
        }
        return res;
    }
}
