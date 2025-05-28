package baekjoon.gold.graph;

import java.util.*;
import java.io.*;

public class BOJ_1987 {

    static int N;
    static int M;
    static StringTokenizer st;
    static int[][] arr;
    static int res = Integer.MIN_VALUE;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];

        for (int i=0; i<N; i++) {
            char[] s = br.readLine().toCharArray();
            for (int j=0; j<M; j++) {
                arr[i][j] = (int)s[j] - 65;
            }

        }

        boolean[] visited = new boolean[26];
        backtracking(0, 0, 1, visited);

        System.out.println(res);
    }

    static void backtracking(int x, int y, int cnt, boolean[] visited) {

        if (visited[arr[x][y]]) {
            return;
        }

        res = Math.max(res, cnt);

        visited[arr[x][y]] = true;

        for (int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                continue;
            }

            if (!visited[arr[nx][ny]]) {
                backtracking(nx, ny, cnt+1, visited);
            }
        }

        visited[arr[x][y]] = false;


    }
}
