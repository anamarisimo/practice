package LinkedList;

public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists)
    {
        if(lists.length == 0)
            return null;

        return mergeKListsRec(lists, 0, lists.length-1);
    }

    private ListNode mergeKListsRec(ListNode[] lists, int low, int high)
    {
        if(low == high)
            return lists[low];
        int mid = (low + high)/2;

        ListNode list1 = mergeKListsRec(lists, low, mid);
        ListNode list2 = mergeKListsRec(lists, mid+1, high);
        return merge(list1, list2);
    }

    private ListNode merge(ListNode list1, ListNode list2)
    {

        ListNode currentL1 = list1;
        ListNode currentL2 = list2;

        ListNode current = new ListNode(1);
        ListNode start = current;

        while(currentL1!=null && currentL2!=null)
        {
            if(currentL1.val < currentL2.val)
            {
                current.next = currentL1;
                currentL1 = currentL1.next;
            }
            else
            {
                current.next =  currentL2;
                currentL2 = currentL2.next;
            }
            current = current.next;
        }

        if(currentL1!=null)
        {
            current.next = currentL1;
        }

        if(currentL2!=null)
        {
            current.next = currentL2;
        }

        return start.next;

    }

}
