class TreeMap {
    TreeNode root;
    public TreeMap() {
        this.root = null;
    }

    public void insert(int key, int val) {
        this.root = helper(root, key, val);
    }

    public TreeNode helper(TreeNode root, int key, int val){
        if(root == null) return new TreeNode(key, val);

        if(key < root.key){
            root.left = helper(root.left, key, val);
        }else if(key > root.key){
            root.right = helper(root.right, key, val);
        }else{
            root.val = val;
        }

        return root;
    }

    public int get(int key) {
        TreeNode cur = this.root;
        return helperTwo(cur, key) == null ? -1 : helperTwo(cur, key).val;
    }

    public TreeNode helperTwo(TreeNode root, int key){
        if(root == null) return null;

        if(key < root.key){
            return helperTwo(root.left, key);
        }else if(key > root.key){
            return helperTwo(root.right, key);
        }

        return root;
    }

    public int getMin() {
        TreeNode cur = this.root;
        if(cur == null) return -1;

        while(cur.left != null){
            cur = cur.left;
        }
        return cur.val;
    }

    public int getMax() {
        TreeNode cur = this.root;
        if(cur == null) return -1;

        while(cur.right != null){
            cur = cur.right;
        }
        return cur.val;
    }

    public void remove(int key) {
        if(this.root == null) return;
        this.root = helperThree(this.root, key);
    }

    public TreeNode helperThree(TreeNode root, int key){
        if(root == null) return null;

        if(key < root.key){
            root.left = helperThree(root.left, key);
        }else if(key > root.key){
            root.right = helperThree(root.right, key);
        }else{
            if(root.left == null) return root.right;
            if(root.right == null) return root.left;

            TreeNode cur = root.right;
            while(cur.left != null){
                cur = cur.left;
            }
            root.val = cur.val;
            root.key = cur.key;
            root.right = helperThree(root.right, cur.key);
        }

        return root;
    }
    List<Integer> ans;
    public List<Integer> getInorderKeys() {
        ans = new ArrayList<>();
        dfs(this.root);
        return ans;
    }

    public void dfs(TreeNode root){
        if(root == null) return;
        dfs(root.left);
        ans.add(root.key);
        dfs(root.right);
    }
}

class TreeNode{
    TreeNode left;
    TreeNode right;
    int val;
    int key;

    public TreeNode(int key, int val){
        this.key = key;
        this.val = val;
    }


}
