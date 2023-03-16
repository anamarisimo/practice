package Trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversalIter
{
    public List<Integer> inorderTraversal(TreeNode root)
    {
        ArrayList<Integer> result = new ArrayList<Integer>();
        TreeNode currentNode = root;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        boolean currentExtracted = false;
        while(true)
        {
            if(currentNode == null)
            {
                if(stack.size() > 0)
                {
                    currentNode = stack.pop();
                    currentExtracted = true;
                }
                else
                    break;
            }
            if(!currentExtracted)
            {
                stack.add(currentNode);
                currentNode = currentNode.left;
                currentExtracted = false;
            }

            else
            {
                result.add(currentNode.val);
                currentNode = currentNode.right;
                currentExtracted = false;

            }
        }
        return result;
    }
}
