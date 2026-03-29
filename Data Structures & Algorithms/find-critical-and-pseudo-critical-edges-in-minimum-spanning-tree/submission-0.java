class Solution {
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        List<int[]> edgesList = new ArrayList<>();

        for(int i = 0; i < edges.length; i++){
            int x = edges[i][0], y = edges[i][1], cost = edges[i][2];
            edgesList.add(new int[]{x,y,cost,i});
        }

        Collections.sort(edgesList, (a,b)->a[2] - b[2]);
        int mst = 0;
        for(int[]edge : edgesList){
            if(uf.union(edge[0], edge[1])) mst += edge[2];
        }

        List<Integer> critical = new ArrayList<>();
        List<Integer> pseudo = new ArrayList<>();

         for(int[]edge : edgesList){
            // without cur
            UnionFind withoutUf = new UnionFind(n);
            int wmstOther = 0;
            for(int[]other : edgesList){
                if(edge[3] != other[3] && withoutUf.union(other[0], other[1])){
                    wmstOther+= other[2];
                }
            }
            

            if(withoutUf.count != 1 || wmstOther > mst){
                critical.add(edge[3]);
                continue;
            }
            // with cur
            UnionFind withUf = new UnionFind(n);
            withUf.union(edge[0], edge[1]);
            int mstOther = edge[2];

            for(int[]other : edgesList){
                if(withUf.union(other[0], other[1])){
                    mstOther+= other[2];
                }
            }
            if(mstOther == mst){
                pseudo.add(edge[3]);
            }
        }
        return Arrays.asList(critical, pseudo);
    }
}

class UnionFind{

    int[] parents;
    int[] ranks;
    int count;

    public UnionFind(int n ){
        parents = new int[n];
        ranks = new int[n];
        for(int i = 0; i < n; i++){
            parents[i] = i;
            ranks[i] = 1;
        }
        count = n;

    }

    public int find(int a){
        if(parents[a] != a){
            parents[a] = find(parents[a]);
        }
        return parents[a];
    }

    public boolean union(int a, int b){

        int pA = find(a), pB = find(b);

        if(pA == pB) return false;

        if(ranks[pA] > ranks[pB]){
            parents[pB] = pA;
            ranks[pA] += ranks[pB];
        }else if(ranks[pA] < ranks[pB]){
            parents[pA] = pB;
            ranks[pB] += ranks[pA];
        }else{
            parents[pB] = pA;  
            ranks[pA]++;       
        }
        count--;
        return true;
    }



}