class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // check wordList has endWord
        // bfs
        // visited -set 
        // cat
        // 26 * len(beginword) * N      SC: wordList.size()
        if(beginWord == null || beginWord.length() == 0 || !wordList.contains(endWord)) return 0;
        HashSet<String> words = new HashSet<>(wordList);
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        HashSet<String> visited = new HashSet<>();
        visited.add(beginWord);
        int ans = 1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int p = 0; p < size; p++){
                String cur = q.poll();
                char[] chs = cur.toCharArray();
                for(int i = 0; i < chs.length; i++){
                    char temp = chs[i];
                    for(int j = 0; j < 26; j++){
                        char newCh =(char)(j + 'a'); 
                        if(newCh == temp) continue;
                        chs[i] = newCh;
                        String newS = new String(chs);
                        if(newS.equals(endWord)) return ans + 1;
                        else if(words.contains(newS) && !visited.contains(newS)){
                            q.offer(newS);
                            visited.add(newS);
                        }
                    }
                    chs[i] = temp;
                }
            }
            ans++;
        }
        return 0;
    }
}
