class Solution {
    public String foreignDictionary(String[] words) {
        /**
            h r n    
            k: char v: char
        */

        int n = words.length;
        Map<Character, HashSet<Character>> graph = new HashMap<>();
        // build graph
        Map<Character, Integer> inDegrees = new HashMap<>();

        for(int i = 0; i < n ;i++){
            for(char ch : words[i].toCharArray()){
                inDegrees.putIfAbsent(ch, 0);
            }
        }

        for(int i = 1; i < n; i++){
            String prev = words[i - 1], cur = words[i];
            if(prev.length() > cur.length() && prev.startsWith(cur)) return "";
            int min = Math.min(prev.length(), cur.length());
            for(int j = 0; j < min; j++){
                if(prev.charAt(j) == cur.charAt(j)) continue;      
                // prev > cur
                if(graph.computeIfAbsent(prev.charAt(j), k-> new HashSet<>()).add(cur.charAt(j))) inDegrees.put(cur.charAt(j), inDegrees.get(cur.charAt(j)) + 1);
                break;             
            }
        }
        StringBuilder sb = new StringBuilder();
        Queue<Character> q = new LinkedList<>();
        if(inDegrees == null) return "";
        for(char k : inDegrees.keySet()){
            if(inDegrees.get(k) == 0) q.offer(k);
        }

        while(!q.isEmpty()){
            char cur = q.poll();
            sb.append(cur);
            for(char next : graph.getOrDefault(cur, new HashSet<>())){
                int inDegree = inDegrees.get(next);
                if(inDegree == 0) continue;
                inDegree--;
                if(inDegree == 0){
                    inDegrees.put(next, 0);
                    q.offer(next);
                }else{
                    inDegrees.put(next, inDegree);
                }
                
            }
        }
        return sb.length() < inDegrees.size() ? "" : sb.toString();
    }   
}
