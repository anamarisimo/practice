package LinkedList;

public class Intersection2LinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB)
    {
        ListNode currentA = headA;
        ListNode currentB = headB;

        int firstLen = getListLength(headA);
        int secondLen = getListLength(headB);

        int difference = Math.abs(firstLen - secondLen);
        boolean isFirstLarger = false;
        if(firstLen > secondLen)
        {
            isFirstLarger = true;
        }

        if(isFirstLarger)
        {
            currentA = traverseListKNodes(currentA, difference);
        }
        else
        {
            currentB = traverseListKNodes(currentB, difference);
        }

        while(currentA!=null && currentB!=null && !currentA.equals(currentB))
        {
            currentA = currentA.next;
            currentB = currentB.next;
        }
        if(currentA==null || currentB==null)
            return null;
        else
            return currentA;

    }

    private ListNode traverseListKNodes(ListNode current, int k)
    {
        for(int i=0; i< k; i++)
        {
            current = current.next;
        }
        return current;
    }

    private int getListLength(ListNode node)
    {
        int len = 0;
        while(node!=null)
        {
            node = node.next;
            len++;
        }
        return len;
    }
}
