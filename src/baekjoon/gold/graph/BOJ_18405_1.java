package baekjoon.gold.graph;

import java.util.*;
import java.io.*;

public class BOJ_18405_1 {
    static int N;
    static int K;
    static StringTokenizer st;
    static int[][] arr;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int S;
    static int X;
    static int Y;
    static Map<Integer, Queue<int[]>> virus = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for (int i=1; i<=K; i++) {
            virus.put(i, new LinkedList<>());
        }

        arr = new int[N][N];

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] <= K && arr[i][j] != 0) {
                    virus.get(arr[i][j]).offer(new int[]{i, j});
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken())-1;
        Y = Integer.parseInt(st.nextToken())-1;

        for (int i=0; i<S; i++) {
            bfs();
        }

        System.out.println(arr[X][Y]);


    }

    static void bfs() {

        for (int i=1; i<=K; i++) {
            Queue<int[]> newQ = new LinkedList<>();
            Queue<int[]> curQ = virus.get(i);
            while (!curQ.isEmpty()) {
                int[] cur = curQ.poll();
                int curX = cur[0];
                int curY = cur[1];

                for (int j=0; j<4; j++) {
                    int nx = curX + dx[j];
                    int ny = curY + dy[j];
                    if (nx >= 0 && nx < N && ny >= 0 && ny < N && arr[nx][ny] == 0) {
                        arr[nx][ny] = i;
                        newQ.offer(new int[]{nx, ny});
                    }
                }
            }
            virus.put(i, newQ);
        }

    }
}
