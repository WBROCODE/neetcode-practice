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
    public boolean isSameTree(TreeNode p, TreeNode k) {
        if(p == null && k == null ) return true;
        if(p == null || k == null ) return false;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(p);
        q.offer(k);
        
        while(!q.isEmpty()){
            int size = q.size();
            TreeNode cur = q.poll();
            TreeNode curTwo = q.poll();
            
            if(cur == null && curTwo == null) continue;
            if(cur == null || curTwo == null) return false;
            if(cur.val != curTwo.val) return false; 

            q.offer(cur.left);
            q.offer(curTwo.left);
            q.offer(cur.right);
            q.offer(curTwo.right); 
        }
        return true;
    }
}
