class Solution {
    List<List<String>> ans = new ArrayList<>();
    List<String> path = new ArrayList<>();
    public List<List<String>> partition(String s) {
        dfs(s, 0);
        return ans;
    }
    /**
    
    
    a a b 
    
    */
    public void dfs(String s, int start){
        if(start == s.length()){
            ans.add(new ArrayList<>(path));
            return;
        }

        for(int i = start; i < s.length(); i++){
            String sub = s.substring(start, i + 1);
            if(isPalindrome(sub)){
                path.add(sub);
                dfs(s, i + 1);
                path.remove(path.size() - 1);
            }
        }


    }

    public boolean isPalindrome(String s){
        if(s == null) return false;
        int l = 0, r = s.length() - 1;

        while(l < r){
            if(s.charAt(l)  != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}
