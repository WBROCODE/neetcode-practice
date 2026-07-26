class Solution {
    List<String> ans = new ArrayList<>();
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> graph = buildUpGraph(tickets);
        dfs("JFK", graph);
        Collections.reverse(ans);
        return ans;
    }

    public void dfs(String start, Map<String, PriorityQueue<String>> graph){
        PriorityQueue<String> nextS = graph.get(start);
        while(nextS != null && !nextS.isEmpty()){
            String next = nextS.poll();
            dfs(next, graph);
        }
        ans.add(start);
    }

    public Map<String, PriorityQueue<String>> buildUpGraph(List<List<String>> tickets){
        Map<String, PriorityQueue<String>> map = new HashMap<>();

        for(List<String> ticket : tickets){
            String from = ticket.get(0);
            String to = ticket.get(1);
            map.computeIfAbsent(from, k->new PriorityQueue<>()).offer(to);
        }

        return map;
    }
}
