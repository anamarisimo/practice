package Trees;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
          this.right = right;
      }
 }

public class MinDepth {
    private int minHeight = 10000000;
    public int minDepth(TreeNode root)
    {
        if(root==null)
            return 0;
        else
        {
            search(root, 1);
            return minHeight;
        }

    }

    private void search(TreeNode currentNode, int currentHeight)
    {
        if(currentHeight >= minHeight)
            return;

        if(isLeaf(currentNode))
        {
            minHeight = currentHeight;
            return;
        }
        if(currentNode.left!=null)
            search(currentNode.left, currentHeight+1);

        if(currentNode.right!=null)
            search(currentNode.right, currentHeight+1);
    }

    private boolean isLeaf(TreeNode currentNode)
    {
        if(currentNode.left==null && currentNode.right==null)
            return true;
        else
            return false;
    }
}
