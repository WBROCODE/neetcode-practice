class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        /**
        1   4
        3   2
                            10-1 = 9 / 3 = 3
                            10-4 = 6 / 2 = 3

        10 - 0 / 1 = 10
        10 - 1 / 2 = 4.5
        10 - 4 / 2 = 3
        10 - 7 / 1 = 3

        */
        List<int[]> states = new ArrayList<>();
        int n = position.length;
        for(int i = 0; i < n; i++){
            states.add(new int[]{position[i], speed[i]});
            
        }
        Collections.sort(states, (a,b)->{
            if(a[0] == b[0]){
                return a[1] - b[1];
            }else return a[0] - b[0];
        });
        
        Stack<Double> stack = new Stack<>();
        for(int[] s : states){
            stack.add((double)(target - s[0]) / s[1]);
        }
        double prevTime = 0;
        int ans = 0;
        while(!stack.isEmpty()){
            double curTime = stack.pop();
            if(curTime > prevTime){
                ans++;
                prevTime = curTime;
            }
        }

        return ans;

    }
}
