class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n == 0) return false;
        long t = n;
        return ((t & (t-1)) == 0);
    }
}