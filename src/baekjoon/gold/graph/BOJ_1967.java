package baekjoon.gold.graph;

import java.util.*;
import java.io.*;

public class BOJ_1967 {
    static int N;
    static StringTokenizer st;
    static List<List<Node>> graph = new ArrayList<>();
    static int[] distance;
    static boolean[] visited;
    static class Node {
        int idx;
        int cost;
        public Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int i=0; i<N+1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i=0; i<N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(u).add(new Node(v, c));
            graph.get(v).add(new Node(u, c));
        }

        distance = new int[N+1];
        visited = new boolean[N+1];
        visited[1] = true;
        dfs(1);
        visited[1] = false;
        int temp=0;
        int node=0;
        for (int i=2; i<=N; i++) {
            if (temp < distance[i]) {
                temp=distance[i];
                node = i;
            }
        }

        Arrays.fill(distance, 0);
        visited[node] = true;
        dfs(node);

        int res=0;

        for (int i=1; i<=N; i++) {
            res = Math.max(res, distance[i]);
        }

        System.out.println(res);

    }

    static void dfs(int start) {

        for (int i=0; i<graph.get(start).size(); i++) {
            Node next = graph.get(start).get(i);

            if (!visited[next.idx]) {
                visited[next.idx] = true;
                distance[next.idx] = distance[start] + next.cost;
                dfs(next.idx);
                visited[next.idx] = false;
            }
        }
    }
}
