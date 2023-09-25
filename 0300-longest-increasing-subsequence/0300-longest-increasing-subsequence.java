class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n+1][n+1];
        for(int[] ar : dp) Arrays.fill(ar, -1);
        return lis_bs(nums);
    }

    // Recursive solution
    public int lis(int i, int last, int[] arr) {
        if(i == 0) {
            if(last == -1 || arr[0] < arr[last]) return 1;
            else return 0;
        }

        int pick = 0;
        if(last == -1 || arr[i] < arr[last]) {
            pick = 1 + lis(i-1, i, arr);
        }

        int notPick = 0 + lis(i-1, last, arr);

        return Math.max(pick, notPick);
    }

    // Memoization solution
    public int lis_m(int i, int last, int[] arr, int[][] dp) {
        if(i == 0) {
            if(last-1 == -1 || arr[0] < arr[last-1]) return 1;
            else return 0;
        }
        if(dp[i][last] != -1) return dp[i][last];

        int pick = 0;
        if(last-1 == -1 || arr[i] < arr[last-1]) {
            pick = 1 + lis_m(i-1, i+1, arr, dp);
        }

        int notPick = 0 + lis_m(i-1, last, arr, dp);

        return dp[i][last] = Math.max(pick, notPick);
    }

    // Tabulation solution
    public int lis_t(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n+1][n+1];

        for(int j=0; j<=n; j++) {
            if(j-1 == -1 || arr[0] < arr[j-1]) dp[0][j] = 1;
        }

        for(int i=1; i<n; i++) {
            for(int j=0; j<=n; j++) {
                int pick = 0;
                if(j-1 == -1 || arr[i] < arr[j-1]) {
                    pick = 1 + dp[i-1][i+1];
                }

                int notPick = 0 + dp[i-1][j];

                dp[i][j] = Math.max(pick, notPick);
            }
        }

        return dp[n-1][0];
    }

    // Binary Search solution
    public int lis_bs(int[] arr) {
        List<Integer> list = new ArrayList<>();

        int n = arr.length;
        for(int i=0; i<n; i++) {
            if(list.isEmpty() || arr[i] > list.get(list.size()-1)) {
                list.add(arr[i]);
            } else {
                int idx = findIdx(arr[i], list);
                list.set(idx, arr[i]);
            }
        }
        return list.size();
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
