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
    public boolean isValidBST(TreeNode root) {
        // bfs
        if(root == null) return true;

        Queue<State> q = new LinkedList<>();
        q.offer(new State(root, Long.MIN_VALUE, Long.MAX_VALUE));


        while(!q.isEmpty()){
            State cur = q.poll();
            TreeNode curN = cur.node;
            long min = cur.min;
            long max = cur.max;

            if(curN.val <= min || curN.val >= max) return false;

            if(curN.left != null){
                q.offer(new State(curN.left, min, (long)curN.val));
            }

            if(curN.right != null){
                q.offer(new State(curN.right, (long)curN.val, max));
            }
        }

        return true;
    }
}

class State{

    TreeNode node;
    long min;
    long max;

    public State(TreeNode node, long min, long max){
        this.node = node;
        this.min = min;
        this.max = max;
    }

}
