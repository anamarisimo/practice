public class TreeNode<Key extends Comparable<Key>, Value> {
    private Key _key;
    private Value _value;
    private TreeNode<Key, Value> leftChild;
    private TreeNode<Key, Value> rightChild;
    private TreeNode<Key, Value> parent;
    private String colour;
    private int numberOfChildren;
    private int height;

    public TreeNode(Key key, Value value, int nrChildren) {
        _key = key;
        _value = value;
        numberOfChildren = nrChildren;
        colour = "black";
    }

    public TreeNode<Key, Value> getLeftChild() {
        return leftChild;
    }

    public boolean hasLeftSubtree()
    {
        return leftChild != null;
    }

    public boolean hasRightSubtree()
    {
        return rightChild != null;
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
    public void setParent(TreeNode<Key, Value> parent) {

        this.parent = parent;
    }


    public void removeLeftChild()
    {
        leftChild=null;
    }
    public void removeRightChild()
    {
        rightChild=null;
    }


    public TreeNode<Key, Value> getRightChild() {
        return rightChild;
    }

    public int getNrChildren() {
        return numberOfChildren;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
    public void incrementHeight() {
        this.height = this.height+1;
    }
    public void decrementHeight() {
        this.height = this.height-1;
    }

    public void incrementNrChildren() {
        numberOfChildren++;
    }

    public void setRightChild(TreeNode<Key, Value> rChild) {
        rightChild = rChild;
        if(rChild!=null)
            rChild.parent = this;
    }

    public void setLeftChild(TreeNode<Key, Value> lChild) {
        leftChild = lChild;
        if(lChild!=null)
            lChild.parent = this;
    }

    public int getBalance()
    {
        int rightSubtreeHeight = hasRightSubtree() ? getRightChild().height : -1;
        int leftSubtreeHeight = hasLeftSubtree() ? getLeftChild().height : -1;
        return leftSubtreeHeight - rightSubtreeHeight;
    }

    public boolean isBalanced()
    {
        int balance = getBalance();
        return Math.abs(balance) < 2;
    }

    public boolean isLeftHeavy()
    {
        int balance = getBalance();
        return balance > 0;
    }
    public boolean isRightHeavy()
    {
        int balance = getBalance();
        return balance < 0;
    }

    public boolean isPerfectlyBalanced()
    {
        int balance = getBalance();
        return balance == 0;
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
