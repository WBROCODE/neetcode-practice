class TreeMap {
    TreeNode root;
    public TreeMap() {
        this.root = null;
    }

    public void insert(int key, int val) {
        root = insectHelper(key, val, root);
    }
    
    public TreeNode insectHelper(int key, int val, TreeNode root){
        if(root == null) return new TreeNode(key, val);

        if(root.key > key){
            root.left = insectHelper(key, val, root.left);
        }else if(root.key < key){
            root.right = insectHelper(key, val, root.right);
        }else{
            root.val = val;
        }

        return root;
    }

    public int get(int key) {
        if(root == null) return -1;
        
        TreeNode node = getHelper(key, root);

        return node == null ? -1 : node.val;
    }

    public TreeNode getHelper(int key, TreeNode root){
        if(root == null) return null;

        if(key > root.key){
            return getHelper(key, root.right);
        }else if(key < root.key){
            return getHelper(key, root.left);
        }else{
            return root;
        }
    }

    public int getMin() {
        if(root == null) return -1;
        return findMin(root).val;
    }

    public TreeNode findMin(TreeNode root){
        if(root == null) return null;

        while(root.left != null){
            root = root.left;
        }

        return root;
    }

    public int getMax() {
        if(root == null) return -1;
        return findMax(root).val;
    }

    public TreeNode findMax(TreeNode root){
        if(root == null) return null;

        while(root.right != null){
            root = root.right;
        }

        return root;
    }

    public void remove(int key) {
        root = removeHelper(root, key);
    }
    
    public TreeNode removeHelper(TreeNode root, int key){
        if(root == null) return null;

        if(key > root.key){
            root.right = removeHelper(root.right, key);
        }else if(key < root.key){
            root.left = removeHelper(root.left, key);
        }else{
            // 1: left & right == null
            if(root.left == null && root.right == null) return null;
            // 2: left == null
            if(root.left == null) return root.right;
            if(root.right == null) return root.left;

            TreeNode min = findMin(root.right);
            root.val = min.val;
            root.key = min.key;
            root.right = removeHelper(root.right, min.key);
        }

        return root;
    }

    public List<Integer> getInorderKeys() {
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        dfs(root, ans);
        return ans;
    }

    public void dfs(TreeNode root, List<Integer> ans){
        if(root == null) return;
        dfs(root.left, ans);
        ans.add(root.key);
        dfs(root.right, ans);
    }
}
class TreeNode{
    TreeNode left;
    TreeNode right; 
    int key;  
    int val;

    TreeNode(int key, int val){
        this.key = key;
        this.val = val;
        this.left = null;
        this.right = null;
    }

}
