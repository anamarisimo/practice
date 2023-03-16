import java.util.Iterator;

public class Stack_LinkedList<Item> implements Iterable<Item>
{
    private Node<Item> top;

    public boolean isEmpty(){
        return top == null;
    }
    public void push(Item item){
        Node<Item> oldTop = top;
        top = new Node<Item>();
        top.item = item;
        top.next = oldTop;
    }

    public Item pop(){
        if(isEmpty())
            return null;
        Item item = top.item;
        top = top.next;
        return item;
    }

    public Item peek(){
        if(isEmpty())
            return null;
        return top.item;
    }

    public void display(){
        top.displayWithAllDescendants();
    }

    public Iterator<Item> iterator() {
        return new LinkedListIterator<Item>(top);
    }
}
