package LinkedList;

public class Main {
    public static void main(String[] args) {
        //testMergeSortedLists();
       // testBackwardsTraversal();
        testReverseLinkedList();
    }

    private static void testReverseLinkedList()
    {
        ListNode list1 = new ListNode(1);
        list1.next=new ListNode(2);
        list1.next.next=new ListNode(4);
        ReverseLinkedList revRecursie = new ReverseLinkedList();
        ListNode res = revRecursie.revRecursion(list1);

        while(res!=null)
        {
            System.out.println(res.val);
            res = res.next;
        }
    }

    private static void testBackwardsTraversal()
    {
        ListNode list1 = new ListNode(1);
        list1.next=new ListNode(2);
        list1.next.next=new ListNode(4);
        TraverseListTailToHead traverser = new TraverseListTailToHead();
        traverser.traverse(list1);
    }
    private static void testMergeSortedLists()
    {
        ListNode list1 = new ListNode(1);
        list1.next=new ListNode(2);
        list1.next.next=new ListNode(4);

        ListNode list2 = new ListNode(1);
        list2.next=new ListNode(3);
        list2.next.next=new ListNode(4);
        list1.print();
        list2.print();
        System.out.println("merging");
        MergeTwoSortedLists merger = new MergeTwoSortedLists();
        ListNode result = merger.mergeTwoLists(list1, list2);
        list1.print();
        list2.print();
        result.print();

    }
}
