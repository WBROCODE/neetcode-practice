// Definition for a pair
// class Pair {
//     int key;
//     String value;
//
//     Pair(int key, String value) {
//         this.key = key;
//         this.value = value;
//     }
// }
public class Solution {
    public List<List<Pair>> insertionSort(List<Pair> pairs) {
        List<List<Pair>> ans = new ArrayList<>();
        if(pairs == null || pairs.isEmpty()) return ans;
        int n = pairs.size();
        ans.add(new ArrayList<>(pairs));
        for(int i = 1; i < n; i++){
            int prev = i - 1;
            while(prev >= 0 && pairs.get(prev).key > pairs.get(prev+1).key){
                Pair temp = pairs.get(prev);  
                pairs.set(prev, pairs.get(prev + 1));
                pairs.set(prev + 1, temp);
                prev--;
            }
            ans.add(new ArrayList<>(pairs));
        }
        return ans;
    }
}
