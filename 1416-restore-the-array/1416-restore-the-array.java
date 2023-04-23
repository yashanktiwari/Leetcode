// class Solution {
//     public int numberOfArrays(String s, int k) {
//         long ans = calc(s, "", k);
//         return (int)(ans % 1000000007);
//     }
    
//     public long calc(String s, String ans, int k) {
        
//         if(s.length() == 0) {
//             System.out.println(ans);
//             return 1;
//         }
        
//         long t = 0;
//         for(int i=1; i<=s.length(); i++) {
//             String roq = s.substring(i);
//             String a = s.substring(0, i);
            
//             if(Integer.parseInt(a) > k || a.charAt(0) == '0') {
//                 return 0;
//             }
            
//             long temp = calc(roq, ans+a+"|", k);
//             t = t + temp;
//         }
//         System.out.println(t);
//         return t;
//     }
// }

class Solution {
    public int dfs(String s, long k, int i, int[] dp) {
        if (i == s.length()) return 1;
        if (s.charAt(i) == '0') return 0;
        if (dp[i] != -1) return dp[i];

        int ans = 0;
        long num = 0;
        for (int j = i; j < s.length(); j++) {
            num = num * 10 + s.charAt(j) - '0';
            if (num > k) break;
            ans = (ans + dfs(s, k, j + 1, dp)) % 1000000007;
        }
        return dp[i] = ans;
    }

    public int numberOfArrays(String s, int k) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);
        return dfs(s, k, 0, dp);
    }
}