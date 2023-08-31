class Solution {
    public long minimumReplacement(int[] nums) {
        int n = nums.length;
        long ans = 0;
        int maxTillNow = nums[n-1];
        for(int i=n-2; i>=0; i--) {
            if(nums[i] > maxTillNow) {
                // System.out.println(maxTillNow);
                if(nums[i] % maxTillNow == 0) {
                    ans += (nums[i] / maxTillNow) - 1;
                } else {
                    int temp = (nums[i] / maxTillNow)+1;
                    ans += temp-1;
                    maxTillNow = nums[i] / temp;
                }
                // System.out.println(i + " Split ->  " + maxTillNow + " : " + (nums[i] / maxTillNow + 1));
            } else {
                maxTillNow = Math.min(maxTillNow, nums[i]);
            }
        }

        return ans;
    }
}

/*
7 6

1 6
2 5
3 4
*/