import Trees.TreeNode;
import Trees.TreeTraversals;

public class sortedArrayToBST {

    public  static TreeNode getBST(int[] arr)
    {
        return arrayToBST(arr, 0, arr.length-1);
    }

    private  static TreeNode arrayToBST(int[] arr, int start, int end){
        if(start > end)
            return null;

        int mid = (end + start + 1) / 2;

        TreeNode node = new TreeNode(arr[mid]);

        if(start != end){
            node.left = arrayToBST(arr, start, mid - 1);
            node.right = arrayToBST(arr, mid + 1, end);
        }
        return node;
    }

    public static void main(String[] args) {
        int[] arr= {1, 2, 3, 4};

        TreeNode bst =getBST(arr);

        TreeTraversals.levelOrder(bst);
    }
}
