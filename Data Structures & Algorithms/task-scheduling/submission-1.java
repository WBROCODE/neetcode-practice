class Solution {
    public int leastInterval(char[] tasks, int n) {
        /**
            A _ _ _ A _ _ _ A 
            (n + 1) * (maxF - 1) + maxC
            X _ _ X 
            2 + 2 *   

        */

        int m = tasks.length;
        int[] freq = new int[26];
        int maxF = 0;
        for(int i = 0; i < m; i++){
            char ch = tasks[i];
            freq[ch - 'A']++;
            maxF = Math.max(maxF, freq[ch - 'A']);
        }
        int maxC = 0;
        
        for(int a : freq){
            if(a == maxF) maxC++;
        }

        int time = (n + 1) * (maxF - 1) + maxC;

        return Math.max(time, tasks.length);
    }
}
