package Trees;

public class SortedArraytoBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums)
    {
        return buildTree(0, nums.length-1, nums);
    }

    private TreeNode buildTree(int left, int right, int[] nums)
    {
        if(left>right)
            return null;
        int mid = (left + right)/2;
        TreeNode result = new TreeNode(nums[mid]);
        result.left = buildTree(left, mid-1, nums);
        result.right = buildTree(mid+1, right, nums);
        return result;

    }
}
