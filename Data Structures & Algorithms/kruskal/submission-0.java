class Solution {
    public int minimumSpanningTree(List<List<Integer>> edges, int n) {
        if(n == 1) return 0;
        PriorityQueue<List<Integer>> pq = new PriorityQueue<>(
            (a,b)->a.get(2) - b.get(2)
        );

        for(List<Integer> edge : edges){
            pq.offer(edge);
        }

        UF uf = new UF(n);
        int ans = 0;
        while(!pq.isEmpty()){
            List<Integer> cur = pq.poll();
            int from = cur.get(0), to = cur.get(1), cost = cur.get(2);
            if(!uf.isConnected(from, to)){
                uf.union(from, to);
                ans+=cost;
            }
        }
        return uf.size() != 1 ? -1 : ans;
        
    }
}

class UF{
    int[]parents;
    int[]ranks;
    int size;

    public UF(int n){
        parents = new int[n];
        ranks = new int[n];
        size = n;

        for(int i =0; i < n; i++){
            parents[i] = i;
            ranks[i] = 1;
        }
    }

    public int find(int a){
        if(parents[a] != a) parents[a] = find(parents[a]);
        return parents[a];
    }

    public boolean isConnected(int a, int b){
        int pA = find(a), pB = find(b);
        return pA == pB;
    }

    public void union(int a, int b){
        int pA = find(a), pB = find(b);
        if(pA == pB) return;

        if(ranks[pA] >= ranks[pB]){
            parents[pA] = pB;
            ranks[pA] += ranks[pB];
        }else{
            parents[pB] = pA;
            ranks[pB] += ranks[pA];            
        }
        size--;
    }
    

    public int size(){
        return this.size;
    }
}
