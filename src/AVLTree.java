public class AVLTree<Key extends Comparable<Key>, Value> extends BinarySearchTree<Key, Value>
{

    public void insert(Key key, Value val)
    {
        insert(root, key, val);
    }
    private void insert(TreeNode<Key, Value> start, Key key, Value val)
    {
        if(root == null) {
            root = new TreeNode<>(key, val, 0);
            root.setHeight(0);
            return;
        }
        TreeNode<Key, Value> node = start;
        TreeNode<Key, Value> nodePrev = node;
        while(node!=null)
        {
            nodePrev = node;
            node.incrementNrChildren();
            node.incrementHeight();

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
        rebalanceTree(newNode);
    }

    private void rebalanceTree(TreeNode<Key, Value> node)
    {
        TreeNode<Key, Value> current = node;
        while(current!=null && current.isBalanced())
        {
            current = current.getParent();
        }
        if(current!=null)
        {
            if(current.isRightHeavy())
            {
                rotateWhenNodeRightHeavy(current);
            }
            else
                rotateWhenNodeLeftHeavy(current);
            rebalanceTree(current.getParent());
        }
    }

    private void rotateWhenNodeLeftHeavy(TreeNode<Key,Value> node)
    {
        if(node.getLeftChild().isLeftHeavy() || node.getLeftChild().isPerfectlyBalanced())
        {
            rotateRight(node);
        }
        else
            rotateLeftRight(node);
    }

    private void rotateWhenNodeRightHeavy(TreeNode<Key,Value> node)
    {
        if(node.getRightChild().isRightHeavy() || node.getRightChild().isPerfectlyBalanced())
        {
            rotateLeft(node);
        }
        else
            rotateRightLeft(node);

    }

    private void rotateLeft(TreeNode<Key,Value> node)
    {
        TreeNode<Key,Value> nodeInitParent = node.getParent();
        TreeNode<Key,Value> replacementNode = node.getRightChild();
        TreeNode<Key,Value> newRightChild = replacementNode.getLeftChild();
        replacementNode.setLeftChild(node);
        replacementNode.setParent(nodeInitParent);
        if(nodeInitParent == null)
            root = replacementNode;
        else
        {
            if(replacementNode.getKey().compareTo(nodeInitParent.getKey()) < 0)
            {
                nodeInitParent.setLeftChild(replacementNode);
            }
            else
                nodeInitParent.setRightChild(replacementNode);
        }

        node.setRightChild(newRightChild);
        node.setParent(replacementNode);

        int nodeNewRightChildHeight = node.getRightChild() == null ? -1 : node.getRightChild().getHeight();
        int nodeNewLeftChildHeight =  node.getLeftChild() == null ? -1 : node.getLeftChild().getHeight();
        node.setHeight(Math.max(nodeNewRightChildHeight, nodeNewLeftChildHeight) +1);

        int replacementRightChild = node.getRightChild() == null ? -1 : node.getRightChild().getHeight();
        int replacementLeftChild = node.getLeftChild() == null? -1 : node.getLeftChild().getHeight();
        replacementNode.setHeight(Math.max(replacementRightChild, replacementLeftChild) +1);
    }

    private void rotateRight(TreeNode<Key,Value> node)
    {
        TreeNode<Key,Value> nodeInitParent = node.getParent();
        TreeNode<Key,Value> replacementNode = node.getLeftChild();
        TreeNode<Key,Value> newLeftChild = replacementNode.getRightChild();
        replacementNode.setRightChild(node);
        replacementNode.setParent(nodeInitParent);
        if(nodeInitParent == null)
            root = replacementNode;
        else
        {
            if(replacementNode.getKey().compareTo(nodeInitParent.getKey()) < 0)
            {
                nodeInitParent.setLeftChild(replacementNode);
            }
            else
                nodeInitParent.setRightChild(replacementNode);
        }

        node.setParent(replacementNode);
        node.setLeftChild(newLeftChild);

        int nodeNewRightChildHeight = node.getRightChild() == null ? -1 : node.getRightChild().getHeight();
        int nodeNewLeftChildHeight =  node.getLeftChild() == null ? -1 : node.getLeftChild().getHeight();
        node.setHeight(Math.max(nodeNewRightChildHeight, nodeNewLeftChildHeight) +1);

        int replacementRightChild = node.getRightChild() == null ? -1 : node.getRightChild().getHeight();
        int replacementLeftChild = node.getLeftChild() == null? -1 : node.getLeftChild().getHeight();
        replacementNode.setHeight(Math.max(replacementRightChild, replacementLeftChild) +1);;
    }

    private void rotateRightLeft(TreeNode<Key,Value> node)
    {
        rotateRight(node.getRightChild());
        rotateLeft(node);
    }

    private void rotateLeftRight(TreeNode<Key,Value> node)
    {
        rotateLeft(node.getLeftChild());
        rotateRight(node);
    }
}
