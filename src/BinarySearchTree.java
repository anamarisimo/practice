import java.io.PrintStream;

public class BinarySearchTree<Key extends Comparable<Key>, Value> {
    private TreeNode<Key, Value> root;

    public TreeNode<Key, Value> getRoot()
    {
        return root;
    }
    private String traversePreOrder(TreeNode<Key, Value> node) {

        if (root == null) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        sb.append(root.getValue());

        String pointerRight = "└──";
        String pointerLeft = (node.getRightChild() != null) ? "├──" : "└──";

        traverseNodes(sb, "", pointerLeft, node.getLeftChild(), node.getRightChild() != null);
        traverseNodes(sb, "", pointerRight, node.getRightChild(), false);

        return sb.toString();
    }
    private void traverseNodes(StringBuilder sb, String padding, String pointer, TreeNode<Key, Value> node,
                              boolean hasRightSibling) {
        if (node != null) {
            sb.append("\n");
            sb.append(padding);
            sb.append(pointer);
            sb.append(node.getValue());

            StringBuilder paddingBuilder = new StringBuilder(padding);
            if (hasRightSibling) {
                paddingBuilder.append("│  ");
            } else {
                paddingBuilder.append("   ");
            }

            String paddingForBoth = paddingBuilder.toString();
            String pointerRight = "└──";
            String pointerLeft = (node.getRightChild() != null) ? "├──" : "└──";

            traverseNodes(sb, paddingForBoth, pointerLeft, node.getLeftChild(), node.getRightChild() != null);
            traverseNodes(sb, paddingForBoth, pointerRight, node.getRightChild(), false);
        }
    }
    public void print() {
        PrintStream os = new PrintStream(System.out);
        os.print(traversePreOrder(root));
    }
    public Value get(Key key)
    {
        TreeNode<Key, Value> searched = get(key, root);
        return searched == null ? root.getValue() : searched.getValue();
    }

    public void printTree(TreeNode<Key, Value> node, String prefix)
    {
        if(node == null) return;

        System.out.println(prefix + " + " + node.getValue());
        printTree(node.getLeftChild() , prefix + " ");
        printTree(node.getRightChild() , prefix + " ");
    }

    public TreeNode<Key, Value> getNode(Key key)
    {
        TreeNode<Key, Value> searched = get(key, root);
        return searched == null ? root : searched;
    }

    public TreeNode<Key, Value> getSuccessor(TreeNode<Key, Value> node)
    {
        if(hasRightSubtree(node))
        {
            return getMin(node.getRightChild());
        }
        else
        {
            TreeNode<Key, Value> current = node;
            while(isRightChild(current))
            {
                current = current.getParent();
            }
            return current.getParent();
        }
    }

    public TreeNode<Key, Value> getPredecessor(TreeNode<Key, Value> node)
    {
        if(hasLeftSubtree(node))
        {
            return getMax(node.getLeftChild());
        }
        else
        {
            TreeNode<Key, Value> current = node;
            while(isLeftChild(current))
            {
                current = current.getParent();
            }
            return current.getParent();
        }
    }

    private boolean isRightChild(TreeNode<Key, Value> node)
    {
        return node.getParent()!=null && node.getParent().getRightChild() == node;
    }

    private boolean isLeftChild(TreeNode<Key, Value> node)
    {
        return node.getParent()!=null && node.getParent().getLeftChild() == node;
    }

    private boolean isRoot(TreeNode<Key, Value> node)
    {
        return node.getParent()==null;
    }

    private boolean hasRightSubtree(TreeNode<Key, Value> node)
    {
        return node.getRightChild()!=null;
    }

    private boolean hasLeftSubtree(TreeNode<Key, Value> node)
    {
        return node.getLeftChild()!=null;
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
            parentReplacementNode.setLeftChild(null);
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
                targetNodeParent.setLeftChild(null);
            else
                targetNodeParent.setRightChild(null);
        }
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

       if(nodePrev.getKey().compareTo(key) < 0)
       {
           nodePrev.setRightChild(new TreeNode<>(key, val, 0));
       }
       else
           nodePrev.setLeftChild(new TreeNode<>(key, val, 0));
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



