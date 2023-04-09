import com.sun.jdi.Value;

import java.io.PrintStream;

class Trunk
{
    Trunk prev;
    String str;

    Trunk(Trunk prev, String str)
    {
        this.prev = prev;
        this.str = str;
    }
};

public class BSTPrinter<Key extends Comparable<Key>, Value>  {

    private static void showTrunks(Trunk p)
    {
        if (p == null) {
            return;
        }

        showTrunks(p.prev);
        System.out.print(p.str);
    }

    public static void printTree(TreeNode root, Trunk prev, boolean isLeft)
    {
        if (root == null) {
            return;
        }

        String prev_str = "    ";
        Trunk trunk = new Trunk(prev, prev_str);

        printTree(root.getRightChild(), trunk, true);

        if (prev == null) {
            trunk.str = "———";
        }
        else if (isLeft) {
            trunk.str = "———";
            prev_str = "   |";
        }
        else {
            trunk.str = "———";
            prev.str = prev_str;
        }

        showTrunks(trunk);
        System.out.println(" " + root.getValue());

        if (prev != null) {
            prev.str = prev_str;
        }
        trunk.str = "   |";

        printTree(root.getLeftChild(), trunk, false);
    }
    public static void print(TreeNode root)
    {
        printTree( root, null, false);
    }

}
