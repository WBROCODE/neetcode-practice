class Solution {
    List<String> ans = new LinkedList<>();
    String[] map = new String[]{"","","abc", "def", "ghi","jkl","mno","pqrs","tuv","wxyz"};
    //                              1.  2.      3     
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) return ans;
        backTrack(0, digits, new StringBuilder());
        return ans;
    }

    public void backTrack(int start, String digits, StringBuilder sb){

        if(sb.length() == digits.length()){
            ans.add(sb.toString());
            return;
        }

        for(int i = start; i < digits.length(); i++){

            int digit = digits.charAt(i) - '0';

            for(char ch : map[digit].toCharArray()){
                sb.append(ch);
                backTrack(i + 1, digits, sb);
                sb.deleteCharAt(sb.length() - 1);
            }

        }

    }
}
