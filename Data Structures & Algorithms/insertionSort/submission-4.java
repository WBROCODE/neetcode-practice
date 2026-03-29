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
        if (pairs == null || pairs.isEmpty()) return ans;
        ans.add(new ArrayList<>(pairs));

        for(int i = 1; i < pairs.size(); i++){
            int last = i - 1;
            
            while(last >= 0 && pairs.get(last).key > pairs.get(last + 1).key){
                Pair temp = pairs.get(last);
                pairs.set(last, pairs.get(last + 1));
                pairs.set(last + 1, temp);
                last--;
            } 
            ans.add(new ArrayList<>(pairs));
        }
        return ans;
    }
}
