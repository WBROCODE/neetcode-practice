class Solution {
    public int countComponents(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);

        for(int []edge : edges){
            uf.union(edge[0], edge[1]);
        }

        return uf.size();
    }
}

class UnionFind{
    int size;
    int[] parents;
    int[] ranks;

    public UnionFind(int n){
        parents = new int[n];
        ranks = new int[n];
        for(int i = 0; i < n; i++){
            parents[i] = i;
        }
        this.size = n;
    }

    public int find(int x){
        if(x != parents[x]){
            parents[x] = find(parents[x]);
        }
        return parents[x];
    }

    public void union(int a, int b){
        int p1 = find(a), p2 = find(b);
        if(p1 == p2) return;
        if(ranks[p1] > ranks[p2]){
            parents[p2] = parents[p1];
        }else if(ranks[p1] < ranks[p2]){
            parents[p1] = parents[p2];
        }else{
            parents[p2] = p1;
            ranks[p1] += 1;
        }
        size--;
    }

    public int size(){
        return size;
    }


}
