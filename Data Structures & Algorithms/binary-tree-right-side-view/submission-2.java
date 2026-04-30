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
    public List<Integer> rightSideView(TreeNode root) {
        
        List<Integer> result = new ArrayList<>();
        if(root == null) {
         return result;   
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            int size = q.size();
            TreeNode temp = q.peek();
            result.add(temp.val);
            while (size > 0){
                TreeNode p = q.poll();
                if(p.right != null) {q.add(p.right);}
                if(p.left != null) {
                    q.add(p.left);
                }
                size--;
            }
        }
        return result;
    }
}
