public class TreeNode<Key extends Comparable<Key>, Value> {
    private Key _key;
    private Value _value;
    private TreeNode<Key, Value> leftChild;
    private TreeNode<Key, Value> rightChild;
    private TreeNode<Key, Value> parent;
    private String colour;
    private int numberOfChildren;

    public TreeNode(Key key, Value value, int nrChildren) {
        _key = key;
        _value = value;
        numberOfChildren = nrChildren;
        colour = "black";
    }

    public TreeNode<Key, Value> getLeftChild() {
        return leftChild;
    }

    public boolean isLeftChild() {
        return parent!=null && parent.getLeftChild() == this;
    }

    public boolean isRightChild() {
        return parent!=null && parent.getRightChild() == this;
    }

    public String getColour() {
        return colour;
    }
    public void setColour(String newColour) {
        colour = newColour;
    }

    public TreeNode<Key, Value> getParent() {
        return parent;
    }

    public void setLeftChild(TreeNode<Key, Value> lChild) {
        leftChild = lChild;
        lChild.parent = this;
    }

    public TreeNode<Key, Value> getRightChild() {
        return rightChild;
    }

    public int getNrChildren() {
        return numberOfChildren;
    }

    public void incrementNrChildren() {
        numberOfChildren++;
    }

    public void setRightChild(TreeNode<Key, Value> rChild) {
        rightChild = rChild;
        if(rChild!=null)
            rChild.parent = this;
    }

    public void setKey(Key key) {
        _key=key;
    }
    public Key getKey() {
        return _key;
    }
    public void setValue(Value value) {
        _value=value;
    }
    public Value getValue() {
        return _value;
    }
}
