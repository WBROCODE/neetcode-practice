class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        UF uf = new UF(n + 1);
        List<int[]> ans = new ArrayList<>();
        for(int[] edge : edges){ 
            if(uf.find(edge[0]) == uf.find(edge[1])) return edge;
            uf.union(edge[0], edge[1]);
        }
        return new int[]{};
    }
}

class UF{
    int[]parents;
    int[]ranks;
    int size;

    public UF(int n){
        parents = new int[n + 1];
        ranks = new int[n + 1];
        size = n + 1;

        for(int i =0 ; i <= n; i++){
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

        if(ranks[pA] >= ranks[pB]){
            parents[pB] = pA;
            ranks[pA] += ranks[pB];
        }else{
            parents[pA] = pB;
            ranks[pB] += ranks[pA];  
        }
        size--;
    }

}

