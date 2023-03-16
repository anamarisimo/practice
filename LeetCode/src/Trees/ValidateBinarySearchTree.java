package Trees;

public class ValidateBinarySearchTree   {
    private boolean isValid = true;
    public boolean isValidBST(TreeNode root)
    {
        isValid(root, null, null);
        return isValid;
    }

    private void isValid(TreeNode root, Integer min, Integer max)
    {
        if((min !=null && root.val <= min) || (max!=null && root.val >=max))
            isValid = false;

        if(root.left!=null)
        {
            isValid(root.left, min, root.val);
        }

        if (root.right!=null)
            isValid(root.right, root.val, max);

    }
}
