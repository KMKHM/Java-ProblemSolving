package leetcode;

import java.util.*;

class LeetCode135 {
    public int candy(int[] ratings) {
        int n = ratings.length;
        if (n == 0) return 0;
        int[] c = new int[n];
        Arrays.fill(c, 1);
        for (int i = 1; i < n; i++) {
            if (ratings[i-1] < ratings[i]) {
                c[i] = c[i-1] + 1;
            }
        }
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i+1]) {
                c[i] = Math.max(c[i], c[i+1] + 1);
            }
        }
        int sum = 0;
        for (int v : c) sum += v;
        return sum;
    }
}
