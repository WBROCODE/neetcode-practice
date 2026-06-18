class Solution {
    public String reorganizeString(String s) {
        Map<Character, Integer> freqS = new HashMap<>();

        for(char ch : s.toCharArray()){
            freqS.put(ch, freqS.getOrDefault(ch, 0) +1);
        }

        PriorityQueue<Character> pq = new PriorityQueue<>(
            (a,b)->{
                return freqS.get(b) -  freqS.get(a);
            }
        );

        for(char ch : freqS.keySet()){
            pq.offer(ch);
        }

        StringBuilder sb = new StringBuilder();
        while(pq.size() > 1){
            char one = pq.poll();
            char two = pq.poll();
            sb.append(one);
            sb.append(two);

            freqS.put(one, freqS.get(one) - 1);
            freqS.put(two, freqS.get(two) - 1);

            if(freqS.get(one) >= 1){
                pq.offer(one);
            }

            if(freqS.get(two) >= 1){
                pq.offer(two);
            }
        }

        if(pq.size() == 1){
            char ch = pq.poll();
            if(freqS.get(ch) > 1) return "";
            sb.append(ch);
        }


        return sb.toString();
        
    }
}