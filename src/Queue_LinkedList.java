import com.sun.source.tree.ReturnTree;

import java.util.Iterator;

public class Queue_LinkedList<Item> implements Iterable<Item>
{
    private Node<Item> first = null;
    private Node<Item> last = null;
    private int size = 0;

    private boolean isEmpty(){
        return first==null;
    }
    public void enqueue(Item item)
    {
        Node<Item> oldLast = last;
        last = new Node<Item>();
        last.item = item;
        if(isEmpty())
        {
            first = last;
        }
        else
            oldLast.next = last;
        size++;
    }

    public int getSize() {
        return size;
    }

    public Item dequeue()
    {
        if(isEmpty())
            return null;
        Item itemToReturn = first.item;
        first = first.next;
        size--;
        return itemToReturn;
    }

    public Item peek()
    {
        if(isEmpty())
            return null;
        return first.item;
    }

    public void display(){
        first.displayWithAllDescendants();
    }

    public Iterator<Item> iterator() {
        return new LinkedListIterator<Item>(first);
    }
}
