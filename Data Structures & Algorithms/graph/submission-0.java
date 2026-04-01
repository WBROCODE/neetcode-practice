class Graph {
    Map<Integer, HashSet<Integer>> map;
    public Graph() {
        this.map = new HashMap<>();
    }

    public void addEdge(int src, int dst) {
        map.computeIfAbsent(src, k->new HashSet<>()).add(dst);
    }

    public boolean removeEdge(int src, int dst) {
        if(!map.containsKey(src)) return false;

        return map.get(src).remove(dst);
    }

    public boolean hasPath(int src, int dst) {
        if(!map.containsKey(src)) return false;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(src);
        HashSet<Integer> visited = new HashSet<>();

        while(!queue.isEmpty()){
            int cur = queue.poll();
            if(cur == dst) return true;
            if(visited.contains(cur)) continue;
            visited.add(cur);

            for(int next : map.getOrDefault(cur, new HashSet<>())){
                if(!visited.contains(next)){
                    queue.offer(next);
                }
            }
        }

        return false;
    }
}
