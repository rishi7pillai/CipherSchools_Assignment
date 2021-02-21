public class LAC
{
    TreeNode root;

    TreeNode findLCA(int n1, int n2)
    {
        return findLCA(root, n1, n2);
    }

  
    TreeNode findLCA(TreeNode node, int n1, int n2)
    {
        // Base case
        if (node == null)
            return null;
        
        if (node.data == n1 || node.data == n2)
            return node;
        
        TreeNode left_lca = findLCA(node.left, n1, n2);
        TreeNode right_lca = findLCA(node.right, n1, n2);
        
        if (left_lca!=null && right_lca!=null)
            return node;

       
        return (left_lca != null) ? left_lca : right_lca;
    }

    /* Driver program to test above functions */
    public static void main(String args[])
    {
        LAC tree = new LAC();
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(5);

        System.out.println("LCA(3, 4) = " +
                tree.findLCA(3, 4).data);
        System.out.println("LCA(2, 4) = " +
                tree.findLCA(2, 4).data);
    }
}
