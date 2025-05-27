package baekjoon.silver.graph;

import java.util.*;
import java.io.*;

public class BOJ_2644 {
    static int N;
    static int u;
    static int v;
    static int M;
    static StringTokenizer st;
    static List<Integer>[] graph;
    static boolean flag = false;
    static boolean[] visited;
    static int res;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());

        st=new StringTokenizer(br.readLine());
        u = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        M=Integer.parseInt(br.readLine());

        graph=new ArrayList[N+1];
        visited=new boolean[N+1];

        for(int i=0;i<=N;i++){
            graph[i]=new ArrayList<>();
        }

        for (int i=0;i<M;i++){
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

        visited[u]=true;
        dfs(u, v, 0);


        System.out.println(flag?res:-1);

    }

    public static void dfs(int start, int end, int cnt) {

        if (flag) {
            return;
        }

        if (start == end) {
            flag = true;
            res = cnt;
            return;
        }

        if (!flag) {
            for (int next : graph[start]) {
                if (!visited[next]) {
                    visited[next] = true;
                    dfs(next, end, cnt+1);
                    visited[next] = false;
                }
            }
        }



    }
}
