class Solution {
    List<String> ans = new ArrayList<>();
    StringBuilder sb = new StringBuilder();

    public List<String> generateParenthesis(int n) {
        bT(0, 0, n);

        return ans;
    }

    public void bT(int l, int r, int n){
        if(l == r && l == n){
            ans.add(sb.toString());
            return;
        }
        if(r > l || l > n) return;

        sb.append("(");
        bT(l + 1, r, n);
        sb.deleteCharAt(sb.length() - 1);

        sb.append(")");
        bT(l, r + 1, n);
        sb.deleteCharAt(sb.length() - 1);

    }

}
