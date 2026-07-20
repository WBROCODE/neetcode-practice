class Solution {
    public boolean checkInclusion(String s1, String s2) {
        /**
        
        s1 > s2 false

        map countS1
        

        fixed size sw





        */

        int m = s1.length(), n = s2.length();
        if(m > n) return false;

        int[] count1 = new int[128];
        for(char ch : s1.toCharArray()) count1[ch]++;

        int[] count2 = new int[128];
        for(int i = 0; i < m; i++){
            char ch = s2.charAt(i);
            count2[ch]++;
        }
        if(Arrays.equals(count1, count2)) return true;

        for(int i = m ; i < n; i++){
            char chR = s2.charAt(i);
            char chL = s2.charAt(i - m);
            count2[chR]++;
            count2[chL]--;
            if(Arrays.equals(count1, count2)) return true;   
        }
        return false;
    }
}
