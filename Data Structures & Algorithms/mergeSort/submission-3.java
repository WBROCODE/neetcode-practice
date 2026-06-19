// Definition for a pair.
// class Pair {
//     public int key;
//     public String value;
//
//     public Pair(int key, String value) {
//         this.key = key;
//         this.value = value;
//     }
// }
class Solution {
    Pair[] temp;
    public List<Pair> mergeSort(List<Pair> pairs) {
        temp = new Pair[pairs.size()];
        divide(pairs, 0, pairs.size() - 1);
        return pairs;
    }

    public void divide(List<Pair> pairs, int l, int r){
        if(l >= r) return;
        int m = l + (r - l) / 2;   
          
        divide(pairs, l, m);
        divide(pairs, m + 1, r);
        merge(pairs, l, m, r);
    }

    public void merge(List<Pair> pairs, int l, int m, int r){
        // copy
        for(int i = l; i <= r; i++) temp[i] = pairs.get(i);
        int i = l, j = m + 1;

        for(int p = l; p <= r; p++){
            if(i == m + 1){
                pairs.set(p, temp[j]);
                j++;
            }else if(j == r + 1){
                pairs.set(p, temp[i]);
                i++;
            }else if(temp[i].key > temp[j].key){
                pairs.set(p, temp[j]);
                j++;
            }else{
                pairs.set(p, temp[i]);
                i++;                
            }
        }
    }
}
