import javax.xml.crypto.dsig.keyinfo.KeyValue;
import java.util.LinkedList;
import java.util.Queue;

public class RedBlackTree<Key extends Comparable<Key>, Value> extends BinarySearchTree<Key, Value>
{
    private TreeNode<Key, Value> root;


    public void insert(Key key, Value value)
    {
        insert(new TreeNode<>(key, value, 0));
    }

    private void insert(TreeNode<Key, Value> node)
    {
        if(root == null)
        {
            root = node;
            return;
        }

        TreeNode<Key, Value> currentNode = root;
        TreeNode<Key, Value> prev = null;
        while(currentNode!=null)
        {
            if(node.getKey().compareTo(currentNode.getKey()) > 0)
            {
                prev = currentNode;
                currentNode = currentNode.getRightChild();
            }
            else if(node.getKey().compareTo(currentNode.getKey()) < 0)
            {
                prev = currentNode;
                currentNode = currentNode.getLeftChild();
            }
            else
                currentNode.setValue(node.getValue());
        }
        if(prev!=null)
        {
            if(node.getKey().compareTo(prev.getKey()) > 0)
            {
                node.setColour("red");
                prev.setRightChild(node);
                balanceTreeNewRightChild(prev);
            }
        }

    }
    private void balanceTreeNewLeftChild(TreeNode<Key, Value> node)
    {
        if(node.getRightChild().getColour().equals("red"))
            flipColours(node);
        else if(node.getColour().equals("red"))
        {
            TreeNode<Key, Value> parent = node.getParent();
            node.getParent().setLeftChild(null);
            node.setRightChild(parent);
            flipColours(node);
        }

    }
    private void balanceTreeNewRightChild(TreeNode<Key, Value> node)
    {
        if(node.getLeftChild()!=null && node.getLeftChild().getColour().equals("red"))
            flipColours(node);
        else
        {
            TreeNode<Key, Value> parent = node.getParent();
            if(parent!=null) {
                if (node.isLeftChild()) {
                    parent.setLeftChild(node.getRightChild());
                    balanceTreeNewLeftChild(parent);
                }
                else
                {
                    parent.setRightChild(node.getRightChild());
                    balanceTreeNewRightChild(parent);
                }

                node.getRightChild().setLeftChild(node);
                node.setRightChild(null);
            }
        }

    }

    private void flipColours(TreeNode<Key, Value> node)
    {
        node.getLeftChild().setColour("black");
        node.getRightChild().setColour("black");
        node.setColour("red");
        if(node.isLeftChild())
            balanceTreeNewLeftChild(node.getParent());
        else if(node.isRightChild())
            balanceTreeNewRightChild(node.getParent());
        else
            node.setColour("black");
    }

    private TreeNode<Key, Value> get(Key key, TreeNode<Key, Value> startNode)
    {
        TreeNode<Key, Value> node = startNode;
        while(node!=null){
            if(node.getKey().equals(key))
                return node;
            else if(key.compareTo(node.getKey()) > 0)
                node = node.getRightChild();
            else
                node = node.getLeftChild();
        }
        return null;
    }
}
