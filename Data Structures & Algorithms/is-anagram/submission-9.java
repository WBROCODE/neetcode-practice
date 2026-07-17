class Solution {
    public boolean isAnagram(String s, String t) {
        char[] chS = s.toCharArray();
        char[] chT = t.toCharArray();
        Arrays.sort(chS);
        Arrays.sort(chT);
        return Arrays.equals(chS, chT);
    }
}
