class Solution {
    public int countComponents(int n, int[][] edges) {
        UF uf = new UF(n);
        for(int[] edge : edges){
            int from = edge[0], to = edge[1];
            uf.union(from, to);
        }
        return uf.size;
    }
}

class UF{
    int[] parents;
    int[] ranks;
    int size;
    public UF(int n){
        size = n;
        parents = new int [n];
        ranks = new int [n];
        for(int i = 0; i < n; i++){
            parents[i] = i;
            ranks[i] = 1;
        }
    }

    public int find(int i){
        if(parents[i] != i) return find(parents[i]);
        return parents[i];
    }

    public void union(int a, int b){
        int pA = find(a), pB = find(b);

        if(pA == pB) return;

        if(ranks[pA] >= ranks[pB]){
            parents[pB] = parents[pA];
            ranks[pA] += ranks[pB];
        }else{
            parents[pA] = parents[pB];
            ranks[pB] += ranks[pA];            
        }
        size--;
    }

}
