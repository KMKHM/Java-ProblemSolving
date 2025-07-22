package baekjoon.gold.graph;

import java.util.*;
import java.io.*;

public class BOJ_1726 {

    static int M, N;
    static int[][] board;
    static int sx, sy, sDir;
    static int ex, ey, eDir;
    static Map<Integer, int[]> map;
    static StringTokenizer st;
    static boolean[][][] visited;
    static int res=0;

    static class Node {
        int x;
        int y;
        int dir;
        int count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        board = new int[M][N];
        visited = new boolean[M][N][5];

        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        sx = Integer.parseInt(st.nextToken())-1;
        sy = Integer.parseInt(st.nextToken())-1;
        sDir = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        ex = Integer.parseInt(st.nextToken())-1;
        ey = Integer.parseInt(st.nextToken())-1;
        eDir = Integer.parseInt(st.nextToken());

        map = new HashMap<>();
        map.put(1, new int[] {0, 1});
        map.put(2, new int[] {0, -1});
        map.put(3, new int[] {1, 0});
        map.put(4, new int[] {-1, 0});
        bfs();
        System.out.println(res);

    }

    public static void bfs() {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node() {{
            x = sx;
            y = sy;
            dir = sDir;
            count = 0;
        }});

        visited[sx][sy][sDir] = true;

        while (!q.isEmpty()) {
            Node cur = q.poll();
            int curX = cur.x;
            int curY = cur.y;
            int curCount = cur.count;
            int curDir = cur.dir;
            if (curX == ex && curY == ey && curDir == eDir) {
                res = curCount;
                return;
            }

            for (int i=1; i<=3; i++) {
                int nx = curX + map.get(curDir)[0] * i;
                int ny = curY + map.get(curDir)[1] * i;


                if (nx < 0 || nx >= M || ny < 0 || ny >= N) {
                    continue;
                }

                if (board[nx][ny] == 1) {
                    break;
                }

                if (!visited[nx][ny][curDir]) {
                    visited[nx][ny][curDir] = true;
                    q.offer(new Node() {{
                        x = nx;
                        y = ny;
                        dir = curDir;
                        count = curCount + 1;
                    }});
                }
            }


            if ((curDir==2 || curDir == 1)) {
                if (!visited[curX][curY][3]) {
                    visited[curX][curY][3] = true;
                    q.offer(new Node() {{
                        x = curX;
                        y = curY;
                        dir = 3;
                        count = curCount + 1;
                    }});
                }

                if (!visited[curX][curY][4]) {
                    visited[curX][curY][4] = true;
                    q.offer(new Node() {{
                        x = curX;
                        y = curY;
                        dir = 4;
                        count = curCount + 1;
                    }});
                }
            }

            if ((curDir==3 || curDir == 4)) {
                if (!visited[curX][curY][1]) {
                    visited[curX][curY][1] = true;
                    q.offer(new Node() {{
                        x = curX;
                        y = curY;
                        dir = 1;
                        count = curCount + 1;
                    }});
                }

                if (!visited[curX][curY][2]) {
                    visited[curX][curY][2] = true;
                    q.offer(new Node() {{
                        x = curX;
                        y = curY;
                        dir = 2;
                        count = curCount + 1;
                    }});
                }
            }

        }
    }
}