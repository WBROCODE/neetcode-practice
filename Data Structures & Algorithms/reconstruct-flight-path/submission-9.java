class Solution {
    List<String> ans;
    public List<String> findItinerary(List<List<String>> tickets) {
        ans = new ArrayList<>();
        Map<String, PriorityQueue<String>> graph = buildGraph(tickets);
        dfs(graph, "JFK");
        Collections.reverse(ans);
        return ans;
    }
    
    public void dfs(Map<String, PriorityQueue<String>> graph, String start){
        
        PriorityQueue<String> next = graph.get(start);
        while(next != null && !next.isEmpty()){
            String nextS = next.poll();
            dfs(graph, nextS);
        }
        ans.add(start);
    }

    public Map<String, PriorityQueue<String>> buildGraph(List<List<String>> tickets){
        Map<String, PriorityQueue<String>> graph = new HashMap<>();

        for(List<String> ticket : tickets){
            String from = ticket.get(0), to = ticket.get(1);
            graph.computeIfAbsent(from, k->new PriorityQueue<>()).offer(to);
        }

        return graph;
    }
}
