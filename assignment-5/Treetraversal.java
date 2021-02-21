package Trees;

import java.util.Stack;
public class TreeTraversals {

    public static void inOrder(TreeNode root)
    {
        Stack<TreeNode> stack = new Stack<>();

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode node = stack.pop();
            System.out.print(node.data + "->");
            root = node.right;
        }
    }

    public static void preOrder(TreeNode root){
        Stack<TreeNode> stack =new Stack<>();
        if(root == null)
            return;
        stack.push(root);
        while (!stack.isEmpty())
        {
            TreeNode node = stack.pop();
            System.out.print(node.data + "->");
            if(node.right!=null)
                stack.push(node.right);
            if(node.left != null)
                stack.push(node.left);
        }

    }


    public static void postOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        while(true) {
            while(root != null) {
                stack.push(root);
                stack.push(root);
                root = root.left;
            }
            if(stack.empty())
                return;
            root = stack.pop();

            if(!stack.empty() && stack.peek() == root)
                root = root.right;
            else {
                System.out.print(root.data + "->");
                root = null;
            }
        }
    }

    private static int getHeight(TreeNode root) {

        if (root == null) {
            return 0;
        }
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void levelOrder(TreeNode root) {

        int height = getHeight(root);

        for (int i = 1; i <= height; i++) {
            printLevel(root, 1, i);
            System.out.println();
        }
    }

    private static void printLevel(TreeNode root, int currentLevel, int targetLevel) {

        if(root == null) {
            return;
        }
        if(currentLevel == targetLevel) {
            System.out.print(root.data + " ");
            return;
        }
        printLevel(root.left, currentLevel + 1, targetLevel);
        printLevel(root.right, currentLevel + 1, targetLevel);
    }

    public static void main(String[] args) {

        TreeNode root =new TreeNode(10);

        root.left =new TreeNode(20);
        root.right =new TreeNode(30);

        root.left.left =new TreeNode(40);
        root.left.right =new TreeNode(50);
        root.right.left =new TreeNode(60);
        root.right.right =new TreeNode(70);

        System.out.print("Inorder traversal : ");
        inOrder(root);

        System.out.print("\nPreorder traversal : ");
        preOrder(root);

        System.out.print("\nPostorder traversal : ");
        postOrder(root);

        System.out.println("\nLevelorder traversal : ");
        levelOrder(root);
    }
}
