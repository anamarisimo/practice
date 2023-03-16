package LinkedList;

import java.util.Stack;

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      public void print()
      {
          ListNode current = this;
          String output = "";
          while(current!=null)
          {
              output = output + " " + current.val;
              current = current.next;
          }
          System.out.println(output);
      }
  }

public class ReverseLinkedList {
    private ListNode dumb = new ListNode();
    private ListNode result = new ListNode();
    private ListNode initHead = new ListNode();
    private ListNode recursiveHead = new ListNode();
    public ListNode reverseListIterativeNoStack(ListNode head)
    {
        ListNode prev = null;
        ListNode current = head;
        ListNode next = null;
        while(current!=null)
        {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    public ListNode revRecursion(ListNode head)
    {
        reverseListRecursive(head);
        return recursiveHead;
    }
    public ListNode reverseListRecursive(ListNode head)
    {
       if(head.next == null)
       {
           recursiveHead = head;
           return head;
       }
       ListNode prev = reverseListRecursive(head.next);
       prev.next = head;
       head.next = null;
       return head;
    }

    private int reverse(ListNode head)
    {
        if(head.next==null)
        {
            result.val = head.val;
            return head.val;
        }

        else
        {
            int value = head.val;
            int nextVal = reverse(head.next);
            result.val = nextVal;
            result.next = new ListNode();
            result = result.next;

            if(head.equals(initHead.next))
            {
                result.val = value;
            }
            return value;
        }
    }

    public ListNode reverseListIterativeStack(ListNode head)
    {
        Stack<Integer> vals = new Stack<>();
        ListNode result = new ListNode();
        ListNode dummy = new ListNode();
        dummy.next = result;

        ListNode node = head;
        if(head==null)
            return null;

        while(node!=null)
        {
            vals.push(node.val);
            node = node.next;
        }

        while(!vals.empty())
        {
            result.val = vals.pop();
            if(!vals.empty())
            {
                result.next = new ListNode();
                result = result.next;
            }
        }
        return dummy.next;
    }

}
