class Solution {
    List<String> ans;
    StringBuilder sb;
    public List<String> generateParenthesis(int n) {
        ans = new ArrayList<>();
        sb = new StringBuilder();
        /**
        
        
        l  r 
        (  )
        
        */
        dfs(0, 0, n);
        return ans;
    }

    public void dfs(int l, int r, int n){
        if(r == n && l == n){
            ans.add(sb.toString());
            return;
        }
        if(l > n || r > l) return;

        sb.append('(');
        dfs(l + 1, r, n);
        sb.deleteCharAt(sb.length() - 1);

        sb.append(')');
        dfs(l, r + 1, n);
        sb.deleteCharAt(sb.length() - 1);

    }
}
