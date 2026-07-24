class Solution {
    List<List<String>> ans = new ArrayList<>();
    List<String> path = new ArrayList<>();
    public List<List<String>> partition(String s) {
        backTrack(s, 0);
        return ans;
    }

    public void backTrack(String s, int start){
        if(start == s.length()){
            ans.add(new ArrayList<>(path));
            return;
        }

        if(start > s.length()) return;

        for(int i = start; i < s.length(); i++){
            String sub = s.substring(start, i + 1);
            if(isPalindrom(sub)){
                path.add(sub);
                backTrack(s, i + 1);
                path.remove(path.size() - 1);
            }
        }


    }

    public boolean isPalindrom(String s){
        int l = 0, r = s.length() - 1;

        while(l <= r){
            if(s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }

        return true;
    }
}
