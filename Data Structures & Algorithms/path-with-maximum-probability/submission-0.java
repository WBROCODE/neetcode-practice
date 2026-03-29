class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        Map<Integer, List<Pair>> graph = new HashMap<>();
        for(int i = 0; i < n; i++) graph.put(i, new ArrayList<>());

        for(int i = 0; i < edges.length; i++){
            int[] edge = edges[i];
            int from = edge[0], to = edge[1];
            double weight = succProb[i];
            graph.get(from).add(new Pair(to, weight));
            graph.get(to).add(new Pair(from, weight));

        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->Double.compare(b.weight, a.weight));
        Map<Integer, Double> shortest = new HashMap<>();
        pq.offer(new Pair(start_node, 1.0));

        while(!pq.isEmpty()){
            Pair cur = pq.poll();
            int to = cur.to;
            double cost = cur.weight;

            if(shortest.containsKey(to)) continue;
            List<Pair> nexts = graph.get(to);
            shortest.put(to, cost);
            if(to == end_node) return cost;

            for(Pair next : nexts){
                int nextTo = next.to;
                double nextCost = next.weight;
                if(!shortest.containsKey(nextTo)){
                    pq.offer(new Pair(nextTo, cost * nextCost));
                }
            }
        }
        return 0.0;
    }
}

class Pair{
    int to;
    double weight;
    public Pair(int to, double weight){
        this.to = to;
        this.weight = weight;
    }
}