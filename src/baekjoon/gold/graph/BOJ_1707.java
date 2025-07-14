package baekjoon.gold.graph;

import java.util.*;
import java.io.*;

public class BOJ_1707 {

    static int K, V, E;
    static int[] color;
    static boolean[] visited;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        K = Integer.parseInt(br.readLine());

        while (K-- > 0) {
            st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            List<List<Integer>> graph = new ArrayList<>();
            color = new int[V + 1];
            visited = new boolean[V + 1];

            for (int i = 0; i <= V; i++) {
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                graph.get(u).add(v);
                graph.get(v).add(u);
            }

            boolean isBipartite = true;
            for (int i = 1; i <= V; i++) {
                if (!visited[i]) {
                    if (!bfs(i, graph)) {
                        isBipartite = false;
                        break;
                    }
                }
            }

            System.out.println(isBipartite ? "YES" : "NO");
        }
    }

    static boolean bfs(int start, List<List<Integer>> graph) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;
        color[start] = 1;

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int next : graph.get(cur)) {
                if (!visited[next]) {
                    visited[next] = true;
                    color[next] = 1 - color[cur]; // 반대 색
                    q.offer(next);
                } else if (color[next] == color[cur]) {
                    // 인접한 두 노드가 같은 색 → 이분 그래프 아님
                    return false;
                }
            }
        }
        return true;
    }
}
