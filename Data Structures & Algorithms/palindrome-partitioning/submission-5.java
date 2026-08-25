class Solution {
    List<List<String>> ans = new ArrayList<>();
    List<String> path = new ArrayList<>();
    public List<List<String>> partition(String s) {
        bT(s, 0);
        return ans;
    }

    public void bT(String s, int start){
        if(start == s.length()){
            ans.add(new ArrayList<>(path));
            return;
        }
        if(start > s.length()) return;

        for(int i = start; i < s.length(); i++){
            String sub = s.substring(start, i + 1);
            if(check(sub)){
                path.add(sub);
                bT(s, i + 1);
                path.remove(path.size() - 1);
            }
        }
    }

    public boolean check(String str){
        int l = 0, r = str.length() - 1;

        while(l <= r){
            if(str.charAt(l) != str.charAt(r)) return false;
            l++;
            r--;
        }

        return true;
    }
}
