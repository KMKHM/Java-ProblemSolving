package baekjoon.gold.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static StringTokenizer st;
    static int[] parent, arr;

    static int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return find(parent[x]);
    }

    static void union(int a, int b) {
        int aP = find(a);
        int bP = find(b);
        parent[Math.max(aP, bP)] = Math.min(aP, bP);
    }



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        parent = new int[N+1];
        arr = new int[N+1];


        for (int i=1; i<N+1; i++) {
            int num = Integer.parseInt(st.nextToken());

            union(i, num);
            parent[i] = find(num);
        }

        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a]+=b;
        }
    }

}
