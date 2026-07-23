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
    Map<Integer, Integer> inMap;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        inMap = new HashMap<>();

        for(int i = 0; i < inorder.length; i++){
            inMap.put(inorder[i], i);
        }
        return buildUp(preorder, 0, preorder.length-1, inorder, 0, inorder.length - 1);
    }

    public TreeNode buildUp(int[] preorder, int preS, int preE, int[] inorder, int inS, int inE){
        if(preS > preE) return null;
        int rootVal = preorder[preS];
        int inRoot = inMap.get(rootVal);
        int leftS = inRoot - inS;

        TreeNode root = new TreeNode(rootVal);
        TreeNode left = buildUp(preorder, preS + 1, preS + leftS, inorder, inS, inS + leftS);
        TreeNode right = buildUp(preorder, preS + leftS + 1, preE, inorder, inS + leftS + 1, inE);

        root.left = left;
        root.right = right;

        return root;

    }
}
