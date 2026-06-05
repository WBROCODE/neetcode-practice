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
    Map<Integer, Integer> map;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        /**
                   r   
        preorder = 1,2,3,4
                  0 1 2 3
        inorder = 2,1,3,4
                  l R r
        */
        map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }

        return buildUpNode(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public TreeNode buildUpNode(int[] preorder, int preS, int preE, int[] inorder, int inS, int inE){
        if(preS > preE) return null;
        int rootVal = preorder[preS];
        TreeNode root = new TreeNode(rootVal);
        int rootIndexInInorder = map.get(rootVal);
        int leftS = rootIndexInInorder - inS;

        TreeNode left = buildUpNode(preorder, preS + 1, preS + leftS, 
        inorder, inS, rootIndexInInorder - 1);

        TreeNode right = buildUpNode(preorder, preS + leftS + 1, preE, 
        inorder, rootIndexInInorder + 1, inE);

        root.left = left;
        root.right = right;

        return root;
    }
}
