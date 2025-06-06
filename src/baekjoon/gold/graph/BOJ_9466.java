package baekjoon.gold.graph;

import java.io.*;
import java.util.*;

public class BOJ_9466 {
    static int T, N;
    static int[] arr, visited;
    static int count; // 사이클에 포함된 노드 수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            arr = new int[N + 1];
            visited = new int[N + 1]; // 0: 미방문, 1: 방문 중, 2: 처리 완료
            count = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i <= N; i++) {
                if (visited[i] == 0) {
                    dfs(i);
                }
            }

            System.out.println(N - count); // 사이클에 포함되지 않은 노드 수
        }
    }

    static void dfs(int x) {
        visited[x] = 1;
        int next = arr[x];

        if (visited[next] == 0) {
            dfs(next);
        } else if (visited[next] == 1) {
            int temp = next;
            while (temp != x) {
                count++;
                temp = arr[temp];
            }
            count++;
        }

        visited[x] = 2;
    }
}