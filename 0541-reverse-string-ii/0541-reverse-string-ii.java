class Solution {
    public String reverseStr(String s, int k) {
        int i = 0;
        StringBuilder rev = new StringBuilder("");
        StringBuilder ans = new StringBuilder("");
        int count = 0;
        boolean reverse = false;

        while(i < s.length()) {

            if(count < 2*k) {
                rev.append(s.charAt(i));
                count++;
            }

            if(count == k) {
                ans.append(rev.reverse().toString());
                rev.setLength(0);
                reverse = true;
            }

            if(count == 2*k) {
                ans.append(rev.toString());
                rev.setLength(0);
                reverse = false;
                count = 0;
            }

            i++;
        }

        if(count < 2*k) {
            if(!reverse) ans.append(rev.reverse().toString());
            else ans.append(rev.toString());
        }

        return ans.toString();
    }
}