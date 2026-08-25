class Solution {
    String[] map = new String[]{"","","abc", "def", "ghi","jkl","mno","pqrs","tuv","wxyz"};
    List<String> ans = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.length() == 0) return ans;
        bT(digits, 0);
        return ans;
    }

    public void bT(String digits, int start){
        if(start == digits.length()){
            ans.add(sb.toString());
            return;
        }
        if(start > digits.length()) return;
        int num = digits.charAt(start) - '0';
        String keys = map[num];
        for(char ch : keys.toCharArray()){
            sb.append(ch);
            bT(digits, start + 1);
            sb.deleteCharAt(sb.length() - 1);
        }

    }

}
