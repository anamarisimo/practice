import java.io.PrintStream;

public class BinarySearchTree<Key extends Comparable<Key>, Value> {
    protected TreeNode<Key, Value> root;

    public TreeNode<Key, Value> getRoot()
    {
        return root;
    }

    public Value get(Key key)
    {
        TreeNode<Key, Value> searched = get(key, root);
        return searched == null ? root.getValue() : searched.getValue();
    }


    public TreeNode<Key, Value> getNode(Key key)
    {
        TreeNode<Key, Value> searched = get(key, root);
        return searched == null ? root : searched;
    }

    public TreeNode<Key, Value> getSuccessor(TreeNode<Key, Value> node)
    {
        if(node.hasRightSubtree())
        {
            return getMin(node.getRightChild());
        }
        else
        {
            TreeNode<Key, Value> current = node;
            while(current.isRightChild())
            {
                current = current.getParent();
            }
            return current.getParent();
        }
    }

    public TreeNode<Key, Value> getPredecessor(TreeNode<Key, Value> node)
    {
        if(node.hasLeftSubtree())
        {
            return getMax(node.getLeftChild());
        }
        else
        {
            TreeNode<Key, Value> current = node;
            while(current.isLeftChild())
            {
                current = current.getParent();
            }
            return current.getParent();
        }
    }

    public void delete(Key key)
    {
        TreeNode<Key, Value> targetNode = getNode(key);
        TreeNode<Key, Value> targetNodeParent = targetNode.getParent();
        if(targetNodeParent==null)
        {
            root=null;
            return;
        }
        boolean isLeftChild = targetNodeParent.getLeftChild().getKey().equals(key);

        //has both left and right child
        if(targetNode.getRightChild()!=null && targetNode.getLeftChild()!=null)
            replaceTargetWithRightSubtreeMin(targetNode, key);

        //has only left child
        else if(targetNode.getLeftChild()!=null)
        {
            if(isLeftChild)
                targetNodeParent.setLeftChild(targetNode.getLeftChild());
            else
                targetNodeParent.setRightChild(targetNode.getLeftChild());
        }

        //has only right child
        else if(targetNode.getRightChild()!=null)
        {
            if(isLeftChild)
                targetNodeParent.setLeftChild(targetNode.getRightChild());
            else
                targetNodeParent.setRightChild(targetNode.getRightChild());
        }

        //leaf
        else
        {
            if(isLeftChild)
                targetNodeParent.removeLeftChild();
            else
                targetNodeParent.removeRightChild();
        }
    }
    private void replaceTargetWithRightSubtreeMin(TreeNode<Key, Value> targetNode, Key key)
    {
        TreeNode<Key, Value> replacementNode = null;
        replacementNode = getMin(targetNode.getRightChild());
        TreeNode<Key, Value> parentReplacementNode = getParentOf(key, targetNode);
        targetNode.setKey(replacementNode.getKey());
        targetNode.setValue(replacementNode.getValue());
        if(replacementNode.getRightChild()!=null)
        {
            parentReplacementNode.setLeftChild(replacementNode.getRightChild());
        }
        else
            parentReplacementNode.removeLeftChild();
    }

    public Value getMin()
    {
        return getMin(root).getValue();
    }

    public Value getMax()
    {
        return getMax(root).getValue();
    }

    private TreeNode<Key, Value> getMax(TreeNode<Key, Value> startNode)
    {
        TreeNode<Key, Value> currentNode = startNode;
        while(currentNode.getRightChild()!=null)
        {
            currentNode = currentNode.getRightChild();
        }
        return currentNode;
    }

    private TreeNode<Key, Value> getMin(TreeNode<Key, Value> startNode)
    {
        TreeNode<Key, Value> currentNode = startNode;
        while(currentNode.getLeftChild()!=null)
        {
            currentNode = currentNode.getLeftChild();
        }
        return currentNode;
    }

    public void insert(Key key, Value val)
    {
        insert(root, key, val);
    }

    private void insert(TreeNode<Key, Value> start, Key key, Value val) {
        if(root == null) {
            root = new TreeNode<>(key, val, 0);
            return;
        }
        TreeNode<Key, Value> node = start;
        TreeNode<Key, Value> nodePrev = node;
       while(node!=null)
       {
           nodePrev = node;
           node.incrementNrChildren();

           if(node.getKey().compareTo(key) > 0)
               node = node.getLeftChild();
           else
               node = node.getRightChild();
       }
        TreeNode<Key, Value> newNode = new TreeNode<>(key, val, 0);
        newNode.setParent(nodePrev);

       if(nodePrev.getKey().compareTo(key) < 0)
       {
           nodePrev.setRightChild(newNode);
       }
       else
           nodePrev.setLeftChild(newNode);
    }

    private TreeNode<Key, Value> get(Key key, TreeNode<Key, Value> node)
    {
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

    private TreeNode<Key, Value> getRec(Key key, TreeNode<Key, Value> node)
    {
        if(node!=null){
            if(node.getKey().equals(key))
                return node;
            if(key.compareTo(node.getKey()) > 0)
                return get(key, node.getRightChild());
            else
                return get(key, node.getLeftChild());

        }
        else
            return null;
    }
    public TreeNode<Key, Value> getParentOf(Key key)
    {
        return getParentOf(key, root);
    }
    public TreeNode<Key, Value> getParentOf(Key key, TreeNode<Key, Value> node)
    {
        if(node!=null){
            if(node.getRightChild()!=null)
            {
                if(node.getRightChild().getKey().equals(key))
                    return node;
            }
            if(node.getLeftChild()!=null)
            {
                if(node.getLeftChild().getKey().equals(key))
                    return node;
            }
            if(node.getKey().compareTo(key) < 0)
                return getParentOf(key, node.getRightChild());
            else
                return getParentOf(key, node.getLeftChild());

        }
        else return null;
    }
}



