package baekjoon.gold.graph;

import java.io.*;
import java.util.*;

public class BOJ_15558 {
    static int LIMIT = 100_000;
    static int N, K;
    static int[][] arr;
    static boolean[][] visited;
    static StringTokenizer st;

    static class State {
        int x, y, time;

        public State(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[2][LIMIT];
        visited = new boolean[2][LIMIT];

        String line0 = br.readLine();
        String line1 = br.readLine();

        for (int i = 0; i < N; i++) {
            arr[0][i] = line0.charAt(i) == '1' ? 1 : -1;
            arr[1][i] = line1.charAt(i) == '1' ? 1 : -1;
        }

        System.out.println(bfs() ? 1 : 0);
    }

    static boolean bfs() {
        Queue<State> q = new LinkedList<>();
        q.offer(new State(0, 0, 0));  // 시작은 0번 줄 0번째 위치, 시간 0초
        visited[0][0] = true;

        while (!q.isEmpty()) {
            State cur = q.poll();
            int x = cur.x;
            int y = cur.y;
            int time = cur.time;

            for (int dir : new int[]{1, -1, K}) {
                int nx = x;
                int ny = y;

                if (dir == K) {
                    nx = 1 - x; // 반대편 줄
                    ny += K;
                } else {
                    ny += dir;
                }

                if (ny >= N) return true; // 탈출 조건

                if (ny < 0 || arr[nx][ny] == -1 || visited[nx][ny] || ny <= time) continue;

                visited[nx][ny] = true;
                q.offer(new State(nx, ny, time + 1));
            }
        }

        return false;
    }
}