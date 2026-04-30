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
    int result;
    public int goodNodes(TreeNode root) {
        result = 0;
        dfs(root,Integer.MIN_VALUE);
        return result;
    }

    private void dfs(TreeNode node, int max) {
         if (node == null) {
              return;
          }
          if (node.val >= max) {
              max = node.val;
              result++;
          }
          dfs(node.left,max);
          dfs(node.right,max);
    }
}
