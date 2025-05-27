package baekjoon.gold;

import java.util.*;
import java.io.*;

public class BOJ_13023 {
    static int N;
    static int M;
    static StringTokenizer st;
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean flag = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i=0; i<N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        boolean[] visited = new boolean[N];

        for(int i=0; i<N; i++) {
            visited[i] = true;
            dfs(i, 0, visited);
            visited[i] = false;
        }

        System.out.println(flag?1:0);

    }

    static void dfs(int start, int cur, boolean[] visited) {

        if (flag) {
            return;
        }

        if (cur == 4) {
            flag = true;
            return;
        }

        if (!flag) {
            for (int next : graph.get(start)) {
                if (!visited[next]) {
                    visited[next] = true;
                    dfs(next, cur+1, visited);
                    visited[next] = false;
                }
            }
        }

    }
}
