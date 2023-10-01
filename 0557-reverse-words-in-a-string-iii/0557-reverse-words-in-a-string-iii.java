class Solution {
    public String reverseWords(String s) {
        String[] arr = s.split(" ");
        int n = arr.length;
        StringBuilder ans = new StringBuilder("");
        for(int i=0; i<n; i++) {
            StringBuilder sb = new StringBuilder(arr[i]);
            ans.append(sb.reverse().toString() + " ");
        }
        return new String(ans).trim();
    }
}