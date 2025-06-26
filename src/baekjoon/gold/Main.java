package baekjoon.gold;

import java.io.*;
import java.util.*;

public class Main {

    static int N, M, A, B;
    static int[][] board;
    static List<Point> items = new ArrayList<>();

    static class Point implements Comparable<Point> {
        int x, y;
        public Point(int x, int y) { this.x = x; this.y = y; }
        public int compareTo(Point o) {
            if (this.x == o.x) return this.y - o.y;
            return this.x - o.x;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        board = new int[N][M];

        // 아이템 저장
        items.add(new Point(0, 0));
        for (int i = 0; i < A; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            items.add(new Point(x, y));
        }

        // 장애물 처리
        for (int i = 0; i < B; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            board[x][y] = -1;
        }

        items.add(new Point(N - 1, M - 1));
        Collections.sort(items);

        int answer = 1;

        for (int i = 0; i < items.size() - 1; i++) {
            Point from = items.get(i);
            Point to = items.get(i + 1);

            int[][] dp = new int[N][M];
            dp[from.x][from.y] = 1;

            for (int x = from.x; x <= to.x; x++) {
                for (int y = from.y; y <= to.y; y++) {
                    if (board[x][y] == -1) continue;
                    if (x > from.x) dp[x][y] += dp[x - 1][y];
                    if (y > from.y) dp[x][y] += dp[x][y - 1];
                }
            }

            answer *= dp[to.x][to.y];
        }

        System.out.println(answer);
    }
}