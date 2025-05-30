package baekjoon.gold.graph;

import java.io.*;
import java.util.*;

public class BOJ_18405_2 {
    static int N, K, S, X, Y;
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static class Virus {
        int x, y, type, time;

        public Virus(int x, int y, int type, int time) {
            this.x = x;
            this.y = y;
            this.type = type;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        List<Virus> virusList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] > 0) {
                    virusList.add(new Virus(i, j, map[i][j], 0));
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken()) - 1;
        Y = Integer.parseInt(st.nextToken()) - 1;

        virusList.sort(Comparator.comparingInt(v -> v.type));
        Queue<Virus> queue = new LinkedList<>(virusList);

        while (!queue.isEmpty()) {
            Virus v = queue.poll();
            if (v.time == S) break;

            for (int d = 0; d < 4; d++) {
                int nx = v.x + dx[d];
                int ny = v.y + dy[d];

                if (nx >= 0 && nx < N && ny >= 0 && ny < N && map[nx][ny] == 0) {
                    map[nx][ny] = v.type;
                    queue.add(new Virus(nx, ny, v.type, v.time + 1));
                }
            }
        }

        System.out.println(map[X][Y]);
    }
}