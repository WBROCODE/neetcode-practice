class Solution {
    List<List<String>> ans = new ArrayList<>();
    List<String> path = new ArrayList<>();

    public List<List<String>> partition(String s) {
        backTrack(s, 0);
        return ans;
    }

    public void backTrack(String s, int start){
        if(s.length() == start){
            ans.add(new ArrayList<>(path));
            return;
        }

        for(int i = start; i < s.length(); i++){
            String sub = s.substring(start, i + 1);
            if(isPalindrome(sub)){
                path.add(sub);
                backTrack(s, i + 1);
                path.remove(path.size() - 1);
            }
        }

    }

    public boolean isPalindrome(String str){
        int l = 0, r = str.length() - 1;

        while(l <= r){
            if(str.charAt(l++) != str.charAt(r--)) return false;
        }

        return true;
    }
}
