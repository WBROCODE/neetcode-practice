class Solution {
    List<String> ans = new ArrayList<>();
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> graph = buildGraph(tickets);
        dfs(graph, "JFK");
        Collections.reverse(ans);
        return ans;
    }

    public void dfs(Map<String, PriorityQueue<String>> graph, String cur){
        PriorityQueue<String> nexts = graph.getOrDefault(cur, new PriorityQueue<>());
        while(!nexts.isEmpty()){
            String next = nexts.poll();
            dfs(graph, next);
        }
        ans.add(cur);
    }

    public Map<String, PriorityQueue<String>> buildGraph(List<List<String>> tickets){
        Map<String, PriorityQueue<String>> graph = new HashMap<>();

        for(List<String> t : tickets){
            String from = t.get(0), to = t.get(1);
            graph.computeIfAbsent(from, k->new PriorityQueue<>()).offer(to);
        }

        return graph;
    }
}
