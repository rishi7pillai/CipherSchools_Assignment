package Trees;

public class ConstructTreeUsingPrePost {
    public static TreeNode constructTree(int [] inorder, int [] preorder, int preorderIndex, int inStart, int inEnd) {

        if(inStart > inEnd) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preorderIndex]);

        int inorderIndex = -1;
        for(int i = inStart; i <= inEnd; i++) {
            if(inorder[i] == preorder[preorderIndex]) {
                inorderIndex = i;
                break;
            }
        }
        int leftSubTreeSize = inorderIndex - inStart;

        root.left = constructTree(inorder, preorder, preorderIndex + 1, inStart, inorderIndex - 1);
        root.right = constructTree(inorder, preorder, preorderIndex + leftSubTreeSize + 1,inorderIndex + 1, inEnd);

        return root;
    }

    public static void main(String[] args) {

        int [] inorder = {40, 20, 50, 10, 60, 30, 70};
        int[] preOrder = {10, 20, 40, 50, 30, 60, 70};

        TreeNode root =  constructTree(inorder, preOrder, 0, 0, inorder.length - 1);

        TreeTraversals.levelOrder(root);
    }
}
