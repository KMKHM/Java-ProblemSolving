package leetcode;

import java.util.*;

class LeetCode73 {
    public void setZeroes(int[][] matrix) {
        List<int[]> list = new ArrayList<>();
        int n= matrix.length;
        int m= matrix[0].length;

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (matrix[i][j] == 0) {
                    list.add(new int[] {i, j});
                }
            }
        }

        for (int[] arr : list) {
            int r=arr[0];
            int c=arr[1];

            for (int j=0; j<m; j++) {
                matrix[r][j]=0;
            }

            for (int i=0; i<n; i++) {
                matrix[i][c]=0;
            }

        }


    }

}
