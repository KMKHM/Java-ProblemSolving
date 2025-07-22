package baekjoon.gold.graph;

import java.io.*;
import java.util.*;

public class BOJ_5427 {
    static StringBuilder sb = new StringBuilder();
    static int T, W, H;
    static char[][] board;
    static int[][] visited;
    static int[][] personVisited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int sx, sy;
    static Queue<Node> fire;
    static StringTokenizer st;

    static class Node {
        int x;
        int y;
        int time;

        Node(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
            fire = new LinkedList<>();

            board = new char[H][W];
            visited = new int[H][W];
            personVisited = new int[H][W];

            for (int i = 0; i < H; i++) {
                String s = br.readLine();
                for (int j = 0; j < W; j++) {
                    board[i][j] = s.charAt(j);
                    if (board[i][j] == '@') {
                        sx = i;
                        sy = j;
                    }

                    if (board[i][j] == '*') {
                        fire.offer(new Node(i, j, 1));
                        visited[i][j] = 1;
                    }
                }
            }
            int res = bfs(sx, sy);
            sb.append(res == -1 ? "IMPOSSIBLE" : res).append("\n");
        }
        System.out.println(sb);
    }

    static int bfs(int x, int y) {
        Queue<Node> person = new LinkedList<>();
        person.offer(new Node(x, y, 1));
        personVisited[x][y] = 1;

        while (!fire.isEmpty()) {
            Node cur = fire.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (nx < 0 || nx >= H || ny < 0 || ny >= W) continue;

                if (board[nx][ny] != '#' && visited[nx][ny] ==0) {
                    visited[nx][ny] = cur.time + 1;
                    fire.offer(new Node(nx, ny, visited[nx][ny]));
                }
            }
        }

        while (!person.isEmpty()) {
            Node cur = person.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                // 탈출 조건
                if (nx < 0 || nx >= H || ny < 0 || ny >= W) {
                    return cur.time;
                }

                // 이동 가능한 조건 (불이 아직 안 왔거나 더 늦게 올 때만 이동)
                if (board[nx][ny] == '.' && personVisited[nx][ny] == 0 &&
                        (visited[nx][ny] == 0 || cur.time + 1 < visited[nx][ny])) {
                    personVisited[nx][ny] = cur.time + 1;
                    person.offer(new Node(nx, ny, personVisited[nx][ny]));
                }
            }
        }
        return -1;
    }
}