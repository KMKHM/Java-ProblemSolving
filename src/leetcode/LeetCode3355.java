package leetcode;

class LeetCode3355 {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;

        int[] prefix = new int[n+1];

        for (int[] arr : queries) {
            int a=arr[0];
            int b=arr[1];
            prefix[a]--;
            prefix[b+1]++;
        }

        for (int i=1; i<=n; i++) {
            prefix[i] += prefix[i-1];
        }

        for (int i=0; i<n; i++) {
            nums[i] += prefix[i];
            if (nums[i] > 0) {
                return false;
            }
        }

        return true;
    }
}
