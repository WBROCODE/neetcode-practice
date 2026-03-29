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
        List<Pair> ans = new ArrayList<>();
        if(pairs.size() == 0 || pairs.isEmpty()) return ans;
        int n = pairs.size();
        temp = new Pair[n];
        mergeSortStart(pairs);

        return pairs;
    }

    public void mergeSortStart(List<Pair> pairs){
        int left = 0, right = pairs.size();
        divide(left, right - 1, pairs);
    }

    public void divide(int left, int right, List<Pair> pairs){
        if(left < right){
            int mid = left + (right - left) / 2;
            divide(left, mid, pairs);
            divide(mid + 1, right, pairs);
            merge(left, mid, right, pairs);
        }
    }

    public void merge(int left, int mid, int right, List<Pair> pairs){
        // copy sorted
        for(int i = left; i <= right; i++) temp[i] = pairs.get(i);

        int i = left, j = mid + 1;

        for(int p = left; p <= right; p++){

            if(i == mid + 1){
                pairs.set(p,  temp[j]);
                j++;
            }else if(j == right + 1){
                pairs.set(p,  temp[i]);
                i++;                
            }else if(temp[i].key > temp[j].key){
                pairs.set(p,  temp[j]);
                j++;
            }else{
                pairs.set(p,  temp[i]);
                i++;
            }
        }


    }
}
