package Trees;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversalRec {
    List<Integer> result = new ArrayList<Integer>();
    public List<Integer> inorderTraversal(TreeNode root)
    {
        inorder(root);
        return result;

    }

    private void inorder(TreeNode root)
    {
        if(root!=null)
        {
            inorderTraversal(root.left);
            result.add(root.val);
            inorderTraversal(root.right);
        }
    }
}
