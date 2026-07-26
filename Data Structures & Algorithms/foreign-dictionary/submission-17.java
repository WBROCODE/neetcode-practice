class Solution {
    public String foreignDictionary(String[] words) {
        Map<Character, Integer> inDegrees = new HashMap<>();

        for(String word : words){
            for(char ch : word.toCharArray()){
                inDegrees.put(ch, 0);
            }
        }
        int n = words.length;
        Map<Character, HashSet<Character>> graph = new HashMap<>();
        for(int i = 1; i <= n - 1; i++){
            String prev = words[i - 1];
            String next = words[i];
            if(prev.length() > next.length() && prev.startsWith(next)) return "";
            for(int j = 0; j < Math.min(prev.length(), next.length()); j++){
                if(prev.charAt(j) == next.charAt(j)) continue;
                char chPrev = prev.charAt(j);
                char chNext = next.charAt(j);
                graph.computeIfAbsent(chPrev, k->new HashSet<>());
                if(!graph.get(chPrev).contains(chNext)){
                    graph.get(chPrev).add(chNext);
                    inDegrees.put(chNext, inDegrees.get(chNext) + 1);
                }
                break;
            }
        }
        
        Queue<Character> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for(char ch : inDegrees.keySet()){
            if(inDegrees.get(ch) == 0){
                queue.offer(ch);
            }
        }

        while(!queue.isEmpty()){
            char cur = queue.poll();
            sb.append(cur);
            for(char ch : graph.getOrDefault(cur, new HashSet<>())){
                inDegrees.put(ch, inDegrees.get(ch) - 1);
                if(inDegrees.get(ch) == 0){
                    queue.offer(ch);
                }
            }
        }
        return sb.length() == inDegrees.size() ? sb.toString() : "";
    }
}
