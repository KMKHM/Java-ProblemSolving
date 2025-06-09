package baekjoon.gold.graph;

import java.util.*;
import java.io.*;

public class BOJ_15789 {

    static int N, M;
    static List<List<Integer>> graph = new ArrayList<>();
    static StringTokenizer st;
    static int C, H, K;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        parent = new int[N+1];
        for (int i=0; i<N+1; i++) {
            parent[i] = i;
        }

        for (int i=0; i<N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int u=Integer.parseInt(st.nextToken());
            int v=Integer.parseInt(st.nextToken());
            union(u, v);
        }

        int[][] count = new int[N+1][2];

        st = new StringTokenizer(br.readLine());
        C = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for (int i=1; i<=N; i++) {
//            parent[i] = find(i);
            count[i][0]=i;
            count[parent[i]][1]++;
        }


        Arrays.sort(count, (x, y) -> y[1]-x[1]);

        int res=0;

        for (int[] arr : count) {
            if (arr[0] == parent[C]) {
                res+=arr[1];
                continue;
            }
            if (K != 0) {
                if (arr[0] != H && arr[0] != parent[H] && arr[0] != C && arr[0] != parent[C]) {
                    res += arr[1];
                    K--;
                }
            }
        }
        System.out.println(res);

    }

    static int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return find(parent[x]);
    }

    static void union(int x, int y) {
        int a = find(x);
        int b = find(y);
        parent[Math.max(a, b)] = Math.min(a, b);
    }
}
