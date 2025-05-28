package baekjoon.gold.graph;

import java.io.*;
import java.util.*;

public class BOJ_1916 {
    static int N;
    static int M;
    static StringTokenizer st;
    static List<List<Node>> graph = new ArrayList<>();
    static int[] dist;

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

        N=Integer.parseInt(br.readLine());
        M=Integer.parseInt(br.readLine());
        dist=new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        for (int i=0; i<=N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i=0; i<M; i++) {
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            int c=Integer.parseInt(st.nextToken());

            graph.get(a).add(new Node(b, c));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        dijkstra(start, end);
        System.out.println(dist[end]);

    }

    public static void dijkstra(int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);
        pq.offer(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (cur.cost > dist[cur.idx]) {
                continue;
            }

            if (cur.idx == end) {
                return;
            }

            for (int i=0; i<graph.get(cur.idx).size(); i++) {
                Node next = graph.get(cur.idx).get(i);
                if (dist[next.idx] > cur.cost + next.cost) {
                    dist[next.idx] = cur.cost + next.cost;
                    pq.offer(new Node(next.idx, dist[next.idx]));
                }
            }

        }
    }

}
