package baekjoon.gold.graph;

import java.util.*;
import java.io.*;

public class BOJ_16928 {

    static int N, M;
    static StringTokenizer st;
    static int[] arr = new int[101];
    static boolean[] visited = new boolean[101];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());


        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a] = b;
        }
        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a] = b;
        }
        System.out.println(bfs(1));

    }

    static int bfs(int start) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{start, 0});

        while (!q.isEmpty()) {
            int[] e = q.poll();
            int cur = e[0];
            int cnt = e[1];

            if (cur == 100) {
                return cnt;
            }

            for (int i=1; i<=6; i++) {
                int next = cur + i;
                if (next<=100 && !visited[next]) {
                    if (arr[next] != 0) {
                        visited[arr[next]] = true;
                        q.offer(new int[]{arr[next], cnt+1});
                    } else {
                        visited[next] = true;
                        q.offer(new int[]{next, cnt+1});
                    }
                }

            }
        }

        return -1;
    }
}
