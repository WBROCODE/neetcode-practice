class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        UnionFind uf = new UnionFind(n);
        Map<String, Integer> emailToAcc = new HashMap<>();
        // email to Acc
        for(int i = 0 ; i < n; i++){
            List<String> emails = accounts.get(i);
            for(int j = 1; j < emails.size(); j++){
                String email = emails.get(j);
                if(emailToAcc.containsKey(email)){
                    uf.union(i, emailToAcc.get(email));
                }else{
                    emailToAcc.put(email, i);  
                }
            }
        }
        // account to Email
        Map<Integer, List<String>> accToEmail = new HashMap<>();
        for(Map.Entry<String, Integer> entry : emailToAcc.entrySet()){
            String email = entry.getKey();
            int accId = entry.getValue();
            int user = uf.find(accId);
            accToEmail.putIfAbsent(user, new ArrayList<>());
            accToEmail.get(user).add(email);
        }

        List<List<String>> ans = new ArrayList<>();

        for(Map.Entry<Integer, List<String>> entry : accToEmail.entrySet()){
            int userId = entry.getKey();
            List<String> accs = entry.getValue();
            Collections.sort(accs);
            List<String> merged = new ArrayList<>();
            merged.add(accounts.get(userId).get(0));
            merged.addAll(accs);
            ans.add(merged);
        }


        return ans;
    }
}

public class UnionFind {
    HashMap<Integer, Integer> parents;
    HashMap<Integer, Integer> ranks;
    /**
     * 
     *  TC: O(1), SC: O(n)
     * 
     */
    public UnionFind(int n){
        parents = new HashMap<>();
        ranks = new HashMap<>();

        for(int i = 0; i < n; i++){
            // set the parent as it self
            parents.put(i, i);
            ranks.put(i, 0);
        }
    }

    public int find(int x){
        // find the root
        if(x != parents.get(x)){
            parents.put(x, find(parents.get(x))); // compression the path
        }
        return parents.get(x);
    }

    public boolean union(int a, int b){
        int p1 = find(a), p2= find(b);
        if(p1 == p2) return false;

        if(ranks.get(p1) > ranks.get(p2)){
            parents.put(p2, p1);
        }else if(ranks.get(p1) < ranks.get(p2)){
            parents.put(p1, p2);            
        }else{
            // add rank for p2, set p1 as parent
            parents.put(p2, p1);            
            ranks.put(p1, ranks.get(p1) + 1);
        }
        return true;
    }
}