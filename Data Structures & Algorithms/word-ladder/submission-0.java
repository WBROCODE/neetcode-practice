class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return 0;
        
        HashSet<String> visited = new HashSet<>();
        visited.add(beginWord);
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        int step = 1;

        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                String cur = q.poll();
                char[] curChs = cur.toCharArray();
                for(int j = 0; j < curChs.length; j++){
                    char curCh = curChs[j];
                    // switch ch
                    for(int z = 0; z <= 25; z++){
                        char newCh = (char)('a' + z);
                        if(newCh == curCh) continue;
                        curChs[j] = newCh;
                        String newWord = new String(curChs);
                        if(!visited.contains(newWord) && wordSet.contains(newWord)){
                            if(newWord.equals(endWord)) return step + 1;
                            visited.add(newWord);
                            q.offer(newWord);
                        }
                    }
                    curChs[j] = curCh;
                }
            }
            step++;
        }
        return 0;
    }
}