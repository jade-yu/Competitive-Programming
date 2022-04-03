/*
    Link: https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers/

    > Recursive solution (with no lookup)
    > Get all possible subsets from left and right nodes and add node value
    > Convert binary string to integer and return sum

    Possible optimization would be adding a lookup for the binary value equivalents
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int val=0, TreeNode left=null, TreeNode right=null) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class Solution {
    public int SumRootToLeaf(TreeNode root) {
        var numbers = new List<string>();
        numbers.AddRange(Traverse(root));
        var sum = 0;
        foreach(var stringNum in numbers) {
            sum += Convert.ToInt32(stringNum, 2);
        }
        return sum;
    }
    
    public List<string> Traverse(TreeNode node) {
        if(node.left == null && node.right == null)
            return new List<string> { node.val.ToString() };
        var numbers = new List<string>(2);
        if(node.left != null) {
            var leftNodes = Traverse(node.left);
            foreach(var leftNode in leftNodes) {
                numbers.Add(node.val + leftNode);
            }
        }
        if(node.right != null) {
            var rightNodes = Traverse(node.right);
            foreach(var rightNode in rightNodes) {
                numbers.Add(node.val + rightNode);
            }
        }
        return numbers;
    }
}
