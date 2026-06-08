class Solution {
    List<String> ans;
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> graph = buildUpGraph(tickets);
        ans = new ArrayList<>();
        dfs(graph, "JFK");
        Collections.reverse(ans);
        return ans;
    }

    public void dfs(Map<String, PriorityQueue<String>> graph, String start){
        PriorityQueue<String> nextStation = graph.get(start);
        
        while(nextStation != null && !nextStation.isEmpty()){
            String next = nextStation.poll();
            dfs(graph, next);
        }
        ans.add(start);
    }

    public Map<String, PriorityQueue<String>> buildUpGraph(List<List<String>> tickets){
         Map<String, PriorityQueue<String>> graph = new HashMap<>();
        for(List<String> ticket : tickets){
            String from = ticket.get(0), to = ticket.get(1);
            graph.computeIfAbsent(from, k->new PriorityQueue<>()).offer(to);
        }
        return graph;
    }
}
