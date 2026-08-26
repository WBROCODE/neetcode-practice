class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        UF uf = new UF(n);
        for(int[] edge : edges){
            int from = edge[0], to = edge[1];
            if(uf.isConnected(from, to)) return new int[]{from, to};
            else uf.union(from, to);
        }
        return new int[]{};
    }
}

class UF{
    int[] parents;
    int[] ranks;
    int size;
    public UF(int n){
        this.size =  n;
        parents = new int[n + 1];
        ranks = new int[n + 1];

        for(int i = 1; i <= n; i++){
            parents[i] = i;
            ranks[i] = 1;
        }
    }
    
    public int find(int x){
        if(parents[x] != x) parents[x] = find(parents[x]);
        return parents[x];
    }
    
    public void union(int a, int b){
        int pA = find(a), pB = find(b);
        if(pA == pB) return;

        if(ranks[pA] > ranks[pB]){
            parents[pB] = parents[pA];
            ranks[pA] += ranks[pB];
        }else{
            parents[pA] = parents[pB];
            ranks[pB] += ranks[pA];           
        }
        size--;
    }

    public boolean isConnected(int a, int b){
        if(find(a) == find(b)) return true;
        return false;
    }

}