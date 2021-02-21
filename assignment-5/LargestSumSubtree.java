import java.util.*;  
class LargestSumSubtree
{  
  
static class INT 
{ 
    int v; 
    INT(int a) 
    { 
        v = a; 
    } 
} 
  
// Function to create new tree node.  
static TreeNode newNode(int key)  
{  
    TreeNode temp = new Node();  
    temp.key = key;  
    temp.left = temp.right = null;  
    return temp;  
}  
  
static int findLargestSubtreeSumUtil(TreeNode root,  
                                     INT ans)  
{  
   
    if (root == null)      
        return 0;  
      
    int currSum = root.key +  
    findLargestSubtreeSumUtil(root.left, ans) +  
    findLargestSubtreeSumUtil(root.right, ans);  
   
    ans.v = Math.max(ans.v, currSum);  
  
   
    return currSum;  
}  
   
static int findLargestSubtreeSum(Node root)  
{  
    
    if (root == null)      
        return 0;   
    INT ans = new INT(-9999999);  
 
    findLargestSubtreeSumUtil(root, ans);  
  
    return ans.v;  
}  
  
// Driver Code  
public static void main(String args[]) 
{  
   
  
    TreeNode root = newNode(1);  
    root.left = newNode(-2);  
    root.right = newNode(3);  
    root.left.left = newNode(4);  
    root.left.right = newNode(5);  
    root.right.left = newNode(-6);  
    root.right.right = newNode(2);  
  
    System.out.println(findLargestSubtreeSum(root));  
}  
} 
