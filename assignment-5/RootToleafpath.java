package Trees;


public class RootToLeafPath {

    static void printPaths(TreeNode node)
    {
        int[] path = new int[1000];
        printRecursive(node, path, 0);
    }
    static void printRecursive(TreeNode node, int[] path, int length)
    {
        if (node == null)
            return;

        path[length] = node.data;
        length++;

        if (node.left == null && node.right == null)
            printArray(path, length);
        else
        {
            printRecursive(node.left, path, length);
            printRecursive(node.right, path, length);
        }
    }
    
    static void printArray(int[] arr, int len)
    {
        int i;
        for (i = 0; i < len; i++)
        {
            System.out.print(arr[i] + " ");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        TreeNode root =new TreeNode(10);

        root.left =new TreeNode(20);
        root.right =new TreeNode(30);

        root.left.left =new TreeNode(40);
        root.left.right =new TreeNode(50);
        root.right.left =new TreeNode(60);
        root.right.right =new TreeNode(70);

        printPaths(root);
    }

}
