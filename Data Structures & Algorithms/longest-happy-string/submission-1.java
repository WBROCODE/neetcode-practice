class Solution {
    public String longestDiverseString(int a, int b, int c) {
        /**
            abcabcabb
            aabbccaab
        


            a b


        */

        PriorityQueue<int[]> pq = new PriorityQueue<>((x,y)->y[0] - x[0]);
        if(a>0) pq.offer(new int[]{a, 'a'});
        if(b>0) pq.offer(new int[]{b, 'b'});
        if(c>0) pq.offer(new int[]{c, 'c'});
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            // aa a
            if(sb.length() > 1 && sb.charAt(sb.length() - 1) == sb.charAt(sb.length() - 2) && sb.charAt(sb.length() - 1) == cur[1]){
                if(pq.isEmpty()) break;
                int[] second = pq.poll();
                sb.append((char)second[1]);
                second[0]--;
                if(second[0] > 0) pq.offer(second);
                pq.offer(cur);
            }else{
                sb.append((char)cur[1]);
                cur[0]--;
                if(cur[0] > 0){
                    pq.offer(cur);
                }
            }
        }
        return sb.toString();
    }
}