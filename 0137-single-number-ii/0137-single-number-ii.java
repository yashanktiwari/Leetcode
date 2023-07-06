class Solution {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for(int i=0; i<32; i++) {
            int ones = 0;
            int temp = i;
            
            for(int j=0; j<nums.length; j++) {
                if((nums[j] & (1<<temp)) != 0) {
                    ones++;
                }
            }

            if(ones % 3 != 0) {
                ans = ans | (1<<temp);
            }
        }
        return ans;
    }
}