class Solution {
    public String foreignDictionary(String[] words) {
        if(words == null || words.length == 0) return "";

        Map<Character, Integer> inDegrees = new HashMap<>();
        for(String word : words){
            for(char ch : word.toCharArray()){
                inDegrees.putIfAbsent(ch, 0);
            }
        }

        // build graph
        Map<Character, HashSet<Character>> graph = new HashMap<>();
        for(int i = 1; i < words.length; i++){
            String word1 = words[i - 1];
            String word2 = words[i];
            if(word1.length() > word2.length() && word1.startsWith(word2)) return "";
            for(int j = 0; j < Math.min(word1.length(), word2.length()); j++){
                if(word1.charAt(j) != word2.charAt(j)){
                    graph.putIfAbsent(word1.charAt(j), new HashSet<>());
                    if(graph.get(word1.charAt(j)).add(word2.charAt(j))){
                        inDegrees.put(word2.charAt(j), inDegrees.get(word2.charAt(j))+ 1);
                    }                
                    break;
                }
            }
        }

        // bfs
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

        if(inDegrees.size() != sb.length()) return "";
        return sb.toString();

    }
}
