package Trees;

public class LowestCommonAncestorBST
{
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q)
    {
        TreeNode current = root;
        while(current!=null)
        {
            if(current.val == p.val || current.val == q.val)
                return current;
            if((current.val > p.val && current.val < q.val) || (current.val < p.val && current.val > q.val))
            {
                return current;
            }
            else if(current.val < p.val && current.val < q.val)
                current = current.right;
            else
                current = current.left;
        }
        return null;
    }
}
