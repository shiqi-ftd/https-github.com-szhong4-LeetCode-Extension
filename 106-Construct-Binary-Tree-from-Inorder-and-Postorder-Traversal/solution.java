/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, 0, inorder.length - 1, postorder, postorder.length-1);
    }
    
    private TreeNode buildTree(int[] inorder, int inStart, int inEnd, int[] postorder,
            int postend) {
        if (postend < 0 || inStart > inEnd)
            return null;
    
        //The last element in postorder is the root.
        TreeNode root = new TreeNode(postorder[postend]);
    
        //find the index of the root from inorder. Iterating from the end.
        int rIndex = inStart;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == postorder[postend]) {
                rIndex = i;
                break;
            }
        }
        //build right and left subtrees. Again, scanning from the end to find the sections.
        root.right = buildTree(inorder, rIndex + 1, inEnd, postorder, postend - 1);
        root.left = buildTree(inorder, inStart, rIndex - 1, postorder, rIndex - 1);
        return root;
    }
}