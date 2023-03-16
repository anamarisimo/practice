package LinkedList;

public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2)
    {
        ListNode result = merge(list1, list2);
        return result;
    }

    private ListNode merge(ListNode list1, ListNode list2)
    {
        ListNode current = new ListNode(-1);
        ListNode prehead = current;

        while(list1!=null && list2!=null)
        {
            if(list1.val <= list2.val)
            {
                current.next = list1;
                list1 = list1.next;
            }
            else
            {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        if(list1!=null)
        {
            current.next = list1;
        }
        if(list2!=null)
        {
            current.next = list2;
        }

        return prehead.next;
    }
}