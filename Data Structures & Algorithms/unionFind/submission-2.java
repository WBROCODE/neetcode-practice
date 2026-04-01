class UnionFind {
    int[] parents;
    int[] ranks;
    int size;
    public UnionFind(int n) {
        this.size = n;
        this.parents = new int[n];
        this.ranks = new int[n];

        for(int i = 0; i < n; i++){
            parents[i] = i;
            ranks[i] = 1;
        }
    }

    public int find(int x) {
        if(parents[x] != x) parents[x] = find(parents[x]);
        return parents[x];
    }

    public boolean isSameComponent(int x, int y) {
        int pX = find(x), pY = find(y);
        if(pX == pY) return true;

        return false;
    }

    public boolean union(int x, int y) {
        int pX = find(x), pY = find(y);
        if(pX == pY) return false;

        if(ranks[x] >= ranks[y]){
            parents[pY] = pX;
            ranks[pX] += ranks[pY];
        }else{
            parents[pX] = pY;
            ranks[pY] += ranks[pX];            
        }
        this.size--;

        return true;
    }

    public int getNumComponents() {
        return this.size;
    }
}
