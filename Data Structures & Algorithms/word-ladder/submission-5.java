class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> words = new HashSet<>(wordList);
        if(!words.contains(endWord)) return 0;

        Queue<String> q = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        int step = 1;
        visited.add(beginWord);
        q.offer(beginWord);

        while(!q.isEmpty()){
            int size = q.size();
            for(int k = 0; k < size; k++){
                String cur = q.poll();
                char[] chs = cur.toCharArray();
                if(cur.equals(endWord)) return step;
                for(int i = 0; i < chs.length; i++){
                    char temp = chs[i];
                    for(int j = 0; j <= 25; j++){
                        char charN = (char)('a' + j);
                        chs[i] = charN;
                        String newStr = new String(chs);
                        if(!visited.contains(newStr) && words.contains(newStr)){
                            q.offer(newStr);
                            visited.add(newStr);
                        }
                    }
                    chs[i] = temp;
                }
            }
            step++;
        }

        return 0;
    }
}
