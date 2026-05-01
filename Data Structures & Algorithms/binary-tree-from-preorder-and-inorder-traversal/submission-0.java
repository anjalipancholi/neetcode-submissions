/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    int index = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> map = new HashMap<>();
        return helper(map, preorder, inorder,0, preorder.length-1);
    }

    private TreeNode helper(Map<Integer,Integer> map, int[] preorder, int[] inorder, int left, int right) {
        if (left > right) {
            return null;
        }

        for (int i = 0; i < inorder.length; i ++) {
            map.put(inorder[i],i);
        }

        int rootVal = preorder[index++];
        TreeNode root = new TreeNode(rootVal);
        int mid = map.get(root.val);

        root.left = helper(map, preorder, inorder, left, mid-1);
        root.right = helper(map, preorder, inorder, mid+1, right);

        return root;
    }
}
