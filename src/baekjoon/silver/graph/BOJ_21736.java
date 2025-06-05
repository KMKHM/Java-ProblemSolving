package baekjoon.silver.graph;

import java.util.*;
import java.io.*;

public class BOJ_21736 {

    static int N;
    static int M;
    static char[][] arr;
    static int res;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int x;
    static int y;
    static StringTokenizer st;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new char[N][M];
        visited = new boolean[N][M];

        for (int i=0; i<N; i++) {
            String s  = br.readLine();
            for (int j=0; j<M; j++) {
                arr[i][j] = s.charAt(j);
                if (arr[i][j] == 'I') {
                    x = i;
                    y = j;
                }
            }
        }

        visited[x][y] = true;
        dfs(x, y);

        System.out.println(res > 0 ? res : "TT");

    }

    static void dfs(int x, int y) {

        if (arr[x][y] == 'P') {
            res++;
        }

        for (int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny] && arr[nx][ny] != 'X') {
                visited[nx][ny] = true;
                dfs(nx, ny);
            }
        }

    }
}
