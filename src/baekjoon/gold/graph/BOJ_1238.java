package baekjoon.gold.graph;

import java.util.*;
import java.io.*;

public class BOJ_1238 {

    static int N;
    static int M;
    static int X;
    static int[] distance;
    static StringTokenizer st;
    static List<List<Node>> graph = new ArrayList<>();
    static class Node {
        int idx;
        int cost;
        public Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
        public String toString() {
            return idx + " " + cost;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        for (int i=0; i<N+1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(u).add(new Node(v, c));
        }

        distance = new int[N+1];

        int[] res = new int[N+1];
        int ans = 0;

        for (int i=1; i<=N; i++) {
            Arrays.fill(distance, Integer.MAX_VALUE);
            dijkstra(i);

            if (i == X) {
                for (int j=1; j<=N; j++) {
                    res[j] += distance[j];
                }
            } else {
                res[i] += distance[X];
            }
        }

        for (int i : res) {
            ans = Math.max(ans, i);
        }
        System.out.println(ans);


    }

    public static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);
        pq.add(new Node(start, 0));
        distance[start] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (cur.cost > distance[cur.idx]) {
                continue;
            }

            for (int i=0; i<graph.get(cur.idx).size(); i++) {
                Node next = graph.get(cur.idx).get(i);
                if (distance[next.idx] > cur.cost + next.cost) {
                    distance[next.idx] = cur.cost + next.cost;
                    pq.offer(new Node(next.idx, distance[next.idx]));
                }
            }
        }


    }
}
