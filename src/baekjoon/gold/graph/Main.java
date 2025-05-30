package baekjoon.gold.graph;

import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int M;
    static int T;
    static int[][] board;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static StringTokenizer st;
    static int res1 = Integer.MAX_VALUE;
    static int res2 = Integer.MAX_VALUE;
    static int res3 = Integer.MAX_VALUE;
    static int[] swordPosition=new int[] {0, 0};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 2) {
                    swordPosition[0] = i;
                    swordPosition[1] = j;
                }
            }
        }

        bfs(0, 0);
        bfsToSword(0, 0);
        toTarget(swordPosition[0], swordPosition[1]);
        int ans=0;

        if (res2 != Integer.MAX_VALUE && res3 != Integer.MAX_VALUE) {
            ans = Math.min(res1, res2 + res3);
        } else {
            ans = res1;
        }

        System.out.println(ans > T ? "Fail" : ans);


    }

    static void bfs(int x, int y) {
        boolean[][] visited=new boolean[N][M];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {x, y, 0});
        visited[x][y] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int curX = cur[0];
            int curY = cur[1];
            int curTime = cur[2];

            if (curX == N-1 && curY == M-1) {
                res1 = Math.min(res1, curTime);
                return;
            }

            for (int i=0; i<4; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny]) {
                    if (board[nx][ny] != 1) {
                        visited[nx][ny] = true;
                        q.offer(new int[] {nx, ny, curTime+1});
                    }
                }
            }
        }
    }

    static void bfsToSword(int x, int y) {
        boolean[][] visited=new boolean[N][M];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {x, y, 0});
        visited[x][y] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int curX = cur[0];
            int curY = cur[1];
            int curTime = cur[2];


            if (curX == swordPosition[0] && curY == swordPosition[1]) {
                res2 = Math.min(res2, curTime);
                return;
            }

            for (int i=0; i<4; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny]) {
                    if (board[nx][ny] == 0 || board[nx][ny] == 2) {
                        visited[nx][ny] = true;
                        q.offer(new int[] {nx, ny, curTime+1});
                    }
                }
            }
        }
    }

    static void toTarget(int x, int y) {
        boolean[][] visited=new boolean[N][M];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {x, y, 0});
        visited[x][y] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int curX = cur[0];
            int curY = cur[1];
            int curTime = cur[2];

            if (curX == N-1 && curY == M-1) {
                res3 = Math.min(res3, curTime);
                return;
            }

            for (int i=0; i<4; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.offer(new int[] {nx, ny, curTime+1});
                }
            }
        }
    }

}
