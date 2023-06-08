class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new ArrayList<>();
        solve(s, wordDict, 0, 0, "", res);
        return res;
    }
    
    public static void solve(String s, List<String> dict, int i, int j, String ans, List<String> res) {
        if(j == s.length()) {
            if(dict.contains(s.substring(i, j))) {
                ans += s.substring(i, j);
            }
            if(ans.length() != 0) {
                String[] a = ans.split(" ");
                if(ans.trim().length() - a.length + 1 == s.length())
                res.add(ans);
            }
            return;
        }
        
        String sub = s.substring(i, j);
        if(dict.contains(sub)) {
            solve(s, dict, j, j+1, ans + sub + " ", res);
            solve(s, dict, i, j+1, ans, res);
        } else {
            solve(s, dict, i, j+1, ans, res);
        }
    }
}