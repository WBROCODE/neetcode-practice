class Solution {
    String[] map = new String[]{"","","abc", "def", "ghi","jkl","mno","pqrs","tuv","wxyz"};
    StringBuilder sb = new StringBuilder();
    List<String> ans = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.length() ==0) return ans;
        
        backTrack(digits, 0);
        
        return ans;
    }

    public void backTrack(String s, int start){
        
        if(start == s.length()){
            ans.add(sb.toString());
            return;
        }

        char chS = s.charAt(start);
        int digit = chS - '0';
        for(char ch : map[digit].toCharArray()){
            sb.append(ch);
            backTrack(s, start + 1);
            sb.deleteCharAt(sb.length() - 1);
        }




    }



}
