package baekjoon.gold.graph;

import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[][] arr;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int res = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][N];

        for (int i=0; i<N; i++) {
            String s = br.readLine();
            for (int j=0; j<M; j++) {
                arr[i][j] = s.charAt(j) - '0';
            }
        }

        bfs(0, 0);
        System.out.println(res == Integer.MAX_VALUE ? -1 : res);
    }

    static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y, 1, 1});
        boolean[][] visited = new boolean[N][M];
        visited[x][y] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int curX = cur[0];
            int curY = cur[1];
            int curCnt = cur[2];
            int curRes = cur[3];

            if (curX==N-1 && curY==M-1) {
                res=Math.min(res, curRes);
            }

            for (int i=0; i<4; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny]) {
                    if (arr[nx][ny] == 0) {
                        visited[nx][ny] = true;
                        q.offer(new int[]{nx, ny, curCnt, curRes+1});
                    } else if (arr[nx][ny] == 1 && curCnt == 1) {
                        visited[nx][ny] = true;
                        q.offer(new int[]{nx, ny, 0, curRes+1});
                    }
                }
            }
        }
    }
}
