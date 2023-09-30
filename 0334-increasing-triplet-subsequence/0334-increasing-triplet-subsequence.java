class Solution {
    public boolean increasingTriplet(int[] nums) {
        return lis_bs(nums);
    }

    public boolean lis_bs(int[] arr) {
        List<Integer> list = new ArrayList<>();
        int n = arr.length;
        for(int i=0; i<n; i++) {
            if(list.size() == 0 || list.get(list.size()-1) < arr[i]) {
                list.add(arr[i]);
            } else {
                int idx = findIdx(arr[i], list);
                list.set(idx, arr[i]);
            }
        }

        return list.size() >= 3;
    }

    public int findIdx(int num, List<Integer> list) {
        int si = 0, ei = list.size()-1;
        int ans = 0;
        while(si <= ei) {
            int mid = si + (ei-si)/2;
            if(list.get(mid) < num) {
                si = mid + 1;
            } else if(list.get(mid) > num) {
                ans = mid;
                ei = mid - 1;
            } else {
                return mid;
            }
        }
        return ans;
    }
}

/*
1 5 6

3
*/