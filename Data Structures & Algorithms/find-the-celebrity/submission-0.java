/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        int p = 0;
        for(int i = 1; i < n; i++){
            if(knows(p, i) || !knows(i, p)) p = i;
        }

        for(int i = 0; i < n; i++){
            if(p == i) continue;
            if(knows(p, i) || !knows(i, p)) return -1;
        }
        return p;
    }
}
