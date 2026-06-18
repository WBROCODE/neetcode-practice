class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack();

        for(int a : asteroids){
            if(st.isEmpty() || a > 0){
                st.push(a);
            }else{
                while(!st.isEmpty() &&  st.peek() > 0 && Math.abs(a) > st.peek()){
                    st.pop();
                }
                if(st.isEmpty() || st.peek() < 0) st.push(a);
                else if(Math.abs(a) == st.peek()) st.pop();
            }
        }
        int i = 0;
        int[] ans = new int[st.size()];
        for(int s : st){
            ans[i++] = s;
        }
        return ans;
    }
}