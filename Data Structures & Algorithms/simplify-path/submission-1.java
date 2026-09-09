class Solution {
    public String simplifyPath(String path) {
        String[] strs = path.split("/");
        Stack<String> st = new Stack();


        for(String str : strs){
            if(str == null || str.equals(".") || str.isEmpty()) continue;
            if(str.equals("..")){
                if(!st.isEmpty()) {
                    st.pop();
                }
                continue;
            }
            st.push(str);
        }
        
        StringBuilder sb = new StringBuilder();
        for(String s : st){
            sb.append("/").append(s);
        }

        return sb.length() == 0 ? "/" : sb.toString();

    }
}