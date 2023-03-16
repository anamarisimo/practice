import java.util.Iterator;

public class LinkedList<Item> implements Iterable<Item>
{
    private Node<Item> first = null;
    private int size = 0;

    private boolean isEmpty(){
        return first==null;
    }

    public int size() {
        return size;
    }

    public void add(Item item)
    {
        Node<Item> oldFirst = first;
        first = new Node<Item>();
        first.item = item;
        first.next = oldFirst;
        size++;
    }

    public Iterator<Item> iterator() {
        return new LinkedListIterator<Item>(first);
    }
}
