

public class Node<Item> {
    public Item item;
    public Node<Item> next;

    public void displayWithAllDescendants()
    {
        Node<Item> currentNode = this;
        while(currentNode!=null)
        {
            System.out.print(currentNode.item);
            System.out.print(" ");
            currentNode = currentNode.next;
        }
        System.out.println(" ");
    }
}
