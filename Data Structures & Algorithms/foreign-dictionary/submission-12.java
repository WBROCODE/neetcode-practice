class Solution {
    public String foreignDictionary(String[] words) {
        /**
        
            words = ["hrn","hrf","er","enn","rfnn"]
        
                n < f

        */
    
        Map<Character, Integer> inDegrees = new HashMap<>();

        for(String word : words){
            for(char ch : word.toCharArray()){
                inDegrees.put(ch, 0);
            }
        }
        int n = words.length;

        Map<Character, HashSet<Character>> graph = new HashMap<>();
        for(int i = 0; i < n - 1; i++){
            String prev = words[i];
            String cur = words[i + 1];
            if(prev.length() > cur.length() && prev.startsWith(cur)) return "";

            for(int j = 0; j < Math.min(prev.length(), cur.length()); j++){
                if(prev.charAt(j) == cur.charAt(j)) continue;
                char chP = prev.charAt(j), chC = cur.charAt(j);
                Set<Character> neighbors = graph.computeIfAbsent(chP, k -> new HashSet<>());
                if (!neighbors.contains(chC)) {
                    neighbors.add(chC);
                    inDegrees.put(chC, inDegrees.get(chC) + 1);
                }
                break;
            }
        }
        Queue<Character> q = new LinkedList<>();
        for(char key : inDegrees.keySet()){
            if(inDegrees.get(key) == 0) q.offer(key);
        }
        StringBuilder sb = new StringBuilder();

        while(!q.isEmpty()){
            char cur = q.poll();
            sb.append(cur);
            for(char next : graph.getOrDefault(cur, new HashSet<>())){
                inDegrees.put(next, inDegrees.get(next) - 1);
                if(inDegrees.get(next) == 0){
                    q.offer(next);
                }
            }
        }
        if(sb.length() != inDegrees.size()) return "";

        return sb.toString();
    }
}
