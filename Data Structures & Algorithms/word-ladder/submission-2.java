class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        /**
        n: word.length() 
        m: wordList.size
        TC: 26^n * m
        SC: m + 26^n
        
        */
        HashSet<String> hashSet = new HashSet<>();
        HashSet<String> visited = new HashSet<>();

        for(String word : wordList){
            hashSet.add(word);
        }
        if(!hashSet.contains(endWord)) return 0;
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        visited.add(beginWord);
        int step = 1;

        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                String cur = q.poll();
                char[] chsCur = cur.toCharArray();
                for(int j = 0; j < chsCur.length; j++){
                    char curChar = chsCur[j];
                    for(int z = 0; z <= 25; z++){
                        char newChar = (char)('a' + z);
                        if(newChar == curChar) continue;
                        chsCur[j] = newChar;
                        String newS = new String(chsCur);
                        if(newS.equals(endWord)) return step+1;
                        if(!visited.contains(newS)){
                            if(hashSet.contains(newS)){
                                q.offer(newS);
                                visited.add(newS);
                            }
                        }
                    }
                    chsCur[j] = curChar;
                }
            }
            step++;
        }
        return 0;
    }
}
