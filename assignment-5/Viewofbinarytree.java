package Trees;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;
public class ViewsOfBinaryTree {

    static int traversed  = 0;
    static int maxLevelSoFar = -1;

    static class Pair {

        TreeNode node;
        int identifier;

        public Pair(TreeNode node, int identifier) {
            this.node = node;
            this.identifier = identifier;
        }
    }
    public static void printRightView(TreeNode root, int currentLevel) {

        if(root == null) {
            return;
        }
        if(currentLevel > traversed) {
            System.out.println(root.data);
            traversed = currentLevel;
        }
        printRightView(root.right, currentLevel + 1);
        printRightView(root.left, currentLevel + 1);
    }

    public static void printLeftView(TreeNode currentNode, int currentLevel)
    {
        if (currentNode == null) return;

        if (currentLevel > maxLevelSoFar)
        {
            System.out.println(currentNode.data);
            maxLevelSoFar = currentLevel;
        }
        printLeftView(currentNode.left, currentLevel + 1);
        printLeftView(currentNode.right, currentLevel + 1);
    }

    public static void printBottomView(TreeNode root) {

        if (root == null) {
            return;
        }
        Queue<Pair> queue = new LinkedList<>();

        Pair p = new Pair(root, 0);
        queue.add(p);
        Map<Integer, TreeNode> map = new TreeMap<>();

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();

            TreeNode node = pair.node;
            int value = pair.identifier;

            map.put(value, node);

            if (node.left != null) {
                Pair leftPair = new Pair(node.left, value - 1);
                queue.add(leftPair);
            }

            if (node.right != null) {
                Pair rightPair = new Pair(node.right, value + 1);
                queue.add(rightPair);
            }
        }
        for (Map.Entry<Integer, TreeNode> entry : map.entrySet()) {
            System.out.print(entry.getValue().data + "  ");
        }
    }

    public static void main(String[] args) {
        TreeNode root =new TreeNode(10);

        root.left =new TreeNode(20);
        root.right =new TreeNode(30);

        root.left.left =new TreeNode(40);
        root.left.right =new TreeNode(50);

        printLeftView(root,1);

        printRightView(root,1);

        printBottomView(root);

    }
}
