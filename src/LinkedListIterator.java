import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedListIterator<Item> implements Iterator<Item> {
    private Node<Item> current;

    public LinkedListIterator(Node<Item> first) {
        current = first;
    }

    public boolean hasNext() {
        return current != null;
    }

    public Item next() {
        if (!hasNext()) throw new NoSuchElementException();
        Item item = current.item;
        current = current.next;
        return item;
    }
}
