class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        UnionFind uf = new UnionFind(n);
        int[] ans = new int[2];
        for(int[] edge : edges){
            int one = edge[0];
            int two = edge[1];
            if(!uf.union(one, two)){
                ans[0] = one;
                ans[1] = two;
            }
        }
        return ans;
    }
}

class UnionFind{

    HashMap<Integer, Integer> parents;
    HashMap<Integer, Integer> ranks;

    public UnionFind(int n){

        parents = new HashMap<>();
        ranks = new HashMap<>();

        for(int i = 1; i <= n; i++){
            parents.put(i, i);
            ranks.put(i, 0);
        }
    }

    public int find(int x){
        if(x != parents.get(x)){
            parents.put(x, find(parents.get(x)));
        }
        return parents.get(x);
    }

    public boolean union(int a, int b){
        int p1 = find(a), p2 = find(b);
        if(p1 == p2) return false;

        if(ranks.get(p1) > ranks.get(p2)){
            parents.put(p2, p1);
        }else if(ranks.get(p1) < ranks.get(p2)){
            parents.put(p1, p2);            
        }else{
            parents.put(p2, p1);            
            ranks.put(p1, ranks.get(p1) + 1);
        }
        return true;
    }
}
