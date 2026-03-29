class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[]count = new int[26];

        for(char ch : tasks){
            count[ch - 'A']++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->
            b - a
        );
    
        for(int c : count){
            if(c != 0){
                pq.offer(c);
            }
        }

        Queue<int[]> q = new LinkedList<>();
        int time = 0;
        while(!pq.isEmpty() || !q.isEmpty()){
            time++;
            if(!pq.isEmpty()){
                int cur = pq.poll();
                int remain = cur - 1;
                if(remain > 0){
                    q.offer(new int[]{remain, time + n});
                }
            }else{
                    time = q.peek()[1];
            }

            if(!q.isEmpty() && q.peek()[1] == time){
                pq.offer(q.poll()[0]);
            }
        }
        return time;
    }
}
