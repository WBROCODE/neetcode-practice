class TreeMap {
    TreeNode root;
    public TreeMap() {
        root = null;
    }

    public void insert(int key, int val) {
        if(root == null){
            root = new TreeNode(key, val);
            return;
        }

        TreeNode cur = this.root;

        while(true){
            if(key < cur.key){
                if(cur.left == null){
                    cur.left = new TreeNode(key, val);
                    return;
                }
                cur = cur.left;
            }else if(key > cur.key){
                if(cur.right == null){
                    cur.right = new TreeNode(key, val);
                    return;
                }
                cur = cur.right;
            }else{
                cur.val = val;
                return;
            }
        }
    }

    public int get(int key) {
        if(root == null) return -1;
        TreeNode cur = root;
        while(cur != null){
            if(key < cur.key){
                cur = cur.left;
            }else if(key > cur.key){
                cur = cur.right;
            }else{
                return cur.val;
            }
        }

        return -1;
    }

    public int getMin() {
        if(root == null ) return -1;
        return getMinNode(root).val;
    }

    public TreeNode getMinNode(TreeNode root) {
        if(root == null ) return null;
        TreeNode cur = root;
        while(cur.left != null){
            cur = cur.left;
        }
        return cur;
    }


    public int getMax() {
        if(root == null ) return -1;
        TreeNode cur = root;
        while(cur.right != null){
            cur = cur.right;
        }
        return cur.val;
    }

    public void remove(int key) {
        root = removeNode(root, key);
    }

    public TreeNode removeNode(TreeNode root, int key){
        if(root == null) return null;

        if(key > root.key){
            root.right = removeNode(root.right, key);
        }else if(key < root.key){
            root.left = removeNode(root.left, key);
        }else{
            if(root.left == null){
                return root.right;
            }else if(root.right == null){
                return root.left;
            }else{
                TreeNode min = getMinNode(root.right);
                root.val = min.val;
                root.key = min.key;
                root.right = removeNode(root.right, min.key);
            }

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
