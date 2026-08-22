class Solution {
    public String simplifyPath(String path) {
        StringBuilder sb = new StringBuilder();
        int n = path.length();
        String[] parts = path.split("/");
        Stack<String> st = new Stack();
        for(String p : parts){
            if(p.isEmpty() || p.equals(".")) continue;
            if(p.equals("..")){
                if(!st.isEmpty()) st.pop();
                continue;
            }
            st.push(p);
        }

        for(String s : st){
            sb.append("/").append(s);
        }

        return sb.length() == 0 ? "/" : sb.toString();

    }
}