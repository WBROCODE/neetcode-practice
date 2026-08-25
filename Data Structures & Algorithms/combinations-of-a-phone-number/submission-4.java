class Solution {
    String[] map = new String[]{"","","abc", "def", "ghi","jkl","mno","pqrs","tuv","wxyz"};
    List<String> ans;
    StringBuilder sb;
    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.length() == 0) return new ArrayList<>();
        ans = new ArrayList<>();
        sb = new StringBuilder();
        dfs(digits, 0);
        return ans;
    }

    public void dfs(String digits, int start){
        if(sb.length() == digits.length()){
            ans.add(sb.toString());
            return;
        }
        
        for(int i = start; i < digits.length(); i++){
            char digit = digits.charAt(i);
            char[] value = map[digit - '0'].toCharArray();
            for(char ch : value){
                sb.append(ch);
                dfs(digits, i + 1);
                sb.deleteCharAt(sb.length() - 1);
            }  
        }


    }
}
