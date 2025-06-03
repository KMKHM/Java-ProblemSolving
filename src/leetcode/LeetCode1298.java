package leetcode;

import java.util.*;

class LeetCode1298 {
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        int n = status.length;
        boolean[] hasKey = new boolean[n];
        boolean[] hasBox = new boolean[n];
        boolean[] visited = new boolean[n];

        Queue<Integer> queue = new LinkedList<>();
        int totalCandies = 0;

        // 초기 박스 소유 표시
        for (int box : initialBoxes) {
            hasBox[box] = true;
        }

        boolean progress = true;

        // 반복하면서 새로 열 수 있는 상자 생길 때마다 다시 체크
        while (progress) {
            progress = false;

            for (int i = 0; i < n; i++) {
                // 아직 방문 안 했고, 내가 상자를 갖고 있고, 열 수 있을 때
                if (!visited[i] && hasBox[i] && (status[i] == 1 || hasKey[i])) {
                    visited[i] = true;
                    totalCandies += candies[i];
                    progress = true;

                    // 키 얻기
                    for (int key : keys[i]) {
                        hasKey[key] = true;
                    }

                    // 상자 안에 있는 박스 얻기
                    for (int newBox : containedBoxes[i]) {
                        hasBox[newBox] = true;
                    }
                }
            }
        }

        return totalCandies;
    }
}
