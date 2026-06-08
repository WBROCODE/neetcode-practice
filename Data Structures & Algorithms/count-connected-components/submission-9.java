class Solution {
    public int countComponents(int n, int[][] edges) {
        UF uf = new UF(n);
        for(int[] edge : edges){
            uf.union(edge[0], edge[1]);
        }
        return uf.size;
    }
}


class UF{
    int[]parents;
    int[]ranks;
    int size;
    public UF(int n){
        parents = new int[n];
        ranks = new int[n];

        for(int i = 0; i < n; i++){
            parents[i] = i;
            ranks[i] = 1;
        }
        size = n;
    }

    public int find(int a){
        if(parents[a] != a) parents[a] = find(parents[a]);
        return parents[a];
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