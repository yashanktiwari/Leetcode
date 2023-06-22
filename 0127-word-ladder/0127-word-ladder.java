class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        return solve(beginWord, endWord, wordList);
    }

    public int solve(String beginword, String endword, List<String> list) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(beginword, 1));
        Set<String> set = new HashSet<>(list);

        while (!queue.isEmpty()) {
            Pair rp = queue.poll();

            String word = rp.word;
            int lvl = rp.lvl;

            if (word.equals(endword))
                return lvl;

            for (int i = 0; i < word.length(); i++) {
                for (int j = 0; j < 26; j++) {
                    String temp = word.substring(0, i) + (char) (j + 'a') + word.substring(i + 1);
                    if (set.contains(temp)) {
                        queue.add(new Pair(temp, lvl + 1));
                        set.remove(temp);
                    }
                }
            }
        }
        return 0;
    }

    class Pair {
        String word;
        int lvl;

        public Pair(String word, int lvl) {
            this.word = word;
            this.lvl = lvl;
        }
    }
}