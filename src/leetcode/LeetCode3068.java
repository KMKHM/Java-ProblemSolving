package leetcode;

class LeetCode3068 {
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        long sum = 0;
        int count = 0;
        int minDiff = Integer.MAX_VALUE;

        for (int num : nums) {
            int xorVal = num ^ k;
            if (xorVal > num) {
                sum += xorVal;
                count++;
                minDiff = Math.min(minDiff, xorVal - num);
            } else {
                sum += num;
                minDiff = Math.min(minDiff, num - xorVal);
            }
        }

        // 이득 본 노드 수가 홀수면, 가장 덜 이득 본 노드를 XOR 하지 않는 쪽으로 되돌려야 함
        if (count % 2 == 1) {
            sum -= minDiff;
        }

        return sum;
    }
}
