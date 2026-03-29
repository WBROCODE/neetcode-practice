class Solution {
    List<String> ans;
    public List<String> findItinerary(List<List<String>> tickets) {
        ans = new ArrayList<>();
        Map<String, PriorityQueue<String>> graph = buildUpgraph(tickets);
        dfs("JFK", graph);
        Collections.reverse(ans);
        return ans;
    }

    public void dfs(String start, Map<String, PriorityQueue<String>> graph){
        PriorityQueue<String> pq = graph.get(start);
        while(pq != null && !pq.isEmpty()){
            String next = pq.poll();
            dfs(next, graph);
        }
        ans.add(start);
        
    }

    public Map<String, PriorityQueue<String>> buildUpgraph(List<List<String>> edges){
        Map<String, PriorityQueue<String>>graph = new HashMap<>();
        for(List<String> edge : edges){
            String from = edge.get(0);
            String to = edge.get(1);
            graph.putIfAbsent(from, new PriorityQueue<>());
            graph.get(from).offer(to);
        }
        return graph;
    }
}
