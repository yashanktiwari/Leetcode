class Solution {
    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        long si = -1 * (long) 1e10;
        long ei = (long) 1e10;
        long ans = 0;
        while(si <= ei) {
            long mid = si + (ei-si)/2;
            if(countOfProduct(nums1, nums2, mid) >= k) {
                ans = mid;
                ei = mid - 1;
            } else {
                si = mid + 1;
            }
        }
        return ans;
    }

    public long countOfProduct(int[] arr1, int[] arr2, long pro) {
        long ans = 0;
        for(int e1 : arr1) {
            if(e1 >= 0) {
                long count = 0;
                int lo = 0;
                int hi = arr2.length-1;
                while(lo <= hi) {
                    int mid = lo + (hi - lo)/2;
                    if((long)(e1)*arr2[mid] <= pro) {
                        count = mid + 1;
                        lo = mid + 1;
                    } else {
                        hi = mid - 1;
                    }
                }
                ans += count;
            } else {
                long count = 0;
                int lo = 0;
                int hi = arr2.length-1;
                while(lo <= hi) {
                    int mid = lo + (hi - lo)/2;
                    if((long)(e1)*arr2[mid] <= pro) {
                        count = arr2.length - mid;
                        hi = mid - 1;
                    } else {
                        lo = mid + 1;
                    }
                }
                ans += count;
            }
        }
        return ans;
    }
}