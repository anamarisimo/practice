package LinkedList;

public class TraverseListTailToHead
{
    public void traverse(ListNode node)
    {
        if(node == null)
            return;
        traverse(node.next);
        System.out.println(node.val);
    }


}
