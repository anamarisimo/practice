package Sorting;

class Pair<K,V>
{
    private K _key;
    private V _value;
    public Pair(K key, V value)
    {
        _key=key;
        _value=value;
    }

    public K getKey()
    {
        return _key;
    }
    public V getValue()
    {
        return _value;
    }
}
public class SortLinkedList {

    class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

    class Solution {
        public ListNode sortList(ListNode head)
        {
            ListNode dummyHead = new ListNode();
            dummyHead.next = head;
            int listSize = getListSize(head);
            int i = 1;


            while(i < listSize)
            {
                ListNode left = dummyHead.next;
                ListNode right = dummyHead.next;
                ListNode prevLeft = dummyHead;
                ListNode prevRight = dummyHead;

                while(left!=null)
                {
                    Pair<ListNode,ListNode> rightInfo = advanceNodeByNrPositions(left, i);
                    prevRight = rightInfo.getKey();
                    right = rightInfo.getValue();

                    if(right == null)
                        break;

                    ListNode lastInMergedSection = merge(prevLeft, prevRight, left, right, i);

                    prevLeft = lastInMergedSection;
                    left = lastInMergedSection.next;
                }

                i = i * 2;
            }

            return dummyHead.next;
        }

        private int getListSize(ListNode node)
        {
            int size = 0;
            while(node!=null)
            {
                size++;
                node = node.next;
            }
            return size;
        }

        private Pair<ListNode,ListNode> advanceNodeByNrPositions(ListNode node, int positions)
        {
            ListNode prev = null;
            for(int j=1;j<=positions;j++)
            {
                if(node==null)
                    new Pair<ListNode,ListNode>(prev, node);
                else
                {
                    prev=node;
                    node = node.next;
                }

            }
            return new Pair<ListNode,ListNode>(prev, node);
        }

        private ListNode merge(ListNode prevLeft, ListNode prevRight, ListNode left, ListNode right, int length)
        {
            ListNode lastFromResult = right;
            ListNode mid = right;

            int rightCount = 0;
            int leftCount = 0;
            while(right!=null && rightCount<length && leftCount<length && left!=mid)
            {
                if(left.val > right.val)
                {
                    moveNode1BeforeNode2(prevRight, prevLeft, right, left);
                    rightCount++;
                    lastFromResult = prevRight;

                    if(rightCount<length)
                    {

                        prevLeft=right;
                        right=prevRight.next;
                        if(right!=null)
                        {

                            mid=right;
                        }
                    }

                }
                else
                {
                    prevLeft=left;
                    left = left.next;
                    leftCount++;
                }
            }
            while(right!=null && rightCount<length)
            {
                lastFromResult = right;
                right = right.next;
                rightCount++;
            }
            return lastFromResult;
        }

        private ListNode moveNode1BeforeNode2(ListNode prevN1, ListNode prevN2, ListNode N1, ListNode N2)
        {
            if(prevN2!=null)
                prevN2.next = N1;
            prevN1.next = N1.next;
            N1.next= N2;
            return N1;
        }
    }
}
