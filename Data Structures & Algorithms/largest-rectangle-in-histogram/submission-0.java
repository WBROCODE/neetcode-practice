class Solution {
    public int largestRectangleArea(int[] heights) {
        int ans = 0;

        int n = heights.length;

        Stack<Integer> st = new Stack();
        // prev smaller
        int[] prevS = new int[n];
        for(int i = 0; i < n; i++){
            while(!st.isEmpty() && heights[i] <= heights[st.peek()]){
                st.pop();
            }
            prevS[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        st.clear();
        int[] nextS = new int[n];
        for(int i = n - 1; i >= 0; i--){
            while(!st.isEmpty() && heights[i] <= heights[st.peek()]){
                st.pop();
            }
            nextS[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        for(int i = 0; i < n; i++){
            ans = Math.max(ans, (nextS[i] - prevS[i] - 1) * heights[i]);
        }
        return ans;
    }
}
