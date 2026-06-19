// Definition for a pair.
// class Pair {
//     int key;
//     String value;
//
//     public Pair(int key, String value) {
//         this.key = key;
//         this.value = value;
//     }
// }
class Solution {
    public List<Pair> quickSort(List<Pair> pairs) {
        if (pairs == null || pairs.size() <= 1) return pairs;
        quickSort(pairs, 0, pairs.size() - 1);
        return pairs;
    }

    public void quickSort(List<Pair> pairs, int left, int right){
         if (left >= right) return;

        int partitionIndex = partition(pairs, left, right);
        quickSort(pairs, left, partitionIndex - 1);
        quickSort(pairs, partitionIndex + 1, right);

    }

    public int partition(List<Pair> pairs, int left, int right){
        int pivot = pairs.get(right).key;
        int store = left;
        for(int i = left; i < right; i++){
            if(pairs.get(i).key < pivot){
                swap(pairs, i, store);
                store++;
            }
        }
        swap(pairs, store, right);
        return store;
    }

    public void swap(List<Pair> pairs, int i, int j){
        Pair temp  = pairs.get(i);
        pairs.set(i,  pairs.get(j));
        pairs.set(j,  temp);
    }
}
