class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int freq1 = 0, freq2 = 0;
        int num1 = -1, num2 = -1;

        int n = nums.length;
        for(int i=0; i<n; i++) {
            if(nums[i] == num1) {
                freq1++;
            } else if(nums[i] == num2) {
                freq2++;
            } else if(freq1 == 0) {
                num1 = nums[i];
                freq1 = 1;
            } else if(freq2 == 0) {
                num2 = nums[i];
                freq2 = 1;
            } else {
                freq1--;
                freq2--;
            }
        }

        freq1 = 0;
        freq2 = 0;
        for(int i=0; i<n; i++) {
            if(nums[i] == num1) freq1++;
            else if(nums[i] == num2) freq2++;
        }
        
        List<Integer> list = new ArrayList<>();
        if(freq1 > n/3) list.add(num1);
        if(num1 != num2 && freq2 > n/3) list.add(num2);
        return list;
    }
}