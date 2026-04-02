class Solution {
    public String longestCommonPrefix(String[] strs) {
        //   m * log n
        int n = strs.length;
        Arrays.sort(strs);

        String min = strs[0];
        String max = strs[n - 1];

        int i = 0;
        StringBuilder sb = new StringBuilder();
        while(i < min.length()){
            if(min.charAt(i) == max.charAt(i)){
                sb.append(max.charAt(i++));
            }else break;        
        }
        return sb.toString();
    }
}