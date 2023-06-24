class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Map<String, Integer> map = new HashMap<>();
        Set<String> set = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        map.put(beginWord, 1);
        set.remove(beginWord);
        while(!queue.isEmpty()) {
            String rv = queue.poll();
            int n = rv.length();
            char[] arr = rv.toCharArray();
            
            if(rv.equals(endWord)) break;

            for(int i=0; i<n; i++) {
                char original = arr[i];
                for(char ch='a'; ch<='z'; ch++) {
                    arr[i] = ch;
                    String newWord = new String(arr);
                    if(set.contains(newWord)) {
                        queue.add(newWord);
                        map.put(newWord, map.get(rv)+1);
                        set.remove(newWord);
                    }
                }
                arr[i] = original;
            }
        }
        List<List<String>> ans = new ArrayList<>();
        List<String> seq = new ArrayList<>();
        seq.add(endWord);
        if(map.containsKey(endWord)) {
            dfs(map, beginWord, ans, endWord, seq);
        }
        return ans;
    }

    public void dfs(Map<String, Integer> map, String beginWord, List<List<String>> ans, String word, List<String> seq) {
        if(word.equals(beginWord)) {
            ans.add(new ArrayList<>(seq));
            return;
        }

        int n = word.length();
        char[] arr = word.toCharArray();
        for(int i=0; i<n; i++) {
            char original = arr[i];
            for(char ch='a'; ch<='z'; ch++) {
                arr[i] = ch;
                String newWord = new String(arr);
                if(map.containsKey(newWord) && map.get(newWord)+1 == map.get(word)) {
                    seq.add(0, newWord);
                    dfs(map, beginWord, ans, newWord, seq);
                    seq.remove(newWord);
                }
            }
            arr[i] = original;
        }
    }
}